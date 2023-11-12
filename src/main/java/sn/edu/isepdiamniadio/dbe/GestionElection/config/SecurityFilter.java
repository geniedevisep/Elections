package sn.edu.isepdiamniadio.dbe.GestionElection.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Autorisation;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Role;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.AutorisationRepository;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SecurityFilter implements Filter {

    @Autowired
    private AutorisationRepository autorisationRepository;
    private Map<String, List<String> >urlsFilter;

    public SecurityFilter() {
        urlsFilter=new HashMap<>();
        //url demandant une authentification mais la logique reste
        // si vous commenter  ces deux ligne vous pouvez effectuer ces deux url
        urlsFilter.put("/api/voting/cast-vote",List.of("electeur"));
        urlsFilter.put("/api/results",List.of("candidate"));
    }


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Debut SecurityFilter");
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String uri=httpServletRequest.getRequestURI();
        boolean authRequire=false;
        Set<String> urls=urlsFilter.keySet();
        List<String> requireRoles=new ArrayList<>();
        for (String url:urls){
            if (uri.startsWith(url)){
                authRequire=true;
                requireRoles=urlsFilter.get(url);
            }
        }
        if(authRequire){
            //demande authentification
            String authHeader=httpServletRequest.getHeader("Authorization");
            if (authHeader==null || authHeader.isEmpty()){
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().print("{\"error\":\"vous devez vous authentifierr\"}");
                httpServletResponse.setContentType("application/json");
                System.out.println("Fin SecurityFilter: "+uri+" Non autorisé");
                return;
            }
            System.out.println("Auth header="+authHeader);
            Pattern pattern=Pattern.compile("Bearer (\\w+)",Pattern.CASE_INSENSITIVE);
            Matcher m=pattern.matcher(authHeader);
            if(m.matches()){
                String token=m.group(1);
                Autorisation autorisation=autorisationRepository.findById(token).orElse(null);
                if(autorisation==null){
                    httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                    httpServletResponse.getWriter().print("{\"error\":\"votre token est invalide\"}");
                    return;
                }else{
                    //utilisateur existe verifier le role
                    for (Role r:autorisation.getElecteur().getRoles()){
                        if (requireRoles.contains(r.getCode()));
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                    // System.out.println("utilisateur==>"+autorisation);
                }
                //si on sort de la boucle
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().print("{\"error\":\"vous devez vous authentifierr\"}");
                httpServletResponse.setContentType("application/json");
                System.out.println("Fin SecurityFilter: "+uri+" Non autorisé");
                return;

                // System.out.println("token="+token);

            }else{
                System.out.println("format authorisation incorrect");
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.getWriter().print("{\"error\":\"format de la requete incorrect\"}");
                return;
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //System.out.println("Fin IsepSecurityFilter");
    }
}

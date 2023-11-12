package sn.edu.isepdiamniadio.dbe.GestionElection.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("debut LoggerFilter");
        HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        String uri=httpRequest.getRequestURI();
        String adresse=httpRequest.getRemoteAddr();
        System.out.println("adresse="+adresse);
        System.out.println("uri="+uri);
        filterChain.doFilter(
                servletRequest,
                servletResponse);
        System.out.println("fin LoggerFilter");
    }
}
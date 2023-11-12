package sn.edu.isepdiamniadio.dbe.GestionElection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.GestionElection.PasswordUtil;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Autorisation;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Role;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.AutorisationRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.ElecteurRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.RoleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepository;

  @Autowired
  private AutorisationRepository autorisationRepository;


    public Autorisation login(String login, String password){
        Electeur a=electeurRepository.findByLogin(login);
        String pwdHash= PasswordUtil.genSHA512(password);
        if (a.getPassword().equals(pwdHash)){
            Autorisation resultat=new Autorisation();
            resultat.setToken(genToken());
            resultat.setElecteur(a);
            Date d=new Date();
            resultat.setDateCreation(d);
            Date expire=new Date(d.getTime()+(30*60*1000));
            resultat.setValidite(expire);
            autorisationRepository.save(resultat);
            return resultat;
        }
        return null;
    }


    public List<Electeur> getElecteurs() {
        return electeurRepository.findAll();

    }


    public  Electeur findElecteur(String voterId){
        Optional<Electeur> apprenantOptional=electeurRepository.findById(voterId);
        return apprenantOptional.orElse(null);
    }


    public Electeur ajouterElecteur(Electeur electeur) {
        String hashPwd= PasswordUtil.genSHA512(electeur.getPassword());
        electeur.setPassword(hashPwd);
        return electeurRepository.save(electeur);
    }


    public  void editElecteur(Electeur electeur){
        if (electeur==null || electeur.getVoterId()==null){
            throw new RuntimeException("electeur doit avoir un identifiant");
        }
        electeurRepository.save(electeur);
    }


    public void supprimerElecteur(String voterId) {
        electeurRepository.deleteById(voterId
        );

    }

    public String genToken(){
        String dico="1234567890azertyuiopmlkjhgfdsqwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
        int longueurToken=12;
        String token="";
        Autorisation auth;
        do{
            for(int i=0; i<12; i++){
                int indiceAlea=(int)(Math.random()*dico.length());
                token+=dico.charAt(indiceAlea);
            }
            auth=autorisationRepository.findById(token).orElse(null);

        }while (auth!=null);

        return token;
    }


}

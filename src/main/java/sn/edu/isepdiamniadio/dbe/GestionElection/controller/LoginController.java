package sn.edu.isepdiamniadio.dbe.GestionElection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Autorisation;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.UserDetailsResp;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.VoterLoginRequest;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.ElecteurService;

@RestController
@RequestMapping("/api/voters")
public class LoginController {

    @Autowired
    private ElecteurService electeurServiceAut;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody VoterLoginRequest loginForm){
        System.out.println("authentification de "+loginForm);
        String login=loginForm.getVoterId();
        String pwd=loginForm.getPassword();
        Autorisation res= electeurServiceAut.login(login, pwd);
        if (res==null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("login ou mot de masse incorrecte");
        }
        return ResponseEntity.ok(new UserDetailsResp(res));
    }


}

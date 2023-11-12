package sn.edu.isepdiamniadio.dbe.GestionElection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Role;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.ElecteurRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.RoleRepository;

import java.util.List;

@Component
public class ElectionInit  implements CommandLineRunner {
    @Autowired
    private ElecteurRepository electeurRepositoryElec;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("creation des roles");
        Role roleCandidate =new Role("candidate","Candidate");
        roleRepository.save(roleCandidate);
        Role roleElecteur= new Role("electeur","Electeur");
        roleRepository.save(roleElecteur);
        Electeur candidate=new Electeur("saly","123343","passer1234","voter12","2001-05-0è");
        String hashPwd=PasswordUtil.genSHA512("passer1234");
        candidate.setPassword(hashPwd);
        List<Role> candidateRole=List.of(
                roleCandidate,roleElecteur
        );
        candidate.setRoles(candidateRole);
        electeurRepositoryElec.save(candidate);
    }
}

package sn.edu.isepdiamniadio.dbe.GestionElection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.CandidateRepositoty;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepositoty registerRepositoty;
    public List<Candidate> getCandidats() {
        return registerRepositoty.findAll();

    }


    public  Candidate findCandidate(String candidateId){
        Optional<Candidate> apprenantOptional=registerRepositoty.findById(candidateId);
        return apprenantOptional.orElse(null);
    }


    public Candidate ajouterCandidate(Candidate candidate) {
        return registerRepositoty.save(candidate);
    }


    public  void editCandidate(Candidate candidate){
        if (candidate==null || candidate.getCandidateId()==null){
            throw new RuntimeException("candidate doit avoir un identifiant");
        }
        registerRepositoty.save(candidate);
    }


    public void supprimerCandidate(String candidateId) {
        registerRepositoty.deleteById(candidateId
        );

    }

}

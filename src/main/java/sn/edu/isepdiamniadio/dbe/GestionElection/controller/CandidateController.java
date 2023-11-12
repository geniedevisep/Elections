package sn.edu.isepdiamniadio.dbe.GestionElection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @GetMapping
    public List<Candidate> getCandidates() {
        return candidateService.getCandidats();
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable String id) {
        return candidateService.findCandidate(id);
    }

    @PostMapping
    public Candidate ajouterCandidate(@RequestBody Candidate candidate) {
        return candidateService.ajouterCandidate(candidate);
    }

    @PutMapping("/{id}")
    public void mettreAjourCandidate( @RequestBody Candidate candidate) {
        candidateService.editCandidate(candidate);
    }

    @DeleteMapping("/{id}")
    public void supprimerCandidate(@PathVariable String id) {
        candidateService.supprimerCandidate(id);
    }
}

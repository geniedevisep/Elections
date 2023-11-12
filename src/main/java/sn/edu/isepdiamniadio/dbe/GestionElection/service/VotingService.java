package sn.edu.isepdiamniadio.dbe.GestionElection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.CandidateVote;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Vote;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.CandidateRepositoty;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.ElecteurRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.VoteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ElecteurRepository repository;

    @Autowired
    private CandidateRepositoty candidateRepository;

    public ResponseEntity<String> castVote(String voterId, String candidateId) {
        // Vérifiez si l'électeur et le candidat existent dans la base de données
        Electeur voter = repository.findByVoterId(voterId)
                .orElseThrow(() -> new RuntimeException("Électeur non trouvé"));

        Candidate candidate = candidateRepository.findByCandidateId(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé"));



        // Enregistrez le vote dans la base de données
        Vote vote = new Vote();
        vote.setElecteur(voter);
        vote.setCandidate(candidate);
        voteRepository.save(vote);

        // Incrémentez le nombre de voix du candidat
        candidate.incrementVoteCount();
        candidateRepository.save(candidate);

        // Placeholder pour la réponse
        String responseMessage = String.format("Votre vote pour le candidat %s a été enregistré avec succès", candidate.getName());
        return ResponseEntity.ok(responseMessage);
    }

    public List<CandidateVote> getTopThreeCandidates() {
        List<Candidate> topThreeCandidates = candidateRepository.findTop3ByOrderByVoteCountDesc();

        return topThreeCandidates.stream()
                .map(candidate -> new CandidateVote(candidate.getName(), candidate.getVoteCount()))
                .collect(Collectors.toList());
    }
}


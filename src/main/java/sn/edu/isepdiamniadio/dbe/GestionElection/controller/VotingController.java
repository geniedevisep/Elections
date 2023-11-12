package sn.edu.isepdiamniadio.dbe.GestionElection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.CandidateVote;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.VoteRequest;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.VotingService;

import java.util.List;

@RestController
@RequestMapping("/api/voting")
public class VotingController {
    @Autowired
    private VotingService votingService;

    @PostMapping("/cast-vote")
    public ResponseEntity<String> castVote(@RequestBody VoteRequest voteRequest) {
        ResponseEntity<String> response = votingService.castVote(voteRequest.getVoterId(), voteRequest.getCandidateId());
        return response;
    }

    @GetMapping("/top-three-candidates")
    public ResponseEntity<java.util.List<CandidateVote>> getTopThreeCandidates() {
        List<CandidateVote> topThreeCandidates = votingService.getTopThreeCandidates();
        return ResponseEntity.ok(topThreeCandidates);
    }
}




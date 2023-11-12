package sn.edu.isepdiamniadio.dbe.GestionElection.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.VotingService;

import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private VotingService votingService;

    @Scheduled(fixedRate = 60000) // exécute toutes les minutes
    public void displayTopThreeCandidates() {
        List<CandidateVote> topThreeCandidates = votingService.getTopThreeCandidates();

        // Affichez les candidats dans la console
        System.out.println("Top 3 Candidates:");
        for (CandidateVote candidate : topThreeCandidates) {
            System.out.println(candidate.getCandidateName() + ": " + candidate.getVoteCount() + " votes");
        }
    }
}


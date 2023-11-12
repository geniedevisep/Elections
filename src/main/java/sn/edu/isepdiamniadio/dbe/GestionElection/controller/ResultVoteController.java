package sn.edu.isepdiamniadio.dbe.GestionElection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Vote;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.ResultService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultVoteController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/results")
    public List<Vote> getResultsVote() {
        return resultService.getResultVote();
    }
}

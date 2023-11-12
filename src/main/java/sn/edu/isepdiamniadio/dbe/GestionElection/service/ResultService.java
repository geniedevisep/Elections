package sn.edu.isepdiamniadio.dbe.GestionElection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Vote;
import sn.edu.isepdiamniadio.dbe.GestionElection.repository.ResultRepository;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Vote> getResultVote() {
        return resultRepository.findAll();

    }
}

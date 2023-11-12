package sn.edu.isepdiamniadio.dbe.GestionElection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateRepositoty extends JpaRepository<Candidate,String> {
    Optional<Candidate> findByCandidateId(String candidateId);

    List<Candidate> findTop3ByOrderByVoteCountDesc();
}

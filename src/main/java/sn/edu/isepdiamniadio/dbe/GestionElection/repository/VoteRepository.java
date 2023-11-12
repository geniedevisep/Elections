package sn.edu.isepdiamniadio.dbe.GestionElection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}


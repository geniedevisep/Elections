package sn.edu.isepdiamniadio.dbe.GestionElection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Vote;

public interface ResultRepository extends JpaRepository<Vote, Long> {
}

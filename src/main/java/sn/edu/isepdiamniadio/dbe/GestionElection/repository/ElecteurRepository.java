package sn.edu.isepdiamniadio.dbe.GestionElection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;

import java.util.Optional;

public interface ElecteurRepository  extends JpaRepository<Electeur,String> {
    Optional<Electeur> findByVoterId(String voterId);

    @Query("SELECT a FROM Electeur a where a.voterId=:voterd")
    public Electeur findByLogin(String voterd);
}

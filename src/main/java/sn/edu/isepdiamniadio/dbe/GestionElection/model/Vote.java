package sn.edu.isepdiamniadio.dbe.GestionElection.model;

import jakarta.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private Electeur electeur;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    public Vote() {
    }

    public Vote(Electeur electeur, Candidate candidate) {
        this.electeur = electeur;
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}




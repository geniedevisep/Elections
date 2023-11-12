package sn.edu.isepdiamniadio.dbe.GestionElection.model;




import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Autorisation implements Serializable {
    @Id
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date validite;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Electeur electeur;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getValidite() {
        return validite;
    }

    public void setValidite(Date validite) {
        this.validite = validite;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }
}


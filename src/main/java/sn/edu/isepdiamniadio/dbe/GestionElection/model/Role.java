package sn.edu.isepdiamniadio.dbe.GestionElection.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role  implements Serializable {
    @Id
    private  String code;

    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<Electeur> electeurList;
    @Column(nullable = false,unique = true)
    private String nom;

    public Role() {
    }

    public Role(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public List<Electeur> getElecteurList() {
        return electeurList;
    }

    public void setElecteurList(List<Electeur> electeurList) {
        this.electeurList = electeurList;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


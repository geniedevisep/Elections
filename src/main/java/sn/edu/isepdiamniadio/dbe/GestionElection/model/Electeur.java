package sn.edu.isepdiamniadio.dbe.GestionElection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@Entity
public class Electeur {
    @Id
    private String voterId;
    private String name;
    private String nationalId;

    private String password;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    private String dateOfBirth;

    public Electeur() {
    }

    public Electeur(String name, String nationalId, String password, String voterId, String dateOfBirth) {
        this.name = name;
        this.nationalId = nationalId;
        this.password = password;
        this.voterId = voterId;
        this.dateOfBirth = dateOfBirth;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

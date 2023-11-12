package sn.edu.isepdiamniadio.dbe.GestionElection.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Candidate {
    @Id
    private String candidateId;
    private String name;

    private int voteCount;
    private String party;




    public Candidate(String candidateId, String name, String party) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
    }

    public Candidate() {

    }



    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void incrementVoteCount() {
    }
}

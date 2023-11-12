package sn.edu.isepdiamniadio.dbe.GestionElection.model;

public class VoterLoginRequest {
    private String voterId;
    private String password;

    @Override
    public String toString() {
        return "VoterLoginRequest{" +
                "voterId='" + voterId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters
}

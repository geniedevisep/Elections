package sn.edu.isepdiamniadio.dbe.GestionElection.model;

public class CandidateVote {
    private String candidateName;
    private int voteCount;

    public CandidateVote() {
    }

    public CandidateVote(String candidateName, int voteCount) {
        this.candidateName = candidateName;
        this.voteCount = voteCount;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

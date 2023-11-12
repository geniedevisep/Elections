package sn.edu.isepdiamniadio.dbe.GestionElection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsResp implements Serializable {

    private String voterId;
    private Electeur message;
    private String token;
    private List<Role> roles;
    private List<String> roleList;


    public UserDetailsResp(){}

    public UserDetailsResp(Autorisation autorisation){
        this.voterId=autorisation.getElecteur().getVoterId();
        this.message=autorisation.getElecteur();

        this.token=autorisation.getToken();
        this.roles=autorisation.getElecteur().getRoles();
        roleList=new ArrayList<>();
        for (Role R : roles){
            roleList.add(R.getCode());
        }

    }


    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Electeur getMessage() {
        return message;
    }

    public void setMessage(Electeur message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
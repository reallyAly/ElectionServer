/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public class Urn implements Serializable{
    
    private int urnId;
    
    private ArrayList<Votes> votes;

    public Urn(int urnId, ArrayList<Votes> votes) {
        this.urnId = urnId;
        this.votes = votes;
    }

    public int getUrnId() {
        return urnId;
    }

    public void setUrnId(int urnId) {
        this.urnId = urnId;
    }

    public ArrayList<Votes> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Votes> votes) {
        this.votes = votes;
    }
    
}

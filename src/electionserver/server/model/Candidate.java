/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server.model;

import java.io.Serializable;

/**
 *
 * @author alysson
 */
public class Candidate implements Serializable {
    
    private int id;
    
    private String name;
    
    private int votes;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Candidate() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addVote() {
        this.votes++;
    }
    
    public int getVotes() {
        return this.votes;
    }
    
    public void setVotes(int totalVotes) {
        this.votes = totalVotes;
    }
    
}

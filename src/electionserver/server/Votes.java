/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public class Votes implements Serializable{
     
    private int urnId;
    
    private ArrayList<Candidate> candidates;

    public Votes(int urnId, ArrayList<Candidate> candidates) {
        this.urnId = urnId;
        this.candidates = candidates;
    }

    public int getUrnId() {
        return urnId;
    }

    public void setUrnId(int urnId) {
        this.urnId = urnId;
    }

    public ArrayList<Candidate> getCandidate() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }
    
    public boolean addVoteOnCandidate(int candidateId) {
        
        for(Candidate candidate: this.candidates) {
            if(candidate.getId() == candidateId) {
                candidate.addVote();
                return true;
            }
        }
        
        return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server.model;

import electionserver.server.model.Candidate;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public class Votes implements Serializable{
 
    private ArrayList<Candidate> candidates;

    public Votes(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public ArrayList<Candidate> getCandidates() {
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

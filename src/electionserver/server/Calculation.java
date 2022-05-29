/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Candidate;
import electionserver.server.model.Urn;
import electionserver.server.model.Votes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author alysson
 */
public class Calculation extends Thread{
    
    private JTable candidatesTable;
    
    private ArrayList<Candidate> candidates;
    
    private ArrayList<Urn> urns;
    
    public Calculation(JTable candidatesTable, ArrayList<Urn> urns, ArrayList<Candidate> candidates) {
        this.candidatesTable = candidatesTable;
        this.candidates = candidates;
        this.urns = urns;
    }
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
               if(!this.urns.isEmpty()) {
                   
                    for(Candidate candidate: this.candidates) {
                        for(Urn urn: this.urns){
                            for(Votes votes: urn.getVotes()) {
                                for(Candidate urnCandidate: votes.getCandidates()) {
                                    if(candidate.getId() == urnCandidate.getId()) {
                                       candidate.setVotes(candidate.getVotes() + urnCandidate.getVotes());
                                    }
                                }
                            }
                        }
                    }
               
               }
               
               
               for(int i = 0; i < this.candidates.size(); i++) {
                   this.candidatesTable.setValueAt(this.candidates.get(i).getName(), i, 0);
                   this.candidatesTable.setValueAt(this.candidates.get(i).getVotes(), i, 1);
               }
             
               sleep(5000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Calculation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

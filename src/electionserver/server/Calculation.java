/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Candidate;
import electionserver.server.model.Urn;
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
    
    public Calculation(JTable candidatesTable, ArrayList<Urn> urns, ArrayList<Candidate> candidates) {
        this.candidatesTable = candidatesTable;
        this.candidates = candidates;
    }
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
               ArrayList<Urn> urns = StoreUrns.getUrns();

               if(!urns.isEmpty()) {

                   for(int i = 0; i < this.candidates.size(); i++) {
                       
                       int totalVotes = 0;
                       
                       Candidate cand = this.candidates.get(i);
                       
                       for(int j = 0; j < urns.size(); j++) {
                           
                           ArrayList<Candidate> candidates = urns.get(j).getVotes().getCandidates();
                           
                           for(int k = 0; k < candidates.size(); k++){
                               
                               if(cand.getId() == candidates.get(k).getId())
                                   totalVotes += candidates.get(k).getVotes();
                               }
                               
                           }
                       
                        this.candidatesTable.setValueAt(this.candidates.get(i).getName(), i, 0);
                        this.candidatesTable.setValueAt(totalVotes, i, 1);
                        
                       }
                   }
               sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Calculation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}

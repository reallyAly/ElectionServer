/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Urn;
import electionserver.server.model.Candidate;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTable;
import java.rmi.Naming;

/**
 *
 * @author alysson
 */
public class Server extends UnicastRemoteObject implements  ElectionInterface{
    
    private ArrayList<Urn> urns = new ArrayList<>();
    
    private ArrayList<Candidate> candidates;
    
    private JTable candidatesTable;
    
    public Server(JTable candidatesTable) throws RemoteException {
        super();
        this.candidatesTable = candidatesTable;
    }
   
    @Override
    public boolean sendVotes(Urn urn) throws RemoteException{
        
        if(!this.urns.isEmpty()){
            for(int i = 0; i < this.urns.size(); i++) {
                if(urn.getUrnId() == this.urns.get(i).getUrnId()){
                    this.urns.add(i, urn);
                }
            }
        }else{
            this.urns.add(urn);
        }
        
        return true;
    }

    @Override
    public ArrayList<Candidate> getCandidates() throws RemoteException{
        return this.candidates;
    }
    
    public void setCandidates(ArrayList<Candidate> candidates) {
         this.candidates = candidates;
    }
    
    public void startServer(ArrayList<Candidate> candidates) throws IllegalArgumentException, MalformedURLException, RemoteException {
        
        if(candidates.isEmpty()) {
            throw new IllegalArgumentException("Please, add at least two candidates");
        }
        
        // My names server
        Registry register = LocateRegistry.createRegistry(1099);
            
        Naming.rebind("electionserver", new Server(this.candidatesTable));
            
        Thread calculation = new Thread(new Calculation(this.candidatesTable, this.urns, this.candidates));
                    
        calculation.start();
      
        System.out.println("Waiting for requests...");
    }
    
}

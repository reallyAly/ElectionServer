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
    
    private Candidate candidate;
    
    public Server(JTable candidatesTable, ArrayList<Candidate> candidates) throws RemoteException {
        super();
        this.candidatesTable = candidatesTable;
        this.candidates = candidates;
    }
   
    @Override
    public boolean sendVotes(Urn urn) throws RemoteException{
        
        if(!this.urns.isEmpty()){
            
            for(int i = 0; i < this.urns.size(); i++) {
                
                if(urn.getUrnId() == this.urns.get(i).getUrnId()){
                    this.urns.set(i, urn);
                }
                
            }
            
            StoreUrns.setUrns(this.urns);
            
        }else{
            this.urns.add(urn);
            StoreUrns.setUrns(this.urns);
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
    
    public void startServer() throws IllegalArgumentException, MalformedURLException, RemoteException, InterruptedException {
        
        if(this.candidates.isEmpty() || this.candidates.size() < 2) {
            throw new IllegalArgumentException("Please, add at least two candidates");
        }
        
        // My names server
        Registry register = LocateRegistry.createRegistry(1099);
            
        Naming.rebind("electionserver", new Server(this.candidatesTable, this.candidates));
            
        Thread calculation = new Thread(new Calculation(this.candidatesTable, this.urns, this.candidates));
                    
        calculation.start();
        
        System.out.println("Waiting for requests...");
    }
    
    @Override
    public void sayHello()
    {
        System.out.println("Hello Dev");
    }
    
}

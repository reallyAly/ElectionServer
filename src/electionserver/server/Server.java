/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Urn;
import electionserver.server.model.Candidate;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alysson
 */
public class Server implements ElectionInterface{
    
    private ArrayList<Urn> urns;
    
    private ArrayList<Candidate> candidates;

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
    
    public void addCandidate(Candidate candidate) {
         this.candidates.add(candidate);
    }
    
    public void startServer(ArrayList<Candidate> candidates) throws IllegalArgumentException {
        
        if(candidates.isEmpty()) {
            throw new IllegalArgumentException("Please, add at least two candidates");
        }
        
        try {
            Server s = new Server();
            
            // My Skeleton
            ElectionInterface skeleton = (ElectionInterface) UnicastRemoteObject.exportObject(s, 0);
            
            // My names server
            Registry register = LocateRegistry.createRegistry(1099);
            
            register.bind("electionserver", skeleton);
            
            System.out.println("Waiting for requests...");
            
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

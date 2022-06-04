/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import electionserver.server.ElectionInterface;
import java.rmi.NotBoundException;
import electionserver.server.model.Candidate;
import electionserver.server.model.Urn;
import electionserver.server.model.Votes;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;
import java.rmi.Naming;

/**
 *
 * @author alysson
 */
public class Client {
    
    private ArrayList<Candidate> candidates;
    
    private ElectionInterface stub = null;
    
    private Votes votes;
    
    private Urn urn;
    
    public ElectionInterface connect() throws RemoteException, NotBoundException, IllegalCallerException, MalformedURLException {
        
        if(stub!=null){
            throw new IllegalCallerException("The connection was established previously");
        }
        
        Registry register = LocateRegistry.getRegistry("localhost", 1099);  
        
        ElectionInterface stub = (ElectionInterface) Naming.lookup("rmi://127.0.0.1/electionserver");
        
        this.stub = stub;
        this.candidates = stub.getCandidates();
        
        Random random = new Random();
        
        this.votes = new Votes(stub.getCandidates());
        
        this.urn = new Urn(random.nextInt(1000000), null);
        
        return stub;
        
    }
    
    public ElectionInterface getStub() {
        return this.stub;
    }
    
    public ArrayList<Candidate> getCandidates() {
        return this.candidates;
    }
    
    public boolean processVote(int candidateCode) throws RemoteException {
        
        for(Candidate candidate: this.candidates) {
            if(candidate.getId() == candidateCode) {
                this.votes.addVoteOnCandidate(candidateCode);
            }
        }
        
        this.urn.setVotes(this.votes);
        
        return this.stub.sendVotes(this.urn);
    }
    
    public Candidate checkCandidate(int candidateCode) {
        for(Candidate candidate: this.candidates) {
            if(candidate.getId() == candidateCode) {
                return candidate;
            }
        }
        
        return null;
    }
    
}

package electionserver.server;

import electionserver.server.model.Urn;
import electionserver.server.model.Candidate;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public interface ElectionInterface extends Remote{
    
    public boolean sendVotes(Urn urn) throws RemoteException;
            
    public ArrayList<Candidate> getCandidates() throws RemoteException;
    
}

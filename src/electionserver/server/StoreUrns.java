/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Urn;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public class StoreUrns {
    private static ArrayList<Urn> updatedUrns = new ArrayList<>();
    
    private static boolean hasBeenUpdated = false;
    
    public static void setUrns(ArrayList<Urn> urns){
        updatedUrns = urns;
    }
   
    public static ArrayList<Urn> getUrns() {
        return updatedUrns;
    }
}

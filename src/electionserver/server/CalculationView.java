/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package electionserver.server;

import electionserver.server.model.Candidate;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author alysson
 */
public class CalculationView extends javax.swing.JFrame {
    
    private ArrayList<Candidate> candidates;
    
    private Server server;

    /**
     * Creates new form ServerView
     * @param candidates
     * @throws java.rmi.RemoteException
     * @throws java.net.MalformedURLException
     */
    public CalculationView(ArrayList<Candidate> candidates) throws RemoteException, IllegalArgumentException, MalformedURLException {
        
        initComponents();
        
        this.server = new Server(this.candidatesTable);
        
        this.server.setCandidates(candidates);
        
        this.server.startServer(candidates);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        candidatesTable = new javax.swing.JTable();
        electionServerTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        closeVoteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        candidatesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Candidate", "Total Votes"
            }
        ));
        jScrollPane1.setViewportView(candidatesTable);

        electionServerTitle.setFont(new java.awt.Font("Fira Sans Compressed SemiBold", 1, 24)); // NOI18N
        electionServerTitle.setText("ELECTION SERVER");

        jLabel1.setFont(new java.awt.Font("Fira Sans", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Election in progress...");

        closeVoteButton.setText("Close Vote");
        closeVoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeVoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(electionServerTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(closeVoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(electionServerTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(closeVoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeVoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeVoteButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeVoteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable candidatesTable;
    private javax.swing.JButton closeVoteButton;
    private javax.swing.JLabel electionServerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

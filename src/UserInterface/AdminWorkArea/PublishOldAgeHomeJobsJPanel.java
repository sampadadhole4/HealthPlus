/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Job.Job;
import Business.Job.JobDirectory;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vardhana Bhatt
 */
public class PublishOldAgeHomeJobsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PublishOldAgeHomeJobsJPanel
     */
    private JPanel userProcessContainer;
    private JobDirectory jobDirectory;
    private UserAccount userAccount;
    private EcoSystem system;
    
    public PublishOldAgeHomeJobsJPanel(JPanel userProcessContainer, JobDirectory jobDirectory, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.jobDirectory = jobDirectory;
        this.userAccount = userAccount;
        this.system = system;
        populateTable();
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblJobs.getModel();
        model.setRowCount(0);

        if (jobDirectory != null) {
            for (Job job : jobDirectory.getJobList()) {
                Object[] row = new Object[5];
          
                for (Country c : system.getNetworkList()) {
                    for (State s : c.getStateList()) {
                        for (City city : s.getCityList()) {
                            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                    if (userAccount.getUsername().equals(ua.getUsername())) {
                                        if (e.equals(job.getEnterprise())) {
                                            row[0] = c;
                                            row[1] = s;
                                            row[2] = city;
                                            row[3] = job.getEnterprise();
                                            row[4] = job;
                                            model.addRow(row);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }    
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblJobs = new javax.swing.JTable();
        btnDeleteJob = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtFldName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 243, 218));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Publish Jobs");

        tblJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Country", "State", "City", "Old Age Home", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJobs.setMinimumSize(new java.awt.Dimension(375, 0));
        tblScrollPane.setViewportView(tblJobs);

        btnDeleteJob.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteJob.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btnDeleteJob.setText("Delete Job");
        btnDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        lblName.setText("Job Title:");

        txtFldName.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N

        btnSubmit.setBackground(new java.awt.Color(113, 160, 160));
        btnSubmit.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(506, 506, 506)
                            .addComponent(btnDeleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(269, 269, 269)
                            .addComponent(lblName)
                            .addGap(37, 37, 37)
                            .addComponent(txtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(329, 329, 329)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteJob)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(txtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnSubmit)
                .addContainerGap(305, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblJobs.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the Job?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Job job = (Job) tblJobs.getValueAt(selectedRow, 4);

                system.getJobDirectory().removeJob(job);
                populateTable();
                JOptionPane.showMessageDialog(null, "Job deleted successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteJobActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String name = txtFldName.getText();
        if (!name.equals("")) {

            // validate name
            String regex = "^[a-z A-Z]+$";
            Pattern namePattern = Pattern.compile(regex);
            Matcher nameMatcher = namePattern.matcher(name);

            if (!nameMatcher.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid characters in job title", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if(name.equalsIgnoreCase("CareTaker") || name.equalsIgnoreCase("Doctor")){
                for (Country c : system.getNetworkList()) {
                    for (State s : c.getStateList()) {
                        for (City cy : s.getCityList()) {
                            for (Enterprise e : cy.getEnterpriseDirectory().getEnterpriseList()) {
                                for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                    if (ua.getUsername().equals(userAccount.getUsername())) {
                                        Job job = jobDirectory.createJob(name);
                                        job.setEnterprise(e);
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Job can be posted for 'CareTaker' or 'Doctor' position only", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            populateTable();
            txtFldName.setText("");
            JOptionPane.showMessageDialog(null, "Job posted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter text", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteJob;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblJobs;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtFldName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ManagerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.IssueWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karishma
 */
public class ViewIssuesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewIssues
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    public ViewIssuesJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        populateViewIssuesTable();
    }

    public void populateViewIssuesTable() {
        DefaultTableModel model = (DefaultTableModel) tblViewIssues.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof IssueWorkRequest) {
                Object[] row = new Object[7];
                row[0] = request;
                row[1] = ((IssueWorkRequest) request).getDescription();
                row[2] = ((IssueWorkRequest) request).getCountry();
                row[3] = ((IssueWorkRequest) request).getState();
                row[4] = ((IssueWorkRequest) request).getCity();
                if(request.getSender().getEmployee()== null)
                row[5] = request.getSender().getApplicant().getName();
                else
                row[5] = request.getSender().getEmployee().getName();      
                row[6] = request.getStatus();
                model.addRow(row);
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
        btnResolveIssue = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewIssues = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-button.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 40));

        btnResolveIssue.setBackground(new java.awt.Color(113, 160, 160));
        btnResolveIssue.setText("Resolve Issue");
        btnResolveIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveIssueActionPerformed(evt);
            }
        });
        add(btnResolveIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 120, 30));

        tblViewIssues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Description", "Country", "State", "City", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblViewIssues);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 630, 270));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("View Issues");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 220, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnResolveIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolveIssueActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblViewIssues.getSelectedRow();
        if (selectedRow >= 0) {
        WorkRequest workRequest = (WorkRequest) tblViewIssues.getValueAt(selectedRow, 0);
        workRequest.setStatus("Resolved");
        workRequest.setReceiver(userAccount);
        populateViewIssuesTable();
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnResolveIssueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnResolveIssue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblViewIssues;
    // End of variables declaration//GEN-END:variables
}

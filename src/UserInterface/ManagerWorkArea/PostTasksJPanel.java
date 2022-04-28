/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManagerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PostTaskWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karishma
 */
public class PostTasksJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PostTasks
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    public PostTasksJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblPostTasks.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof PostTaskWorkRequest) {
                Object[] row = new Object[5];
                row[0] = (PostTaskWorkRequest)request;
                row[1] = ((PostTaskWorkRequest) request).getTask();
                row[2] = request.getReceiver();
                row[3] = request.getStatus();
                String workDone = ((PostTaskWorkRequest) request).getWorkDone();
                row[4] = workDone == null ? "Waiting" : workDone;

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

        btnPostTasks = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPostTasks = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPostTasks.setBackground(new java.awt.Color(113, 160, 160));
        btnPostTasks.setText("Post Task");
        btnPostTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostTasksActionPerformed(evt);
            }
        });
        add(btnPostTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 140, -1));

        btnRefresh.setBackground(new java.awt.Color(113, 160, 160));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-button.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 40));

        tblPostTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Name", "Task", "Receiver", "Status", "Work Done"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPostTasks);
        if (tblPostTasks.getColumnModel().getColumnCount() > 0) {
            tblPostTasks.getColumnModel().getColumn(0).setResizable(false);
            tblPostTasks.getColumnModel().getColumn(1).setResizable(false);
            tblPostTasks.getColumnModel().getColumn(2).setResizable(false);
            tblPostTasks.getColumnModel().getColumn(3).setResizable(false);
            tblPostTasks.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 670, 210));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Tasks");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 290, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostTasksActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        AddPostTasksJPanel aptjp = new AddPostTasksJPanel(userProcessContainer, userAccount, organization,enterprise);
        userProcessContainer.add("AddPostTasksJPanel",aptjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnPostTasksActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPostTasks;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblPostTasks;
    // End of variables declaration//GEN-END:variables
}

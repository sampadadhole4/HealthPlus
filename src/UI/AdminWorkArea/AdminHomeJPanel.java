/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.AdminWorkArea;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.EmployeeViewArea.EmployeeViewAreaJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author Vardhana Bhatt
 */
public class AdminHomeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminHomeJPanel
     */
    private JPanel mainContainer;
    private EcoSystem system;
    private DB4OUtil dB4OUtil;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Organization organization;
    
    
    
    public AdminHomeJPanel(JPanel mainContainer, EcoSystem system, DB4OUtil dB4OUtil, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        this.mainContainer = mainContainer;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        
        try{
        if(enterprise.getEnterpriseType().getValue().equals("Trust")){
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            AdminWorkAreaJPanel awajp = new AdminWorkAreaJPanel(userProcessContainer, userAccount, enterprise, system);
            userProcessContainer.add("awajp", awajp);
            cardLayout.next(userProcessContainer);
        }
        else{
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            OldAgeHomeAdminWorkAreaJPanel abcd = new OldAgeHomeAdminWorkAreaJPanel(userProcessContainer, userAccount, enterprise, system);
            userProcessContainer.add("abcd", abcd);
            cardLayout.next(userProcessContainer);
        }
        }catch(NullPointerException ex){
            System.out.println("Admin not found");
            CardLayout cardLayout = (CardLayout) mainContainer.getLayout();
            mainContainer.remove(this);
            cardLayout.previous(mainContainer);
            dB4OUtil.storeSystem(system);
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

        splitPane = new javax.swing.JSplitPane();
        controlJPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnWorkArea = new javax.swing.JButton();
        btnViewArea = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userProcessContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        controlJPanel.setBackground(new java.awt.Color(204, 204, 255));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnWorkArea.setBackground(new java.awt.Color(255, 255, 255));
        btnWorkArea.setText("Work Area");
        btnWorkArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnWorkArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkAreaActionPerformed(evt);
            }
        });

        btnViewArea.setBackground(new java.awt.Color(255, 255, 255));
        btnViewArea.setText("View Area");
        btnViewArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAreaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gif1.png"))); // NOI18N

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlJPanelLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnViewArea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWorkArea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnLogout)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnWorkArea)
                .addGap(18, 18, 18)
                .addComponent(btnViewArea)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(controlJPanel);

        userProcessContainer.setBackground(new java.awt.Color(255, 255, 255));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) mainContainer.getLayout();
        mainContainer.remove(this);
        cardLayout.previous(mainContainer);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAreaActionPerformed
        // TODO add your handling code here:

        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        EmployeeViewAreaJPanel evajp = new EmployeeViewAreaJPanel(userProcessContainer, system, dB4OUtil, userAccount, organization, enterprise);
        userProcessContainer.add("evajp", evajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewAreaActionPerformed

    private void btnWorkAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkAreaActionPerformed
        // TODO add your handling code here:

        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        AdminWorkAreaJPanel awajp = new AdminWorkAreaJPanel(userProcessContainer, userAccount, enterprise, system);
        userProcessContainer.add("awajp", awajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnWorkAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewArea;
    private javax.swing.JButton btnWorkArea;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
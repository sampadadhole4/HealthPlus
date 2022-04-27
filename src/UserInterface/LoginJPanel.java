/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GuestWorkArea.GuestWorkAreaJPanel;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shalini
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    private JPanel mainContainer;
    private EcoSystem system;
    private DB4OUtil dB4OUtil;
    public LoginJPanel(JPanel mainContainer, EcoSystem system, DB4OUtil dB4OUtil) {
        initComponents();
        this.mainContainer = mainContainer;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblTitel = new javax.swing.JLabel();
        txtFldUserName = new javax.swing.JTextField();
        passFld = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnGuestLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 248, 245));
        setMaximumSize(new java.awt.Dimension(900, 900));
        setMinimumSize(new java.awt.Dimension(900, 900));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserName.setText("User Name:");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        lblPassword.setText("Password:");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, -1));

        lblTitel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitel.setText("MediCare System");
        add(lblTitel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 280, 50));

        txtFldUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldUserNameActionPerformed(evt);
            }
        });
        add(txtFldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 120, -1));
        add(passFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 120, -1));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 150, 30));

        btnGuestLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnGuestLogin.setText("Sign in as Guest");
        btnGuestLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuestLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestLoginActionPerformed(evt);
            }
        });
        add(btnGuestLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health-professional-team.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 470, 430));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-icon.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(235, 215));
        jLabel3.setMinimumSize(new java.awt.Dimension(235, 215));
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 195));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 200, 200));

        jTextArea2.setBackground(new java.awt.Color(250, 246, 227));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(0, 51, 255));
        jTextArea2.setRows(5);
        jTextArea2.setText("\n  Contact us:\n  Email address : medicaresystem@gmail.com");
        jTextArea2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 770, 360, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
         // Get user name
        String userName = txtFldUserName.getText();
        // Get Password
        char[] passwordCharArray = passFld.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        if(userName.equals("") || password.equals("")){
           JOptionPane.showMessageDialog(null, "Please enter values for user name and password", "Warning", JOptionPane.WARNING_MESSAGE);
           return; 
        }
        // validate username
        String regex = "^[a-z A-Z]+$";
        Pattern namePattern = Pattern.compile(regex);
        Matcher nameMatcher = namePattern.matcher(userName);
        
        if(!nameMatcher.matches()){
             JOptionPane.showMessageDialog(null, "Invalid characters in user name", "Warning", JOptionPane.WARNING_MESSAGE);
             return;
        }

        //step1: check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        
        Enterprise inEnterprise = null;
        Organization inOrganization = null;

            if(userAccount !=null && !(userAccount.getRole().getName().equals("Applicant Type") || userAccount.getUsername().equals("sys"))){
              // step 2: go inside each network and check each enterprise
                        for(Country network: system.getNetworkList()){
                            for(State s: network.getStateList()){
                                for(City c: s.getCityList()){
                                       //Step 2-a: Check against each enterprise
                                        for (Enterprise enterprise : c.getEnterpriseDirectory().getEnterpriseList()) {
                                            UserAccount ua_e = enterprise.getUserAccountDirectory().authenticateUser(userName, password); // sys admin
                                            
                                            if(ua_e != null){ // loop in onky if the user account is not null 
                                                if (ua_e.getUsername().equals(userAccount.getUsername()) &&
                                                    !ua_e.getRole().getName().equals("Admin Type")) {
                                                //Step3: Check against each organization inside that enterprise
                                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                                    UserAccount ua = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                                    if (ua != null) {
                                                        inEnterprise = enterprise;
                                                        inOrganization = organization;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                inEnterprise = enterprise;
                                                break;
                                            }
                                            if (inOrganization != null) {
                                                break;
                                            }
                                            }
                                            
                                        }

                                }    
                            }
                        }
            }
        if(userAccount == null){
            JOptionPane.showMessageDialog(null, "User name and password are case sensitive."
                    + "Enter valid credentials", "Warning", JOptionPane.WARNING_MESSAGE);
            txtFldUserName.setText("");
            passFld.setText("");
            return;
        }else{
            // clearing login fields
            txtFldUserName.setText("");
            passFld.setText("");
            CardLayout cardLayout = (CardLayout) mainContainer.getLayout();
            mainContainer.add("workArea",userAccount.getRole().createWorkArea(mainContainer, system, dB4OUtil, userAccount, inOrganization, inEnterprise));
            cardLayout.next(mainContainer);   
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnGuestLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestLoginActionPerformed
        // TODO add your handling code here:
        txtFldUserName.setText("");
        passFld.setText("");
        CardLayout cardLayout = (CardLayout) mainContainer.getLayout();
        GuestWorkAreaJPanel gwajp = new GuestWorkAreaJPanel(mainContainer,system, dB4OUtil);
        mainContainer.add("GuestWorkAreaJPanel",gwajp);
        cardLayout.next(mainContainer);
    }//GEN-LAST:event_btnGuestLoginActionPerformed

    private void txtFldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldUserNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuestLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JTextField txtFldUserName;
    // End of variables declaration//GEN-END:variables
}

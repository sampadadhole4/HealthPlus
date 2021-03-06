/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GuestWorkArea;

import Business.Applicant.Applicant;
import Business.Applicant.ApplicantDirectory;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Role.ApplicantRole;
import Business.UserAccount.UserAccount;
import UI.ApplicantWorkArea.ApplicantHomeJPanel;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shalini
 */
public class IssueSignUpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IssueSignUpJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private DB4OUtil dB4OUtil;

    public IssueSignUpJPanel(JPanel userProcessContainer, EcoSystem system, DB4OUtil dB4OUtil) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
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

        lblHeader = new javax.swing.JLabel();
        btnAddAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        confirmPassFld = new javax.swing.JPasswordField();
        passFld = new javax.swing.JPasswordField();
        lblName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Sign Up");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 310, 50));

        btnAddAccount.setBackground(new java.awt.Color(113, 160, 160));
        btnAddAccount.setText("Add Account");
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });
        add(btnAddAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-button.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 150, -1));

        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("User Name");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 90, -1));

        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConfirmPassword.setText("Confirm Password");
        add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 140, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 150, -1));
        add(confirmPassFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 150, -1));
        add(passFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 150, -1));

        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signup.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 510, 440));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.gif"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        // TODO add your handling code here:

        try {
            String name = txtName.getText();
            String userName = txtUserName.getText();

            //Getting the password
            char[] passwordCharArray = passFld.getPassword();
            String password = String.valueOf(passwordCharArray);

            char[] confirmPasswordCharArray = confirmPassFld.getPassword();
            String confirmPassword = String.valueOf(confirmPasswordCharArray);

            if (userName.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter values for user name", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter values for password", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (confirmPassword.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter values for confirm password", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // validate username
            String regex = "^[a-z A-Z]+$";
            Pattern namePattern = Pattern.compile(regex);
            Matcher nameMatcher = namePattern.matcher(userName);

            if (!nameMatcher.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid characters in user name", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // check if password and confirmPassword are same
            if (!(password.equals(confirmPassword))) {
                JOptionPane.showMessageDialog(null, "Please enter same password in both password fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // check if password length is between 4-10 or give error
            if (password.length() > 10) {
                JOptionPane.showMessageDialog(null, "Password should not have more than 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (password.length() < 4) {
                JOptionPane.showMessageDialog(null, "Password should have 4 to 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                UserAccount userAccount = system.getUserAccountDirectory().createUserAccount(userName, password, null, new ApplicantRole());
                Applicant applicant = system.getApplicantDirectory().createApplicant(name);
                userAccount.setApplicant(applicant);

                JOptionPane.showMessageDialog(null, "User account added successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

//                CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
//                RaiseIssueJPanel rijp = new RaiseIssueJPanel(userProcessContainer, userAccount, system);
//                userProcessContainer.add("rijp", rijp);
//                cardLayout.next(userProcessContainer);
                CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
                ApplicantHomeJPanel ahjp = new ApplicantHomeJPanel(userProcessContainer, system, dB4OUtil, userAccount);
                userProcessContainer.add("ahjp", ahjp);
                cardLayout.next(userProcessContainer);
            } else {
                JOptionPane.showMessageDialog(null, "Username already exists. Kindly use another username", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unhandled Exception", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnBack;
    private javax.swing.JPasswordField confirmPassFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

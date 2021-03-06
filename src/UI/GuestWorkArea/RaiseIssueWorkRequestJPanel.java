/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GuestWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.IssueWorkRequest;
import Business.WorkQueue.JobWorkRequest;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shalini
 */
public class RaiseIssueWorkRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    private String issue;
    
    /**
     * Creates new form RaiseIssueWorkRequestJPanel
     */
    public RaiseIssueWorkRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, String issue, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.issue = issue;
        populateCountry();
        populateState();
        populateCity();
        populateTrust();
    }

     private void populateCountry(){
        
         cbCountry.removeAllItems();
        
        for (Country c : system.getNetworkList()){
            cbCountry.addItem(c);
        }
        
    }
     
    private void populateState(){
        
        cbState.removeAllItems();
        if(cbCountry.getSelectedItem() != null){
           for (Country c : system.getNetworkList()){
            if(c.equals(cbCountry.getSelectedItem())){
                  for(State s: c.getStateList()){
                        cbState.addItem(s);
                    }
            }
                  
        }
        }
       
        
    }
    
    private void populateCity(){
        
         cbCity.removeAllItems();
         
       if (cbState.getSelectedItem() != null){
        for (Country c : system.getNetworkList()){
            for(State s: c.getStateList()){
                if(s.equals(cbState.getSelectedItem())){
                    for(City city :  s.getCityList()){
                    cbCity.addItem(city);
                     }
                }    
            }
        }
       } 
    }
    
     private void populateTrust(){
        
         cbTrust.removeAllItems();
         
        if (cbCity.getSelectedItem() != null){
        for (Country c : system.getNetworkList()){
            for(State s: c.getStateList()){
                for(City city :  s.getCityList()){
                     if(city.equals(cbCity.getSelectedItem())){
                          for(Enterprise e: city.getEnterpriseDirectory().getEnterpriseList()){
                              if(e.getEnterpriseType().getValue().equals("Trust")){
                                cbTrust.addItem(e);
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

        lblHeader = new javax.swing.JLabel();
        lblIssue = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        txtAreaIssue = new javax.swing.JTextArea();
        btnRaiseIssue = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        cbTrust = new javax.swing.JComboBox();
        cbCountry = new javax.swing.JComboBox();
        cbCity = new javax.swing.JComboBox();
        cbState = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblNGO = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Issue Request");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 460, 26));

        lblIssue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIssue.setText("Description:");
        add(lblIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 109, 30));

        txtAreaIssue.setColumns(20);
        txtAreaIssue.setLineWrap(true);
        txtAreaIssue.setRows(5);
        txtAreaIssue.setToolTipText("");
        txtAreaIssue.setWrapStyleWord(true);
        jScrollPane.setViewportView(txtAreaIssue);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 419, -1));

        btnRaiseIssue.setBackground(new java.awt.Color(113, 160, 160));
        btnRaiseIssue.setText("Request");
        btnRaiseIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaiseIssueActionPerformed(evt);
            }
        });
        add(btnRaiseIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 95, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-button.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 40, 40));

        cbTrust.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbTrust, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 150, -1));

        cbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });
        add(cbCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 150, -1));

        cbCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCityActionPerformed(evt);
            }
        });
        add(cbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 150, -1));

        cbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStateActionPerformed(evt);
            }
        });
        add(cbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 150, -1));

        lblCountry.setText("Select Country:");
        add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, 20));

        lblState.setText("Select State:");
        add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, 20));

        lblCity.setText("Select City:");
        add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, 20));

        lblNGO.setText("Select Trust:");
        add(lblNGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRaiseIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaiseIssueActionPerformed
        // TODO add your handling code here:
     
       // String country="", state="", city="";
        Enterprise enterprise = (Enterprise) cbTrust.getSelectedItem();
                
        Country country= (Country) cbCountry.getSelectedItem();
        String countryStr = country.toString();
        State state = (State) cbState.getSelectedItem();
        String stateStr = state.toString();
        City city = (City) cbCity.getSelectedItem();
        String cityStr = city.toString();
        String desc = txtAreaIssue.getText();
        
        if(desc.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter description", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
         // validate text
        String regex = "^[a-z A-Z 0-9 \n]+$";
        Pattern namePattern = Pattern.compile(regex);
        Matcher nameMatcher = namePattern.matcher(desc);
        
        if(!nameMatcher.matches()){
             JOptionPane.showMessageDialog(null, "Invalid characters in description", "Warning", JOptionPane.WARNING_MESSAGE);
             return;
        }
    
        IssueWorkRequest request = new IssueWorkRequest();
        request.setCity(cityStr);
        request.setState(stateStr);
        request.setCountry(countryStr);
        request.setDescription(desc);
        request.setType(issue);
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ManagerOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        txtAreaIssue.setText("");
        JOptionPane.showMessageDialog(null, "Request submitted successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnRaiseIssueActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
        populateState();
    }//GEN-LAST:event_cbCountryActionPerformed

    private void cbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStateActionPerformed
        // TODO add your handling code here:
         populateCity();
    }//GEN-LAST:event_cbStateActionPerformed

    private void cbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCityActionPerformed
        // TODO add your handling code here:
         populateTrust();
    }//GEN-LAST:event_cbCityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRaiseIssue;
    private javax.swing.JComboBox cbCity;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JComboBox cbState;
    private javax.swing.JComboBox cbTrust;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIssue;
    private javax.swing.JLabel lblNGO;
    private javax.swing.JLabel lblState;
    private javax.swing.JTextArea txtAreaIssue;
    // End of variables declaration//GEN-END:variables
}

/**
 *
 * @author patri
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginGUI extends javax.swing.JFrame {
    private String EMP_ID;
    private String isManager;
    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        txtEmpID.setOpaque(false);
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnForgotPass.setOpaque(false);
        btnForgotPass.setContentAreaFilled(false);
        btnForgotPass.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmpID = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnForgotPass = new javax.swing.JButton();
        txtEmpPass = new javax.swing.JPasswordField();
        lblLoginScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmpID.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        txtEmpID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(txtEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 380, 400, 40));

        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 230, 70));

        btnForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPassActionPerformed(evt);
            }
        });
        getContentPane().add(btnForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, 210, 20));

        txtEmpPass.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        txtEmpPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(txtEmpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 470, 400, 40));

        lblLoginScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLoginScreen.png"))); // NOI18N
        getContentPane().add(lblLoginScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 1330, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        EMP_ID = txtEmpID.getText();
        SessionManager.setLoggedInUserID(EMP_ID);
        
        String EMP_PASS = new String(txtEmpPass.getPassword());
        String EMPFIRSTNAME = null;
        try {
            try {
                EMPFIRSTNAME = MainTrackDB.authenticateEmployee(EMP_ID, EMP_PASS);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (EMPFIRSTNAME != null) {
            JOptionPane.showMessageDialog(null, "Authentication successful. Welcome!");
            try {
                isManager = MainTrackDB.authenticateManager(EMP_ID, EMP_PASS);
                if (isManager.equals("N")){
                    SessionManager.setLoggedInUserName(EMPFIRSTNAME);
                    System.out.print(SessionManager.getLoggedInUserID());
                    dispose();

                    LandingPageGUI newGUI = new LandingPageGUI();
                    newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    newGUI.setVisible(true);
                }
                else {
                    SessionManager.setLoggedInUserName(EMPFIRSTNAME);
                    System.out.print(SessionManager.getLoggedInUserID());
                    dispose();

                    ManagerLandingGUI newGUI = new ManagerLandingGUI();
                    newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    newGUI.setVisible(true);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else {
            JOptionPane.showMessageDialog(null, "Authentication Failed.\nCheck credentials before trying again.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPassActionPerformed
        JOptionPane.showMessageDialog(null, "Contact System Admin / Manager for issues with Employee ID or Password.");
    }//GEN-LAST:event_btnForgotPassActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgotPass;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblLoginScreen;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JPasswordField txtEmpPass;
    // End of variables declaration//GEN-END:variables
}
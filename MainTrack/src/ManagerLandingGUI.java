/**
 *
 * @author patri
 */
import java.awt.Color;

public class ManagerLandingGUI extends javax.swing.JFrame {
    private final String EMPFIRSTNAME = SessionManager.getLoggedInUserName();   
    /**
     * Creates new form LandingPageGUI
     */
    public ManagerLandingGUI() {
        initComponents();
        
        if (EMPFIRSTNAME == null) {
            lblEmpName.setText("Spider-Man");
        }
        else {
            lblEmpName.setText(EMPFIRSTNAME.toUpperCase());
        }
        btnCheckIn.setOpaque(false);
        btnCheckIn.setContentAreaFilled(false);
        btnCheckIn.setBorderPainted(false);
        btnCheckOut.setOpaque(false);
        btnCheckOut.setContentAreaFilled(false);
        btnCheckOut.setBorderPainted(false);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        lblEmpManagement = new javax.swing.JLabel();
        lblEmpName = new javax.swing.JLabel();
        lblLandingPage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(1446, 810));
        setResizable(false);
        getContentPane().setLayout(null);

        btnCheckIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheckIn);
        btnCheckIn.setBounds(170, 480, 380, 80);

        btnCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheckOut);
        btnCheckOut.setBounds(890, 480, 390, 80);

        lblEmpManagement.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblEmpManagement.setForeground(new java.awt.Color(0, 153, 255));
        lblEmpManagement.setText("<html><u>Employee Management<u><html>");
        lblEmpManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmpManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmpManagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEmpManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEmpManagementMouseExited(evt);
            }
        });
        getContentPane().add(lblEmpManagement);
        lblEmpManagement.setBounds(640, 680, 170, 40);

        lblEmpName.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        lblEmpName.setForeground(new java.awt.Color(0, 0, 0));
        lblEmpName.setText("Patrick Wesley");
        getContentPane().add(lblEmpName);
        lblEmpName.setBounds(630, 258, 290, 40);

        lblLandingPage.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lblLandingPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLandingPage.png"))); // NOI18N
        getContentPane().add(lblLandingPage);
        lblLandingPage.setBounds(0, 0, 1430, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        dispose();
            
        Check_InGUI newGUI = new Check_InGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        dispose();
            
        Check_Out newGUI = new Check_Out();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void lblEmpManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmpManagementMouseEntered
        lblEmpManagement.setForeground(Color.BLUE);
    }//GEN-LAST:event_lblEmpManagementMouseEntered

    private void lblEmpManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmpManagementMouseExited
        lblEmpManagement.setForeground(new Color(0, 153,255));
    }//GEN-LAST:event_lblEmpManagementMouseExited

    private void lblEmpManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmpManagementMouseClicked
        dispose();

        ManagementGUI newGUI = new ManagementGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_lblEmpManagementMouseClicked

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
            java.util.logging.Logger.getLogger(LandingPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LandingPageGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel lblEmpManagement;
    private javax.swing.JLabel lblEmpName;
    private javax.swing.JLabel lblLandingPage;
    // End of variables declaration//GEN-END:variables
}
/**
 *
 * @author patri
 */
import java.awt.Color;

public class LandingPageGUI extends javax.swing.JFrame {
    private final String EMPFIRSTNAME = SessionManager.getLoggedInUserName();  
    /**
     * Creates new form LandingPageGUI
     */
    public LandingPageGUI() {
        initComponents();
        
        if (EMPFIRSTNAME == null) {
            lblDamageReport.setText("Spider-Man");
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
        lblDamageReport = new javax.swing.JLabel();
        lblInjuryReport = new javax.swing.JLabel();
        lblEmpName = new javax.swing.JLabel();
        lblLandingPage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(1446, 810));
        setPreferredSize(getPreferredSize());
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

        lblDamageReport.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblDamageReport.setForeground(new java.awt.Color(0, 153, 255));
        lblDamageReport.setText("<html><u>Damage Report<u><html>");
        lblDamageReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDamageReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDamageReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDamageReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDamageReportMouseExited(evt);
            }
        });
        getContentPane().add(lblDamageReport);
        lblDamageReport.setBounds(670, 650, 110, 40);

        lblInjuryReport.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblInjuryReport.setForeground(new java.awt.Color(0, 153, 255));
        lblInjuryReport.setText("<html><u>Injury Report<u><html>");
        lblInjuryReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInjuryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInjuryReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInjuryReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInjuryReportMouseExited(evt);
            }
        });
        getContentPane().add(lblInjuryReport);
        lblInjuryReport.setBounds(680, 690, 100, 40);

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

    private void lblDamageReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDamageReportMouseEntered
        lblDamageReport.setForeground(Color.BLUE);
    }//GEN-LAST:event_lblDamageReportMouseEntered

    private void lblDamageReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDamageReportMouseExited
        lblDamageReport.setForeground(new Color(0, 153,255));
    }//GEN-LAST:event_lblDamageReportMouseExited

    private void lblInjuryReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInjuryReportMouseEntered
        lblInjuryReport.setForeground(Color.BLUE);
    }//GEN-LAST:event_lblInjuryReportMouseEntered

    private void lblInjuryReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInjuryReportMouseExited
        lblInjuryReport.setForeground(new Color(0, 153,255));
    }//GEN-LAST:event_lblInjuryReportMouseExited

    private void lblDamageReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDamageReportMouseClicked
        dispose();
        
        DamageReportGUI newGUI = new DamageReportGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_lblDamageReportMouseClicked

    private void lblInjuryReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInjuryReportMouseClicked
        dispose();

        InjuryReportGUI newGUI = new InjuryReportGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_lblInjuryReportMouseClicked

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
    private javax.swing.JLabel lblDamageReport;
    private javax.swing.JLabel lblEmpName;
    private javax.swing.JLabel lblInjuryReport;
    private javax.swing.JLabel lblLandingPage;
    // End of variables declaration//GEN-END:variables
}

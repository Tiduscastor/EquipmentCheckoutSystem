/**
 *
 * @author patri
 */
import javax.swing.JOptionPane;

public class DamageReportGUI extends javax.swing.JFrame {
    /**
     * Creates new form Check_In
     */
    public DamageReportGUI() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnSubmit.setOpaque(false);
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEquipID = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDamageDesc = new javax.swing.JTextArea();
        lblImgCheckIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEquipID.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        getContentPane().add(txtEquipID, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 400, 40));

        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 320, 80));

        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 320, 80));

        txtaDamageDesc.setColumns(20);
        txtaDamageDesc.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        txtaDamageDesc.setRows(5);
        jScrollPane1.setViewportView(txtaDamageDesc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 480, 170));

        lblImgCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgDamageReport.png"))); // NOI18N
        getContentPane().add(lblImgCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
            
        LandingPageGUI newGUI = new LandingPageGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // Get the equip_ID from the text field and emp_ID from session manager
        String damageDesc = txtaDamageDesc.getText();
        String equip_ID = txtEquipID.getText();

        // Check if the damage description is not empty
        if (!damageDesc.isEmpty()) {
            boolean success = true;
            if (success) {
                JOptionPane.showMessageDialog(null, "Damage claim sent successfully!");
                MainTrackDB.damagedItem(equip_ID, SessionManager.getLoggedInUserID());
                dispose();

                LandingPageGUI newGUI = new LandingPageGUI();
                newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                newGUI.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Failed to send claim.\nPlease ensure you are logged in correctly and all fields are filled.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter an injury description.");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Check_InGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            new Check_InGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImgCheckIn;
    private javax.swing.JTextField txtEquipID;
    private javax.swing.JTextArea txtaDamageDesc;
    // End of variables declaration//GEN-END:variables
}

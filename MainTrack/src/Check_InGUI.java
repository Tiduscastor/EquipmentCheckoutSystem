/**
 *
 * @author patri
 */
import javax.swing.JOptionPane;

public class Check_InGUI extends javax.swing.JFrame {
    /**
     * Creates new form Check_In
     */
    public Check_InGUI() {
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

        txtBarcode = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblImgCheckIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBarcode.setFont(new java.awt.Font("Cascadia Mono", 0, 30)); // NOI18N
        getContentPane().add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 430, 70));

        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 625, 320, 70));

        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 625, 320, 70));

        lblImgCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCheckIn.png"))); // NOI18N
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
        // Get the barcode and EMP_ID from the text field and session manager
        String equip_ID = txtBarcode.getText();
        String emp_ID = SessionManager.getLoggedInUserID();

        // Check if the barcode is not empty
        if (!equip_ID.isEmpty()) {
            boolean success = MainTrackDB.returnItem(emp_ID, equip_ID);

            if (success) {
                JOptionPane.showMessageDialog(null, "Inventory Updated!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Failed to return tool.\nPlease ensure equipment is assigned to your ID and the barcode is correct.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter an item barcode.");
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
    private javax.swing.JLabel lblImgCheckIn;
    private javax.swing.JTextField txtBarcode;
    // End of variables declaration//GEN-END:variables
}

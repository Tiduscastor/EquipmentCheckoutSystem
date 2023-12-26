/**
 *
 * @author patri
 */
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Check_Out extends javax.swing.JFrame {
    private int selectedEquipID;
    /**
     * Creates new form Check_Out
     */
    public Check_Out() {
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

        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        equipmentTable = new javax.swing.JTable();
        lblCheckOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 310, 80));

        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 650, 310, 80));

        equipmentTable.setModel(MainTrackDB.getEquipmentData());
        equipmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(equipmentTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 312, 1000, 310));

        lblCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCheckOut.png"))); // NOI18N
        getContentPane().add(lblCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
            
        LandingPageGUI newGUI = new LandingPageGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void equipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTableMouseClicked
        // Get the selected row index
        int selectedRowIndex = equipmentTable.rowAtPoint(evt.getPoint());

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Get data from the selected row
            String equipIDString = equipmentTable.getValueAt(selectedRowIndex, 0).toString();
            selectedEquipID = parseInt(equipIDString);

            try {
                // Parse the equipIDString to an integer
                selectedEquipID = Integer.parseInt(equipIDString);

                // Other data from the selected row
                String equipName = equipmentTable.getValueAt(selectedRowIndex, 1).toString();
                String equipPrice = equipmentTable.getValueAt(selectedRowIndex, 2).toString();
                String equipDesc = equipmentTable.getValueAt(selectedRowIndex, 3).toString();

                // Now you have the data in the variables selectedEquipID, equipName, equipPrice, and equipDesc
                System.out.println("Selected Equipment ID: " + selectedEquipID);
                System.out.println("Selected Equipment Name: " + equipName);
                System.out.println("Selected Equipment Price: " + equipPrice);
                System.out.println("Selected Equipment Description: " + equipDesc);

            } 
            catch (NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_equipmentTableMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        try {
            MainTrackDB.checkoutItem(SessionManager.getLoggedInUserID(), selectedEquipID);
        } catch (SQLException ex) {
            Logger.getLogger(Check_Out.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Check_Out.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        new Check_Out().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTable equipmentTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCheckOut;
    // End of variables declaration//GEN-END:variables
}
/**
 *
 * @author patri
 */
import static java.lang.Integer.parseInt;

public class ManagementGUI extends javax.swing.JFrame {
    private int selectedemp_ID;
    /**
     * Creates new form LoginGUI
     */
    public ManagementGUI() {
        initComponents();
        
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnTerminate.setOpaque(false);
        btnTerminate.setContentAreaFilled(false);
        btnTerminate.setBorderPainted(false);
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnTerminate = new javax.swing.JButton();
        lblLoginScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeTable.setModel(MainTrackDB.getEmployeeData());
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 282, 1030, 340));

        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 330, 70));

        btnTerminate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTerminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminateActionPerformed(evt);
            }
        });
        getContentPane().add(btnTerminate, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 640, 330, 70));

        lblLoginScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgManagement.png"))); // NOI18N
        getContentPane().add(lblLoginScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 1330, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();

        ManagerLandingGUI newGUI = new ManagerLandingGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        int selectedRowIndex = employeeTable.rowAtPoint(evt.getPoint());

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Get data from the selected row
            String emp_IDString = employeeTable.getValueAt(selectedRowIndex, 0).toString();
            selectedemp_ID = parseInt(emp_IDString);

            try {
                // Parse the equipIDString to an integer
                selectedemp_ID = Integer.parseInt(emp_IDString);

                // Other data from the selected row
                String emp_FN = employeeTable.getValueAt(selectedRowIndex, 1).toString();
                String emp_LN = employeeTable.getValueAt(selectedRowIndex, 2).toString();
                String emp_Pass = employeeTable.getValueAt(selectedRowIndex, 3).toString();
                String Manager = employeeTable.getValueAt(selectedRowIndex, 4).toString();

                // Now you have the data in the variables
                System.out.println("Selected Employee ID: " + selectedemp_ID);
                System.out.println("Selected Employee First Name: " + emp_FN);
                System.out.println("Selected Employee Last Name: " + emp_LN);
                System.out.println("Selected Employee Password: " + emp_Pass);
                System.out.println("Selected Employee Managerial Status: " + Manager);

            } catch (NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void btnTerminateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminateActionPerformed
        MainTrackDB.terminateEmployee(selectedemp_ID);
        
        dispose();

        ManagerLandingGUI newGUI = new ManagerLandingGUI();
        newGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newGUI.setVisible(true);
    }//GEN-LAST:event_btnTerminateActionPerformed

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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnTerminate;
    private javax.swing.JTable employeeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoginScreen;
    // End of variables declaration//GEN-END:variables
}

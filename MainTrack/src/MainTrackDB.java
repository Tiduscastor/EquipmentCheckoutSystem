/**
 *
 * @author patri
 */
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class MainTrackDB {
    //Schema Login Info. Be sure to change for your needs.
    static String url1 = "jdbc:mysql://localhost:3306/maintrack";
    static String user = "root";
    static String password = "Seasalt2!";
    
    //Create the table model to be used in the Check_Out GUI.
    public static DefaultTableModel getEquipmentData() {
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("equip_ID");
        model.addColumn("equip_Name");
        model.addColumn("equip_Price");
        model.addColumn("equip_Desc");
        
        //Try to populate model with Schema information and then return the complete model.
        try (Connection connection = DriverManager.getConnection(url1, user, password)) {
            String sql = "SELECT equip_ID, equip_Name, equip_Price, equip_Desc FROM equipment";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Object[] row = {
                                resultSet.getObject("equip_ID"),
                                resultSet.getObject("equip_Name"),
                                resultSet.getObject("equip_Price"),
                                resultSet.getObject("equip_Desc")
                        };
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
    }
        return model;
}
    
    public static DefaultTableModel getEmployeeData() {
        DefaultTableModel model2 = new DefaultTableModel();

        // Add columns to the model
        model2.addColumn("emp_ID");
        model2.addColumn("emp_FN");
        model2.addColumn("emp_LN");
        model2.addColumn("emp_Pass");
        model2.addColumn("Manager");

        //Try to populate model with Schema information and then return the complete model.
        try (Connection connection = DriverManager.getConnection(url1, user, password)) {
            String sql = "SELECT emp_ID, emp_FN, emp_LN, emp_Pass, Manager FROM employees";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Object[] row = {
                            resultSet.getObject("emp_ID"),
                            resultSet.getObject("emp_FN"),
                            resultSet.getObject("emp_LN"),
                            resultSet.getObject("emp_Pass"),
                            resultSet.getObject("Manager")
                        };
                        model2.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return model2;
    }

    //Method for authenticating an employee user via ID# and Password stored in DB. This is also where we get the employees Name.
    public static String authenticateEmployee(String EMP_ID, String EMP_PASS) throws SQLException, ClassNotFoundException {
        String EMPFIRSTNAME = null;

        try (Connection conn1 = DriverManager.getConnection(url1, user, password)) {
            if (conn1 != null) {
                System.out.println("Connected to the database.");
                String query = "SELECT CONCAT(emp_FN, ' ', emp_LN) AS full_name FROM employees WHERE emp_ID = ? AND emp_Pass = ?";

                try (PreparedStatement preparedStatement = conn1.prepareStatement(query)) {
                    preparedStatement.setString(1, EMP_ID);
                    preparedStatement.setString(2, EMP_PASS);

                    try (ResultSet rs = preparedStatement.executeQuery()) {
                        if (rs.next()) {
                            EMPFIRSTNAME = rs.getString("full_name");
                            System.out.print(EMPFIRSTNAME);
                        }
                    }
                }
            }
        } catch (SQLException e) {
        }
        return EMPFIRSTNAME;
    }
    
    //Tests if the logged in user is a manager or not.
    public static String authenticateManager(String EMP_ID, String EMP_PASS) throws SQLException, ClassNotFoundException {
        String isManager = null;
        try (Connection conn1 = DriverManager.getConnection(url1, user, password)) {
            if (conn1 != null) {
                System.out.println("Connected to the database.");
                String query = "SELECT Manager FROM employees WHERE emp_ID = ? AND emp_Pass = ?";
                try (PreparedStatement preparedStatement = conn1.prepareStatement(query)) {
                    preparedStatement.setString(1, EMP_ID);
                    preparedStatement.setString(2, EMP_PASS);
                    try (ResultSet rs = preparedStatement.executeQuery()) {
                        if (rs.next()) {
                            isManager = rs.getString("Manager");
                        }
                    }
                }
            }
        }
        return isManager;
    }
    
    // Process for adding requested item to employees personal pool of equipment.
    public static boolean checkoutItem(String emp_ID, int equip_ID) throws SQLException {
        boolean checkedOut = false;

        try (Connection conn = DriverManager.getConnection(url1, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database.");

                // Check if the entry already exists
                if (entryExists(emp_ID, equip_ID)) {
                    JOptionPane.showMessageDialog(null, "Item already checked out for this employee, will now increment assigned item count.");

                    String updateAvailabilityQuery = "UPDATE equipment SET Available = Available - 1 WHERE equip_ID = ? AND Available > 0";
                    try (PreparedStatement updateAvailabilityStatement = conn.prepareStatement(updateAvailabilityQuery)) {
                        updateAvailabilityStatement.setInt(1, equip_ID);

                        // Execute the update
                        int rowsUpdated = updateAvailabilityStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            // Successfully updated Available column, now increment assigned item count
                            String insertQuery = "UPDATE employeeequipment SET amount = amount + 1 WHERE emp_ID = ? AND equip_ID = ?";
                            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                                insertStatement.setInt(1, parseInt(emp_ID));
                                insertStatement.setInt(2, equip_ID);

                                // Execute the insert
                                int rowsInserted = insertStatement.executeUpdate();

                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, "Item incremented successfully!");
                                    checkedOut = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "No rows affected. Item may not have been checked out.");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "This item is currently on back order. Try ordering again later!");
                        }
                    } catch (SQLException ex) {
                        // Handle or log the exception appropriately 
                    }
                } else {
                    String insertQuery = "INSERT INTO employeeequipment (emp_ID, equip_ID) VALUES (?, ?)";
                    try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                        insertStatement.setInt(1, parseInt(emp_ID));
                        insertStatement.setInt(2, equip_ID);

                        // Execute the insert
                        int rowsInserted = insertStatement.executeUpdate();

                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Item Checked Out successfully!");
                            checkedOut = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "No rows affected. Item may not have been checked out.");
                        }
                    } catch (SQLException ex) {
                        // Handle or log the exception appropriately
                    }
                }
            }
        } catch (SQLException ex) {
            // Handle or log the exception appropriately
        }

        return checkedOut;
    }

    // Check if the entry already exists
    private static boolean entryExists(String emp_ID, int equip_ID) {
        boolean exists = false;
        try (Connection conn = DriverManager.getConnection(url1, user, password)) {
            if (conn != null) {
                String query = "SELECT COUNT(*) AS count FROM employeeequipment WHERE emp_ID = ? AND equip_ID = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setInt(1, parseInt(emp_ID));
                    preparedStatement.setInt(2, equip_ID);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            int count = resultSet.getInt("count");
                            if (count > 0) {
                                exists = true;
                            }                           
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            // Handle or log the exception appropriately
        }
        return exists;
    }
    
    //Process for removing employee from database
    public static boolean terminateEmployee(int emp_ID) {
        boolean checkedOut = false;
        try (Connection conn1 = DriverManager.getConnection(url1, user, password)) {
            if (conn1 != null) {
                System.out.println("Connected to the database.");

                // Check if the emp_ID exists in the "employees" table
                if (employeeTerminate(conn1, emp_ID)) {
                    String query = "DELETE FROM employees WHERE emp_ID = ?";
                    try (PreparedStatement preparedStatement = conn1.prepareStatement(query)) {
                        preparedStatement.setInt(1, emp_ID);

                        // Execute the update
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Employee Terminated successfully and assigned equipment has been returned!");
                            checkedOut = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "No rows affected. Employee may not have been fully removed.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found in system.");
                }
            }
        } catch (SQLException ex) {
        }
        return checkedOut;
    }

    // Helper method to check if the emp_ID exists in the "employees" table
    private static boolean employeeTerminate(Connection connection, int emp_ID) throws SQLException {
        String query = "SELECT 1 FROM employees WHERE emp_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, emp_ID);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    
    // Process of returning a damaged item back into the pool. Returns Pass/Fail
    public static boolean damagedItem(String equip_ID, String emp_ID) {
        boolean added = false;

        try (Connection conn1 = DriverManager.getConnection(url1, user, password)) {
            if (conn1 != null) {
                System.out.println("Connected to the database.");

                // Delete Damaged Equipment
                String deleteQuery = "UPDATE employeeequipment SET amount = amount - 1 WHERE emp_ID = ? AND equip_ID = ?";
                try (PreparedStatement deleteStatement = conn1.prepareStatement(deleteQuery)) {
                    deleteStatement.setString(1, emp_ID);
                    deleteStatement.setString(2, equip_ID);

                    // Execute the update
                    int rowsAffected = deleteStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        // Damaged equipment deleted successfully, proceed to update damagedEquip table
                        String checkQuery = "SELECT COUNT(*) AS count FROM damagedEquip WHERE equip_ID = ?";
                        try (PreparedStatement checkStatement = conn1.prepareStatement(checkQuery)) {
                            checkStatement.setString(1, equip_ID);

                            try (ResultSet resultSet = checkStatement.executeQuery()) {
                                if (resultSet.next() && resultSet.getInt("count") > 0) {
                                    // Damaged item already exists, increment the amount
                                    incrementDamagedEquipAmount(conn1, equip_ID);
                                } else {
                                    // Damaged item doesn't exist, insert a new row
                                    insertDamagedEquipment(conn1, equip_ID);
                                }

                                JOptionPane.showMessageDialog(null, "Item removed for repair successfully.");
                                added = true;
                            }
                        }
                    } else {
                        System.out.println("No rows affected. Item may not have been returned.");
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return added;
    }
    
    private static void incrementDamagedEquipAmount(Connection conn, String equip_ID) throws SQLException {
        String updateQuery = "UPDATE damagedEquip SET amount = amount + 1 WHERE equip_ID = ?";
        try (PreparedStatement updateStatement = conn.prepareStatement(updateQuery)) {
            updateStatement.setString(1, equip_ID);
            updateStatement.executeUpdate();
        }
    }

    private static void insertDamagedEquipment(Connection conn, String equip_ID) throws SQLException {
        String insertQuery = "INSERT INTO damagedEquip (equip_ID, amount) VALUES (?, 1)";
        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
            insertStatement.setString(1, equip_ID);
            insertStatement.executeUpdate();
        }
    }

    // Process of returning an employee assigned item back into the pool. Returns Pass/Fail
    public static boolean returnItem(String emp_ID, String equip_ID) {
        boolean added = false;

        try (Connection conn1 = DriverManager.getConnection(url1, user, password)) {
            if (conn1 != null) {
                System.out.println("Connected to the database.");

                String deleteQuery = "UPDATE employeeequipment SET amount = amount - 1 WHERE emp_ID = ? AND equip_ID = ?";
                try (PreparedStatement deleteStatement = conn1.prepareStatement(deleteQuery)) {
                    deleteStatement.setString(1, emp_ID);
                    deleteStatement.setString(2, equip_ID);

                    // Execute the delete
                    int rowsDeleted = deleteStatement.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Item Returned successfully.");
                        added = true;

                        try (Connection conn2 = DriverManager.getConnection(url1, user, password)) {
                            String updateQuery = "UPDATE equipment SET amount = amount + 1 WHERE equip_ID = ?";
                            try (PreparedStatement updateStatement = conn2.prepareStatement(updateQuery)) {
                                updateStatement.setString(2, equip_ID);

                                // Execute the update
                                int rowsUpdated = updateStatement.executeUpdate();

                                if (rowsUpdated > 0) {
                                    JOptionPane.showMessageDialog(null, "Item Amount Updated successfully.");
                                } else {
                                    System.out.println("No rows affected. Item amount may not have been updated.");
                                }
                            }
                        } catch (SQLException ex) {
                        }
                    } else {
                        System.out.println("No rows affected. Item may not have been returned.");
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return added;
    }
}
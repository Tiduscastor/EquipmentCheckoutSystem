/**
 *
 * @author patri
 */
public class SessionManager {
    private static String loggedInUserName;
    private static String loggedInUserID;
    private static String managerStatus;
    private static int selectedID;

    // Method to set the logged-in user name
    public static void setLoggedInUserName(String EMPFIRSTNAME) {
        loggedInUserName = EMPFIRSTNAME;
    }

    // Method to get the logged-in user name
    public static String getLoggedInUserName() {
        return loggedInUserName;
    }
    
    // Method to set the logged-in user ID
    public static void setLoggedInUserID(String EMP_ID) {
        loggedInUserID = EMP_ID;
    }

    // Method to get the logged-in user ID
    public static String getLoggedInUserID() {
        return loggedInUserID;
    }
    
    // Method to set the selected equip_ID
    public static void setEquipID(int equip_ID) {
        selectedID = equip_ID;
    }

    // Method to get the selected equip_ID
    public static int getEquipID() {
        return selectedID;
    }
    
        // Method to set the selected Manager Status
    public static void setManager(String manager) {
        managerStatus = manager;
    }

    // Method to get the selected Manager Status
    public static String getManager() {
        return managerStatus;
    }
}

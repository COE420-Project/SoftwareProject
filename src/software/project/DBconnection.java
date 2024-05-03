
package software.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;

public class DBconnection {
    private static final String URL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl"; // JDBC URL for Oracle database
    private static final String USERNAME = "b00089753";
    private static final String PASSWORD = "b00089753";
    
    boolean validLogin = false;
    private String loggedInClientEmail;
    
    static Connection connection; // connection of the db
    
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet rs;
    
    public DBconnection() {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to Oracle Database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to Oracle database!");
            
        } catch (ClassNotFoundException | SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Retreiving username/password.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    // returns records selected
    public ResultSet executeStatement(String strSQL) throws SQLException {
        // make the result set scrollable forward/backward updatable
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // populate valid mgr numbers
        rs = statement.executeQuery(strSQL);
        return rs;
    }
    
    // updates, inserts, (returns number of records affected)
    public int executePrepared(String strSQL) throws SQLException {
        prepStatement = connection.prepareStatement(strSQL);
        return prepStatement.executeUpdate();
    }
    
    
   public boolean checkCredentials(String email, String password) {
    try {
        // Checking in ADMIN_ACCOUNT table
        String adminQuery = "SELECT COUNT(*) FROM ADMIN_ACCOUNT WHERE EMAIL = ? AND PASS = ?";
        PreparedStatement adminStatement = connection.prepareStatement(adminQuery);
        adminStatement.setString(1, email);
        adminStatement.setString(2, password);
        ResultSet adminResultSet = adminStatement.executeQuery();
        adminResultSet.next();
        int adminCount = adminResultSet.getInt(1);
        
        if (adminCount == 0) {
            // checking in CLIENT TABLE
            String clientQuery = "SELECT COUNT(*) FROM CLIENT_ACCOUNT WHERE EMAIL = ? AND PASS = ?";
            PreparedStatement clientStatement = connection.prepareStatement(clientQuery);
            clientStatement.setString(1, email);
            clientStatement.setString(2, password);
            ResultSet clientResultSet = clientStatement.executeQuery();
            clientResultSet.next();
            int clientCount = clientResultSet.getInt(1);
            
            return clientCount > 0; // If count > 0, credentials are valid for client
        } else {
            return true; // Credentials are valid for admin
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Error occurred, return false
    }
}

    
    public String getUserType(String username) {
        try {
            String query = "SELECT CLIENT_ID FROM CLIENT_ACCOUNT WHERE EMAIL = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return "CLIENT";
            } else {
                return "ADMIN"; // Username not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Error occurred
        }
    }
    
     public String getClientID(String username) {
        try {
            String query = "SELECT CLIENT_ID FROM CLIENT_ACCOUNT WHERE EMAIL = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return "CLIENT";
            } else {
                return "ADMIN"; // Username not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Error occurred
        }
    }
//Mohamad // registerig a client
private static int clientIdCounter = 0;
public boolean register_client(String fname, String username, String pass, String email) {
    try {
        clientIdCounter++;
        String clientId = "C" + clientIdCounter;
        String query = "INSERT INTO CLIENT_ACCOUNT (CLIENT_ID, FNAME, USERNAME, PASS, EMAIL) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement s = connection.prepareStatement(query);
        s.setString(1, clientId);
        s.setString(2, fname);
        s.setString(3, email); // email
        s.setString(4, pass);
        s.setString(5, username); // in our system all registred users are clients only, admins are already registered
        

        // checking if executed statemnt was successfull
        int rowsInserted = s.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }  
}

//view account client
public Client viewAccount(String username) {

   // String email, String phonenum, String usertype, String points, String balance
     try {
        String query = "SELECT CLIENT_ID, USERNAME, EMAIL, CLIENT_TYPE, POINTS FROM CLIENT_ACCOUNT WHERE EMAIL = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            String clientId = resultSet.getString("CLIENT_ID");
            String userEmail = resultSet.getString("EMAIL");
            String userType = resultSet.getString("CLIENT_TYPE");
            int points = resultSet.getInt("POINTS");
            
            return new Client(clientId, username, userEmail, userType, points);
        } else {
            return null; // Username not found
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null; // Error occurred
    }
   
}

// admin id
public static Admin getAdminByIDFromDatabase(String Email) {
    
    
    
    try {
        String query = "SELECT ADMIN_ID FROM admin WHERE EMAIL = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Email);
        ResultSet resultSet = statement.executeQuery();

        
        if (resultSet.next()) {
            String adminID = resultSet.getString("ADMIN_ID");
            String fname = resultSet.getString("FNAME");
            String username = resultSet.getString("USERNAME");
            String email = resultSet.getString("EMAIL");

            // Create and return an Admin object with the retrieved values
            return new Admin(adminID, fname, username, email);
        } else {
            return null; // Username not found
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null; // Error occurred
    }
}

private static int feedbackIdCounter = 0;
public static void insertFeedback(String feedbackTitle, String machineID, String comments,String user_name) {
        try {
            

            feedbackIdCounter++;
            String feedbackId = "F" + feedbackIdCounter;
            String sql = "INSERT INTO FEEDBACKS (FEEDBACK_ID, FEEDBACK_TITLE, USERNAME, MACHINE_ID, COMMENTS) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, feedbackId);
            preparedStatement.setString(2, feedbackTitle);
            preparedStatement.setString(3, user_name);
            preparedStatement.setString(4, machineID);
            preparedStatement.setString(5, comments);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Feedback inserted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert feedback.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


public static List<String> getAllFeedback() {
    List<String> feedbackList = new ArrayList<>();
    try{ 
        String sql = "SELECT FEEDBACK_ID, FEEDBACK_TITLE, USERNAME, MACHINE_ID, COMMENTS FROM FEEDBACKS";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String feedbackId = resultSet.getString("FEEDBACK_ID");
            String feedbackTitle = resultSet.getString("FEEDBACK_TITLE");
            String username = resultSet.getString("USERNAME");
            String machineId = resultSet.getString("MACHINE_ID");
            String comments = resultSet.getString("COMMENTS");

            String feedbackEntry = feedbackId + ", " + feedbackTitle + ", " + username + ", " + machineId + ", " + comments;
            feedbackList.add(feedbackEntry);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }    
    
    return feedbackList;

}

public static void printFeedback(ArrayList<String> feedbackList) {
        for (String feedbackEntry : feedbackList) {
            //add sql print statements to print in trackClientsRev 
        }
    }
//get machine status mohammed
public String getMachineStatus(String machineID) {
    try {
        String query = "SELECT MACHINE_STATUS FROM MACHINE WHERE MACHINE_ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, machineID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("MACHINE_STATUS");
        } else {
            return "Machine not found";
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return "Error occurred";
    }
}


 public String updateMachineStatus(String machineId, int usageDuration) {
        try {
            String query = "SELECT POWER_CONSUMPTION, MACHINE_STATUS FROM MACHINE WHERE MACHINE_ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, machineId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int currentPowerConsumption = resultSet.getInt("POWER_CONSUMPTION");
                String machineStatus = resultSet.getString("MACHINE_STATUS");

                // Update usage duration, power consumption, and status
                query = "UPDATE MACHINE SET USAGE_DURATION = USAGE_DURATION + ?, " +
                        "POWER_CONSUMPTION = POWER_CONSUMPTION + (? * 10), MACHINE_STATUS = ? WHERE MACHINE_ID = ?";
                PreparedStatement updateStatement = connection.prepareStatement(query);
                updateStatement.setInt(1, usageDuration);
                updateStatement.setInt(2, usageDuration);
                updateStatement.setString(3, "ON");
                updateStatement.setString(4, machineId);
                updateStatement.executeUpdate();

                int powerConsumptionChange = usageDuration * 10;  // here we are calucting consumption 10 is watts in our assumption

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            String offQuery = "UPDATE MACHINE SET MACHINE_STATUS = ? WHERE MACHINE_ID = ?";
                            PreparedStatement turnOffStatement = connection.prepareStatement(offQuery);
                            turnOffStatement.setString(1, "OFF");
                            turnOffStatement.setString(2, machineId);
                            turnOffStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 2 * 60 * 1000); // 2 minutes in milliseconds

                return "Successful";
            } else {
                return "Machine not found!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }

 }
 
 
 
  public DefaultTableModel getClientData() {
        try {
            String query = "SELECT CLIENT_ID, FNAME, USERNAME, EMAIL, CLIENT_TYPE, POINTS FROM CLIENT_ACCOUNT";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Creating DefaultTableModel
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Client ID");
            model.addColumn("First Name");
            model.addColumn("Username");
            model.addColumn("Email");
            model.addColumn("Client Type");
            model.addColumn("Points");

            // Adding the  data to the table for the client
            while (resultSet.next()) {
                Object[] rowData = new Object[6];
                rowData[0] = resultSet.getString("CLIENT_ID");
                rowData[1] = resultSet.getString("FNAME");
                rowData[2] = resultSet.getString("USERNAME");
                rowData[3] = resultSet.getString("EMAIL");
                rowData[4] = resultSet.getString("CLIENT_TYPE");
                rowData[5] = resultSet.getInt("POINTS");
                model.addRow(rowData);
            }

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DefaultTableModel getMachineData() {
        try {
            String query = "SELECT MACHINE_ID, MACHINE_TYPE, MACHINE_COST_PER_MIN, USAGE_DURATION, CYCLE_NUMBER, MACHINE_STATUS, POWER_CONSUMPTION FROM MACHINE";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Creating DefaultTableModel for machine data
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Machine ID");
            model.addColumn("Machine Type");
            model.addColumn("Cost per Minute");
            model.addColumn("Usage Duration");
            model.addColumn("Cycle Number");
            model.addColumn("Status");
            model.addColumn("Power Consumption");

         // adding the data to tge table
            while (resultSet.next()) {
                Object[] rowData = new Object[7];
                rowData[0] = resultSet.getString("MACHINE_ID");
                rowData[1] = resultSet.getString("MACHINE_TYPE");
                rowData[2] = resultSet.getDouble("MACHINE_COST_PER_MIN");
                rowData[3] = resultSet.getInt("USAGE_DURATION");
                rowData[4] = resultSet.getInt("CYCLE_NUMBER");
                rowData[5] = resultSet.getString("MACHINE_STATUS");
                rowData[6] = resultSet.getInt("POWER_CONSUMPTION");
                model.addRow(rowData);
            }

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}



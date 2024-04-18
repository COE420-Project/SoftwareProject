package software.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBconnection {
    private static final String URL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl"; // JDBC URL for Oracle database
    private static final String USERNAME = "b00089753";
    private static final String PASSWORD = "b00089753";
    
    boolean validLogin = false;
    
    Connection connection; // connection of the db
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
        s.setString(3, username);
        s.setString(4, pass);
        s.setString(5, email); // in our system all registred users are clients only, admins are already registered
        

        // checking if executed statemnt was successfull
        int rowsInserted = s.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}


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
            String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0; // If count > 0, credentials are valid
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred, return false
        }
    }
    
    public String getUserType(String username) {
        try {
            String query = "SELECT type FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("type");
            } else {
                return null; // Username not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Error occurred
        }
    }
    
 //Mohamad // registerig a client
public boolean register_client(String name, String email, String username, String password) {
    try {
        String query = "INSERT INTO users (name, email, username, password, type) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement s = connection.prepareStatement(query);
        s.setString(1, name);
        s.setString(2, email);
        s.setString(3, username);
        s.setString(4, password);
        s.setString(5, "client"); // in our system all registred users are clients only, admins are already registered
        
        // checking if executed statemnt was succefull
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


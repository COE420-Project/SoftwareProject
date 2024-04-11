package software.project;

import java.awt.*; 
import javax.swing.*;

public class Client extends User { 

 	
private int points;
private int cardnum;
private int securityCode;
private String expDate;
private int balance; 
private char type;
int count;

Client(){
	
}
void generateId() {
	id = "C" + count;
}



public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public int getCardnum() {
	return cardnum;
}
public void setCardnum(int cardnum) {
	this.cardnum = cardnum;
}
public int getSecurityCode() {
	return securityCode;
}
public void setSecurityCode(int securityCode) {
	this.securityCode = securityCode;
}
public String getExpDate() {
	return expDate;
}
public void setExpDate(String expDate) {
	this.expDate = expDate;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public char getType() {
	return type;
}
public void setType(char type) {
	this.type = type;
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return super.getName();
}
/*
public static Client getClientByIDFromDatabase( String id) {
	
    try (Connection connection = DriverManager.getConnection(url, username, password);
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPassword(resultSet.getString("password"));
                client.setPoints(resultSet.getInt("points"));
                client.setCardnum(resultSet.getInt("cardnum"));
                client.setSecurityCode(resultSet.getInt("securityCode"));
                client.setExpDate(resultSet.getString("expDate"));
                client.setBalance(resultSet.getInt("balance"));
                client.setType(resultSet.getString("type").charAt(0));
                return client;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
*/

void bookMachine(String type, String id) {
     type = null; // gui
	   
	if (type == "drying") {
		
	}
}




}

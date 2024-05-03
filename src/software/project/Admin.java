package software.project;

import java.awt.*; 
import javax.swing.*;
public class Admin extends User{
	
 private String adminID;
    private String Fname;
    private String username;
    private String email;
    
       public Admin(String adminID, String fname, String username, String email) {
        this.adminID = adminID;
        this.Fname = fname;
        this.username = username;
        this.email = email;
    }

    // Setter for adminID
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    // Getter for adminID
    public String getAdminID() {
        return adminID;
    }

    // Setter for Fname
    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    // Getter for Fname
    public String getFname() {
        return Fname;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }
	
void ViewALLInfo() {
	
}

void ViewUsersInfo() {
	
}

void ViewMachinesInfo() {

}
void ViewAllFeedbacks() {
	// TODO Auto-generated method stub
	//super.ViewAllFeedbacks();
}

}






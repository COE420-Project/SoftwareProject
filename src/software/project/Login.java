package software.project;

public class Login{

private String type;

    public String getType() {
        return type;
    }
   
    
    //mohammed
    public boolean checkVerification(String username, String password) {
        DBconnection dbConnection = new DBconnection();
        boolean isValid = dbConnection.checkCredentials(username, password);
        if (isValid) {
            type = dbConnection.getUserType(username);
        }
        return isValid;
    }
}


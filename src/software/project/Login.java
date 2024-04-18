package software.project;

public class Login{

private String type;

    public String getType() {
        return type;
    }
   
    
    //mohammed
    public boolean checkVerification(String email, String password) {
        DBconnection dbConnection = new DBconnection();
        boolean isValid = dbConnection.checkCredentials(email, password);
        if (isValid) {
            type = dbConnection.getUserType(email);
        }
        return isValid;
    }
}


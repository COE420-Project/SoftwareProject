package software.project;

public class Admin extends User{

    public Admin(String name, String email, String password, String id, String type) {
        super(name, email, password, id, type);
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


//db

/*
public static Admin getAdminByIDFromDatabase(String id) {
    
    String query = "SELECT * FROM admin WHERE id =" ;
    
    try (Connection connection = DriverManager.getConnection(url, username, password);
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setName(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                return admin;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}




*/






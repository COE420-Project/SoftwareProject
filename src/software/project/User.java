package software.project;

abstract public class User {
	
	String Name;
	String email;
	private String password;
        String type;
        String id;
 

//	public User(String name, String email, String password, String id, String type) {
//        this.Name = name;
//        this.email = email;
//        this.password = password;
//        this.id = id;
//        this.type = type;
//    }

	
	public String getName() {
		
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmail() {
	

		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getID() {
		return id;
	}
	
	
	void ViewAllFeedbacks() {
		//....
	}

	

	
	
	
}

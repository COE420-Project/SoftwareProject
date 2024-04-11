package software.project;

abstract public class User {
	
	
	String Name;
	String email;
	private String password;
    String id;
 

	User(){
		
	}


	
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

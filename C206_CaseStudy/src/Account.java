
public class Account {
	private String username;
	public String password;
	private String user;
	private double credit;
	private String studentID;
	
	public Account(String username, String password, String user) {
		this.username = username;
		this.password = password;
		this.user = "Parent";
	}
	
	public Account(String username, String password, String user, String studentID, double credit) {
		this.username = username;
		this.password = password;
		this.user = "Student";
		this.studentID = studentID;
		this.credit = 0.0;
	}


	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUser() {
		return user;
	}

	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	

}

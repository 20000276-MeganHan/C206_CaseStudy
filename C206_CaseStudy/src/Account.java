
public class Account {
	private String username;
	public String password;
	private String user;
	private double credit;
	private int studentID;
	private int mobileNo;
	
	public Account(String username, String password, String user, int studentID, int mobileNo) {
		this.username = username;
		this.password = password;
		this.user = "Parent";
		this.studentID = studentID;
		this.mobileNo = mobileNo;
	}
	
	public Account(String username, String password, String user, int studentID, double credit, int mobileNo) {
		this.username = username;
		this.password = password;
		this.user = "Student";
		this.studentID = studentID;
		this.credit = 0.0;
		this.mobileNo = mobileNo;
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

	public int getStudentID() {
		return studentID;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}

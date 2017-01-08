package entity;

public class Account {
	private String user;
	private String pwd;
	
	public Account() {
		super();
	}

	public Account(String user, String pwd) {
		super();
		this.user = user;
		this.pwd = pwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

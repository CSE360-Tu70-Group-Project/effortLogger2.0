package application;

public class Credential {
	//initialize variables
	private String username;
	private String password;
	private boolean supervisor;
	//constructor
	public Credential(String user, String pass, boolean sup) {
		username = user;
		password = pass;
		supervisor = sup;
	}
	//return username
	public String getUsername() {
		return username;
	}
	//return password
	public String getPassword() {
		return password;
	}
	//return if supervised
	public boolean getSupervisor() {
		return supervisor;
	}
}

package bank.utils;

public class Auth {
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Auth() {}

	@Override
	public String toString() {
		return "Auth{" +
				"password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	public Auth(String email, String password) {
		this.password = password;
		this.email = email;
	}

	private  String password;
	private  String email;
}

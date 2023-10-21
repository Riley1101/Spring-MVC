package bank.utils;

public class User {
	public User() {
	}
	public User(long id, String name, String email, String password, long accountNumber, long balance) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public User( String name, String email, String password, long accountNumber, long balance) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	private long id;
	private String name;
	private String email;
	private String password;
	private long accountNumber;
	private  long balance;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", accountNumber=" + accountNumber +
				", balance=" + balance +
				'}';
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}


}

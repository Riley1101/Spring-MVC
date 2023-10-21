package bank.utils;

public class AccountTransaction {

	private String type;
	private double amount;


	@Override
	public String toString() {
		return "Transaction{" +
				"type='" + type + '\'' +
				", amount=" + amount +
				", password='" + password + '\'' +
				'}';
	}

	private  String password;
	private  String email;
	public AccountTransaction(){

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountTransaction(String email, String type, double amount, String password) {
		this.type = type;
		this.amount = amount;
		this.password = password;
		this.email = email;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() { return type; }
	public double getAmount() { return amount; }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

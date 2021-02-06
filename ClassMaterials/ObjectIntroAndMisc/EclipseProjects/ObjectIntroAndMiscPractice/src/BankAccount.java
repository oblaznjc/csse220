/**
 * This class represents a bank account for a person
 * It should be able to report current balance
 * and the person who owns it
 * 
 * 
 * @author oblaznjc
 *
 */

public class BankAccount {
	
	// Each account has its own instance variables
	private String name;
	private double balance;
	
	public BankAccount() {
		this.name = "Default Person";
		this.balance = 0;
	}
	 
	public BankAccount(String name, double startingBalance) {
		this.name = name;
		this.balance = startingBalance;
	}
	
	public void deposit(double money) {
		this.balance += money;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}

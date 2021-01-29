// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 11.8 - Implement Transaction and Account class and 
//                 test out its functions

import java.util.ArrayList;

public class Exercise_11_8 {

	public static void main(String[] args) {
		
		Account George = new Account("George", 1122, 1000);
		Account.setAnnualInterestRate(1.5);
		
		// Deposit and Withdraw from George's account
		
		George.deposit(30);
		George.deposit(40);
		George.deposit(50);
		
		George.withdraw(5);
		George.withdraw(4);
		George.withdraw(2);
		
		// Print out summary of George's account
		
		System.out.println("------ Account Summary ------\n\n"+
						   "Name                  : " + George.getName() + '\n' +
						   "Annual Interest Rate  : " + George.getAnnualInterestRate()   + "%\n" +
						   "Monthly Interest Rate : " + George.getMonthlyInterestRate() + '%');
		System.out.printf( "Current Balance       : $%8.2f%n%n", George.getBalance());
		
		System.out.println("------- Transactions --------\n");
		ArrayList<Transaction> transactions = George.getTransactions();
		Transaction temp;
		for(int i = 0; i < transactions.size(); i++)
		{
			temp = transactions.get(i);
			System.out.println("Transaction " + (i+1) + '\n' +
							   "- Description         : " + temp.getDescription());
			System.out.printf( "- Amount              : $%8.2f%n", temp.getAmount());
			System.out.printf( "- Current Balance     : $%8.2f%n%n", temp.getBalance());
		}
	}

}
class Transaction
{
	private java.util.Date date;
	private char type;
	
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(char type, double amount, double balance, String description)
	{
		date = new java.util.Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}
	public double getAmount() 
	{
		return amount;
	}
	public double getBalance() 
	{
		return balance;
	}
	public String getDescription() 
	{
		return description;
	}
}
class Account
{
	private int id;
	private double balance;
	private static double annualInterestRate;
	private java.util.Date dateCreated;
	
	private String name; // - 11.8
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Account()
	{
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new java.util.Date();
	}
	public Account(int id, double balance)
	{
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new java.util.Date();
	}
	public Account(String name, int id, double balance)
	{
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	public String getName()
	{
		return name;
	}
	public int getID()
	{
		return id;
	}
	public double getBalance()
	{
		return balance;
	}
	public static double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public static void setAnnualInterestRate(double annual)
	{
		annualInterestRate = annual;
	}
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}
	public double getMonthlyInterestRate()
	{
		return annualInterestRate/12.0;
	}
	public double getMonthlyInterest()
	{
		return balance * (annualInterestRate/100.0/12.0);
	}
	public ArrayList<Transaction> getTransactions()
	{
		return transactions;
	}
	public void withdraw(double amount)
	{
		balance -= amount;
		transactions.add(new Transaction('W', amount, balance, "Withdraw"));
	}
	public void deposit(double amount)
	{
		balance += amount;
		transactions.add(new Transaction('D', amount, balance, "Deposit"));
	}
}
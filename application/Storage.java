package application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	
	// Initialize storage for both spending,percent, and loan values 
	Map <String, Double> spendingStorage = new HashMap<String, Double>();
	Map <String, Double> percentStorage = new HashMap<String, Double>();
	Map <String, Double> loanStorage = new HashMap<String, Double>();
	
	// Insert spending value into category c
	public void insertSpending(String c, double spending) {
		spendingStorage.put(c, spending);
	}
	
	// Insert  percent value into category c
	public void insertPercent(String c, double percent) {
		percentStorage.put(c,  percent);
	}
	
	// Insert loan component 
	public void insertLoan(String c, double amount) {
		loanStorage.put(c,  amount);
	}
	
	// Access spending value of category c
	public double accessSpending(String c) {
		return spendingStorage.get(c);
	}
	
	// Access percent value of category c
	public double accessPercent(String c) {
		return percentStorage.get(c);
	}
	
	// Access component of loan for category c
	public double accessLoan(String c) {
		return loanStorage.get(c);
	}
	
	public static void main(String[] args) {
		Storage x = new Storage();
		x.insertSpending("Groceries", 100);
		x.insertSpending("Transportation", 400);
		System.out.println(x.accessSpending("Groceries"));
		System.out.println(x.accessSpending("Transportation"));
	}
}



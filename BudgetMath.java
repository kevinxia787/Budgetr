import java.math.BigDecimal;
import java.math.RoundingMode;

public class BudgetMath {
	// Round method from StackOverflow
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	// Given Percentage of Desired Spending
	public static double getPercentValue(double salary, int percent) {
		return ((percent / 100.0) * salary);
	}
	// Total Spending 
	public static double getTotalSpending(double insurance,  double rent, double mortgage, double loanPayment, double utilities, double groceries, double transport ) {
		return (insurance + rent + mortgage + loanPayment + groceries + utilities + transport);
	}
	// What's Left
	public static double getRemainder(double salary, double insurance,  double rent, double mortgage, double loanPayment, double utilities, double groceries, double transport ) {
		return (salary - (insurance + rent + mortgage + loanPayment + groceries + utilities + transport));
	}
	
	// Loan Payment Calculator based on how fast user wants to pay it off
	public static double loanPayment(double p, int n, double i, boolean yearly) {
		if (yearly) {
			return round((p * i) / ((1 - (Math.pow(1 + i, -n)))), 2);
		}
		else {
			return round((p * (i/12)) / ((1 - (Math.pow(1 + (i/12), -n)))), 2);
		}
	}
	public static void main(String[] args) {
		double salary = 5000.00;
		int percent = 5;
		double insurance = 447.00; double rent = 1250.00; double utilities = 250.00;
		double mortgage = 0.0; double loans = 887.56; double groceries = 150.00; double transport = 100.0;
		
		System.out.println("Test 01: Testing getPercentValue - Should print out:\n" + 250.0);
		System.out.println(getPercentValue(salary, percent));
		
		System.out.println("Test 02: Testing getTotalSpending - Should print out:\n" + 3804.56);
		System.out.println(getTotalSpending(insurance, rent, mortgage, loans, groceries, utilities, transport));
		
		System.out.println("Test 03: Testing getRemainder - Should print out:\n" + 1915.44);
		System.out.println(getRemainder(salary, insurance, rent, mortgage, loans, groceries, utilities, transport));
		
		System.out.println("Test 04: Testing loanPayment(yearly) - Should print out:\n" + 871.89);
		System.out.println(loanPayment(10000, 24, 0.07, true));
		
		System.out.println("Test 05: Testing loanPayment(monthly) - Should print out:\n" + 447.73);
		System.out.println(loanPayment(10000, 24, 0.07, false));
		
	}
}

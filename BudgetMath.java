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
	public static double getPercentValue(double salary, double percent) {
		return round(((percent / 100.0) * salary), 2);
	}
	// Find out percent value of spending given spending and salary 
	public static double getPercentSpending(double salary, double spending) {
		return round((spending / salary), 2);
	}
	
	// Calculate double value remainder
	public static double getRemainder(double salary, double totalSpending ) {
		return round((salary - totalSpending), 2);
	}
	
	//Remaining percent calculator
	public static double getRemainderPercent(double totalPercent) {
		return round((100.00 - totalPercent), 2);
	}
	
	//Suggested split of savings/recreation (25% of remainder)
	public static double getSRPercent (double remainderPercent) {
		return round((.25 * remainderPercent), 2);
	}
	//Suggested split of emergency fund (50% of remainder);
	public static double getEmergencyPercent(double remainderPercent) {
		return round((.5 * remainderPercent), 2);
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
	
	
	
	//Testing
	public static void main(String[] args) {
		double salary = 5000.00;
		int percent = 5;
		double insurance = 447.00; double rent = 1250.00; double utilities = 250.00;
		double mortgage = 0.0; double loans = 887.56; double groceries = 150.00; double transport = 100.0;
		
		System.out.println("Test 01: Testing getPercentValue - Should print out:\n" + 250.0);
		System.out.println(getPercentValue(salary, percent));
		
		System.out.println("Test 02: Testing loanPayment(yearly) - Should print out:\n" + 871.89);
		System.out.println(loanPayment(10000, 24, 0.07, true));
		
		System.out.println("Test 03: Testing loanPayment(monthly) - Should print out:\n" + 447.73);
		System.out.println(loanPayment(10000, 24, 0.07, false));
		
	}
}

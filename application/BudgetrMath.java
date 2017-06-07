package application;

public class BudgetrMath {
	
	// Round method to round to 2 decimal places
	public static double rounder(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
	
	/* Calculate percent value of spending 
	 * For example: percentValue(1000, 10) returns 100
	 */
	public static double percentValue(double salary, double percent) {
		double decimalPercent = percent/100;
		return rounder(decimalPercent * salary);
	}
	
	/* Calculate spending value percentage of salary
	 * For example: spendingPercent(1000, 100) returns 10;
	 */
	public static double spendingPercent(double salary, double spending) {
		double spendingPercent = (spending / salary) * 100.0;
		return rounder(spendingPercent);
	}
	
	/* Calculates monthly payment to pay the loan off in n months 
	 * p--> principal
	 * i--> interest
	 * n--> period in months
	 */
	
	public static double loanPayment(double p, double n, double i, boolean yearly) {
		if (yearly) {
			return rounder((p * (i/100)) / ((1 - (Math.pow(1 + (i/100), -n)))));
		}
		else {
			return rounder((p * ((i/100)/12)) / ((1 - (Math.pow(i + HERE(i/100)HERE, -n)))));
		}
	}
	
	
	
}

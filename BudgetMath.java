
public class BudgetMath {
	
	// Given Percentage of Desired Spending
	public static double getPercentValue(double salary, int percent) {
		double doublePercent = percent / 100;
		return (doublePercent * salary);
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
			return (p * i) / ((1 - (Math.pow(1 + i, -n))));
		}
		else {
			return (p * (i/12)) / ((1 - (Math.pow(1 + (i/12), -n))));
		}
	}
}

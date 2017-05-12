package application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoanCalc {
	
	/* Calculate the amount of payment dedicated to loans each month */
	public static double loanCalc(Map<String, Double> map) {
		double principal = map.get("Principal");
		double interest = map.get("Interest");
		double period = map.get("Period");
		double yearly_or_monthly = map.get("Yearly");
		boolean yearly;
		if (yearly_or_monthly == 1.0) {
			yearly = true;
		}
		else {
			yearly = false;
		}
		
		
		return BudgetrMath.loanPayment(principal, period, interest, yearly);
	}
}

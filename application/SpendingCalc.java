package application;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SpendingCalc {

	// Iterator function for testing
	public static void printMap(Map<String, Double> map) {
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());	
		}
	}
	
	// Calculate % values of salary -- Spending to Percent Value of Salary
	public static Map<String, Double> percentOfSalary(Map<String, Double> map, Double salary) {
		Map<String, Double> percentSalary_storage = new HashMap <String, Double>();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			percentSalary_storage.put( (String) pair.getKey(), BudgetrMath.spendingPercent(salary, (double) pair.getValue()));
			
		}
		return percentSalary_storage;
	}
	
	// Calculate Total Percent
	public static double totalPercent(Map<String, Double> map) {
		double total = 0.0;
		for (String key : map.keySet()) {
			total += map.get(key);
		}
		return total;
	}
	// Handle excess percentage points (given hard spending values) (50% emergency, 25% recreation and spending -- Of Remainder)
	public static Map<String, Double> totalAllocation(Map<String, Double> map, Double salary) {
		Map<String, Double> valueMap = percentOfSalary(map, salary);
		double totalPercentage = totalPercent(valueMap);
		if (totalPercentage < 100) {
			double remainder = 100.0 - totalPercentage;
			// Handle Emergency
			double emergencyPercentage = 0.5 * remainder;
			valueMap.put("Emergency", BudgetrMath.rounder(emergencyPercentage));
			// Handle Recreation
			double recreationPercentage = 0.25 * remainder;
			valueMap.put("Recreation", BudgetrMath.rounder(recreationPercentage));
			// Handle Savings
			double savingsPercentage = 0.25 * remainder;
			valueMap.put("Savings",  BudgetrMath.rounder(savingsPercentage));
		}
			
		return valueMap;
	}
	
	public static void main (String[] args) {
		Map<String, Double> spending_map = new HashMap<String, Double>();
		spending_map.put("Groceries", 200.0);
		spending_map.put("Transportation", 250.0);
		spending_map.put("Loans", 750.0);
		spending_map.put("Rent", 1500.0);
		spending_map.put("Utilities", 350.0);
		
		System.out.println("First printing out the original spending_map:");
		printMap(spending_map);
		
		System.out.println(" ");
		System.out.println("----------");
		System.out.println(" ");
		
		System.out.println("Next, printing out the percent values");
		Map<String, Double> percent_map = percentOfSalary(spending_map, 5000.0);
		printMap(percent_map);
		
		System.out.println(" ");
		System.out.println("----------");
		System.out.println(" ");
		
		System.out.println("Next, printing out the percent values");
		Map<String, Double> total_percent = totalAllocation(spending_map, 5000.0);
		printMap(total_percent);
		
		System.out.println(" ");
		System.out.println("----------");
		System.out.println(" ");
		
		System.out.println("Finally, printing out the hard spending values");
		Map<String, Double> total_spending = PercentCalc.amountOfSalary(total_percent, 5000.0);
		printMap(total_spending);
		
	}
}

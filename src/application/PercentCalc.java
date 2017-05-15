package application;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PercentCalc {
	
	// Iterator function for testing
	public static void printMap(Map<String, Double> map) {
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}
	
	// Calculate % hard spending values given percent
	public static Map<String, Double> amountOfSalary(Map<String, Double> map, Double salary) {
		Map<String, Double> amountSalary_storage = new HashMap <String, Double>();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next(); 
			amountSalary_storage.put( (String) pair.getKey(), BudgetrMath.percentValue(salary, (double) pair.getValue()));	
		}
			
		return amountSalary_storage;
	}
	
	// Calculate Total Percent
	public static double totalPercent(Map<String, Double> map) {
		double total = 0.0;
		for (String key : map.keySet()) {
			total += map.get(key);
		}
		return total;
	}
	
	// Handle excess percentage points (given percentage values) (Same distribution as above) 
	public static Map<String, Double> totalAllocationPercentages(Map<String, Double> map) {
		double totalPercentage = totalPercent(map);
		if (totalPercentage < 100) {
			double remainder = 100.0 - totalPercentage;
			// Handle Emergency
			double emergencyPercentage = 0.5 * remainder;
			map.put("Emergency", BudgetrMath.rounder(emergencyPercentage));
			// Handle Recreation
			double recreationPercentage = 0.25 * remainder;
			map.put("Recreation", BudgetrMath.rounder(recreationPercentage));
			// Handle Savings
			double savingsPercentage = 0.25 * remainder;
			map.put("Savings",  BudgetrMath.rounder(savingsPercentage));
		}
		return map;
	}
	
	public static void main (String[] args) {
		Map<String, Double> percent_map = new HashMap<String, Double>();
		percent_map.put("Groceries", 8.0);
		percent_map.put("Rent", 30.0);
		percent_map.put("Transportation", 15.0);
		percent_map.put("Loans", 15.0);
		percent_map.put("Utilities", 20.0);
		
		System.out.println("First printing out the original percent_map:");
		printMap(percent_map);
		
		System.out.println(" ");
		System.out.println("----------");
		System.out.println(" ");
		
		System.out.println("Now printing out the total allocation of percentages:");
		printMap(totalAllocationPercentages(percent_map));
		
		System.out.println(" ");
		System.out.println("----------");
		System.out.println(" ");
		
		System.out.println("Now printing out the hard spending values:");
		Map<String, Double> total_allocation = totalAllocationPercentages(percent_map);
		Map<String, Double> spending_map = amountOfSalary(total_allocation, 5000.0);
		printMap(spending_map);
	}
	
}

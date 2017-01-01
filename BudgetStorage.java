
import java.util.ArrayList;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;

public class BudgetStorage {
	
	private static class Node {
		double spending;
		double percentOfSalary;
		String category;
		
		public Node(String c) {
			spending = 0.0; percentOfSalary = 0; category = c;
		}
		
		// Backup constructor just in case;
		public Node (double value, double percent, String c,  Node p) {
			spending = value; percentOfSalary = percent; category = c;
		}
	}
	
	//Initialize Hash Table
	private final int SIZE = 199;
	Node [] storage = new Node[SIZE]; 
	
	//Hash Function Here
	int hash(String c, int M) {
		int intLength = c.length() / 4;
		long sum = 0;
		for (int i = 0; i < intLength; i++) {
			char s[] = c.substring(i * 4, (i * 4) + 4).toCharArray();
			long mult = 1;
			for (int j = 0; j < s.length; j++) {
				sum += s[j] * mult;
				mult *= 256;
			}
		}
		char s[] = c.substring(intLength * 4).toCharArray();
		long mult = 1;
		for (int j = 0; j < s.length; j++) {
			sum += s[j] * mult;
			mult *= 256;
		}
		return (int) (Math.abs(sum) % M);
	}
	
	
	//Insert a specific financial category into the hash table
	public void insert(String c, double spending, double percent) {
		storage[hash(c, SIZE)] = insertHelper(c, hash(c, SIZE));
		storage[hash(c, SIZE)].spending = spending;
		storage[hash(c, SIZE)].percentOfSalary = percent;
	}
	private Node insertHelper(String c, int location) {
		if (storage[location] == null) {
			storage[location] = new Node(c);
			return storage[location];
		}
		else {
			return insertHelper(c, ++location);
		}
	}
	
	// Return a specific spending value for a specific financial category
	public double searchSpending(String c) {
		return storage[hash(c, SIZE)].spending;
	}
	
	public double searchPercent(String c) {
		return (storage[hash(c, SIZE)].percentOfSalary);
	}
	
	//Iterates through the hash table and returns an ArrayList of all spending
	public ArrayList<Double> getAllSpending() {
		ArrayList<Double> spending = new ArrayList<Double>();
		for (int i = 0; i < SIZE; ++i) {
			if (storage[i] != null) {
				spending.add(storage[i].spending);
			}
		}
		return spending;
	}
	
	//Iterates through the ArrayList and gets the total Spending 
		public double totalSpending(ArrayList<Double> c) {
			double total = 0.0;
			for (int i = 0; i < c.size(); ++i) {
				total += c.get(i);
			}
			return total;
		}
	
	//Iterates through the hash table and returns an ArrayList of all percentages
	public ArrayList<Double> getAllPercents() {
		ArrayList<Double> percents = new ArrayList<Double>();
		for (int i = 0; i < SIZE; ++i) {
			if (storage[i] != null) {
				percents.add(storage[i].percentOfSalary);
			}
		}
		return percents;
	}
	
	//Iterates through ArrayList and gets the total percent
	public double totalPercent(ArrayList<Double> c) {
		double total = 0.0;
		for (int i = 0; i < c.size(); ++i) {
			total += c.get(i);
		}
		return total;
	}
	
	
	// Using XChart API to generate pie chart of spending
	public PieChart getChart() {
		//Creating Chart
		PieChart chart = new PieChartBuilder().width(800).height(600).title("Monthly Spending").theme(ChartTheme.GGPlot2).build();
		
		//Chart Customization
		chart.getStyler().setLegendVisible(false);
		chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
		chart.getStyler().setAnnotationDistance(1.15);
		chart.getStyler().setPlotContentSize(.7);
		chart.getStyler().setStartAngleInDegrees(90);
		
		//Adding data
		for (int i = 0; i < SIZE; ++i) {
			if (storage[i] != null) {
				chart.addSeries(storage[i].category, storage[i].percentOfSalary);
			}
		}
		
		//Show 
		new SwingWrapper(chart).displayChart();
		
		return chart;
	}
	
	public static void main(String[] args) {
		
		BudgetStorage B = new BudgetStorage();
		B.insert("loans", 447.00, 23);
		B.insert("groceries", 225.00, 17);
		B.insert("rent", 1250.00, 45);
		B.insert("transport", 100.00, 25);
		System.out.println("Test 01:  Should print out\n" + 447.00);
		System.out.println(B.searchSpending("loans"));
		
		System.out.println("--------------------------");
		
		System.out.println("Test 02:  Should print out\n" + 225.00);
		System.out.println(B.searchSpending("groceries"));
		
		System.out.println("--------------------------");
		
		System.out.println("Test 03:  Should print out\n[447.0, 1250.0, 100.0, 225.0]");
		System.out.println(B.getAllSpending());
		System.out.println("--------------------------");
		
		System.out.println("Test 04:  Should print out\n2022.0");
		System.out.println(B.totalSpending(B.getAllSpending()));
		
		System.out.println("--------------------------");
		
		BudgetStorage C = new BudgetStorage();
		C.insert("Groceries",200.00, 10);
		C.insert("Utilities", 400.00,  25);
		C.insert("Rent", 1250.00,  30);
		C.insert("Loans", 800.00, 20);
		C.insert("Transport", 100, 7);
		C.insert("Savings",50, 4);
		C.insert("Recreation",50, 4);
		
		System.out.println("Test 05:  Should print out\n" + 10);
		System.out.println(C.searchPercent("Groceries"));
		
		System.out.println("--------------------------");
		
		System.out.println("Test 06:  Should print out\n" + 25);
		System.out.println(C.searchPercent("Utilities"));
		
		C.getChart();
		
		
		
		
	}
}

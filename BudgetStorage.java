import java.util.ArrayList;

public class BudgetStorage {
	
	private static class Node {
		double spending;
		int percentOfSalary;
		String category;
		
		// First mode, user enters ALREADY KNOWN spending of categories
		public Node (double value, String c) {
			spending = value; percentOfSalary = 0; category = c;
		}
		// Second Mode, user enters PERCENTAGE of salary they want to spend for category
		public Node (int percent, String c) {
			spending = 0.0; percentOfSalary = percent; category = c;
		}
		// Third constructor for just inserting string category
		public Node(String c) {
			spending = 0.0; percentOfSalary = 0; category = c;
		}
		
		
		// Third constructor just for settling entire budget at last stage.
		public Node (double value, int percent, String c,  Node p) {
			spending = value; percentOfSalary = percent; category = c;
		}
		
		// Access Methods for spending/percent/string
		public Double getSpending() {
			return this.spending;
		}
		public Integer getPercent() {
			return this.percentOfSalary;
		}
		public String getCategory() {
			return this.category;
		}
	}
	private final int SIZE = 29;
	Node [] storage = new Node[SIZE]; 
	// Set initial values of percent/spending to 0/0.0
	
	
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
	public void insert(String c, int percent) {
		storage[hash(c, SIZE)] = insertHelper(c, hash(c, SIZE));
		storage[hash(c, SIZE)].percentOfSalary = percent;
	}
	public void insert(String c, double spending) {
		storage[hash(c, SIZE)] = insertHelper(c, hash(c, SIZE));
		storage[hash(c, SIZE)].spending = spending;
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
	public int searchPercent(String c) {
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
	//Iterates through the ArrayList and gets the sum 
	public double totalSpending(ArrayList<Double> c) {
		double total = 0.0;
		for (int i = 0; i < c.size(); ++i) {
			total += c.get(i);
		}
		return total;
	}
	
	public static void main(String[] args) {
		
		BudgetStorage B = new BudgetStorage();
		B.insert("loans", 447.00);
		B.insert("groceries", 225.00);
		B.insert("rent", 1250.00);
		B.insert("transport", 100.00);
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
		C.insert("groceries", 10);
		C.insert("utilities", 25);
		
		
		System.out.println("Test 05:  Should print out\n" + 10);
		System.out.println(C.searchPercent("groceries"));
		
		System.out.println("--------------------------");
		
		System.out.println("Test 06:  Should print out\n" + 25);
		System.out.println(C.searchPercent("utilities"));
		
	}
}

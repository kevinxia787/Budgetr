
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
	
	private final int SIZE = 19;
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
	public void insert(String c) {
		storage[hash(c, SIZE)] = insertHelper(c, hash(c, SIZE));
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
}

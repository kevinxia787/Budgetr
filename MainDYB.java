import java.util.Scanner; 


public class MainDYB {
	public static void main (String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to DisplayYourBudget!");
		System.out.println("Which option will you choose today?");
		
		System.out.println("--------------------");
		
		System.out.println("1. Designate a desired percentage portion of salary to spend.");
		System.out.println("2. Provide existening current spending for each category.");
		
		System.out.println("--------------------");
		
		System.out.println("Please choose between 1 or 2. ");
		
		BudgetStorage B = new BudgetStorage();
		double salary;
		double principal; double interest; int period; double loanPayment;
		double rent; double rentPercent; double groceries; double groceriesPercent;
		double utilities; double utilitiesPercent; double transportation; double transportationPercent;
		double recreation; double recreationPercent; double savings; double savingsPercent;
		double emergency; double emergencyPercent; double percentRemaining; double fundsRemaining;
		
		
		int choice = userInput.nextInt();
		
		//User enters percent of desired spending per category
		if (choice == 1) {
			System.out.println("Please enter your salary: ");
			salary = userInput.nextDouble();
			System.out.println("--------------------");
			System.out.println("1. I have loans.");
			System.out.println("2. I do not have loans");
			System.out.println("--------------------");
			System.out.println("Please choose between 1 or 2. ");
			int loanChoice = userInput.nextInt();
			
			// User has a loan he/she would like to pay off in ____ months
			if (loanChoice == 1) {
				System.out.println("Please enter your principal: ");
				principal = userInput.nextDouble();
				System.out.println("--------------------");
				System.out.println("Please enter your interest rate in decimal form: ");
				interest = userInput.nextDouble();
				System.out.println("--------------------");
				System.out.println("Please enter the period in months: ");
				period = userInput.nextInt();
				System.out.println("--------------------");
				System.out.println("Is the interest monthly or annually?");
				System.out.println("1. Monthly");
				System.out.println("2. Annually");
				System.out.println("--------------------");
				int rateChoice = userInput.nextInt();
				
				// Loan interest rate is monthly
				if (rateChoice == 1) {
					loanPayment = BudgetMath.loanPayment(principal, period, interest, false);
				}
				// Loan interest rate is annually
				else { loanPayment = BudgetMath.loanPayment(principal, period, interest, true); }
				B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salary, loanPayment));
			}
			
			// User does not have loans. Continue to inquire desired percentages
			System.out.println("Please enter desired percentage spending for Rent: ");
			rentPercent = userInput.nextInt();
			B.insert("Rent", BudgetMath.getPercentValue(salary, rentPercent), rentPercent);
			System.out.println("--------------------");
			System.out.println("Please enter desired percentage spending for Utilities: ");
			utilitiesPercent = userInput.nextInt();
			B.insert("Utilities", BudgetMath.getPercentValue(salary, utilitiesPercent), utilitiesPercent);
			System.out.println("--------------------");
			System.out.println("Please enter desired percentage spending for Groceries: "); 
			groceriesPercent = userInput.nextInt();
			B.insert("Groceries", BudgetMath.getPercentValue(salary, groceriesPercent), groceriesPercent);
			System.out.println("--------------------");
			System.out.println("Please enter desired percentage spending for Transportation: ");
			transportationPercent = userInput.nextInt();
			B.insert("Transportation", BudgetMath.getPercentValue(salary, transportationPercent), transportationPercent);
			System.out.println("--------------------");
			System.out.println("DisplayYourBudget will now calculate the remaining funds for the month, and split funds into Recreation/Savings/Emergency.");
			percentRemaining = BudgetMath.getRemainderPercent(B.totalPercent(B.getAllPercents()));
			System.out.println("Remaining percent: " + percentRemaining);
			fundsRemaining = BudgetMath.getPercentValue(salary, percentRemaining);
			System.out.println("Remaining funds: " + fundsRemaining);
			System.out.println("--------------------");
			savingsPercent = BudgetMath.getSRPercent(percentRemaining);
			savings = BudgetMath.getPercentValue(salary, savingsPercent);
			System.out.println("How much you should allocate towards Savings: " + savings);
			recreationPercent = BudgetMath.getSRPercent(percentRemaining);
			recreation = BudgetMath.getPercentValue(salary, recreationPercent);
			System.out.println("How much you should spend on Recreation: " + recreation);
			emergencyPercent = BudgetMath.getEmergencyPercent(percentRemaining);
			emergency = BudgetMath.getPercentValue(salary, emergencyPercent);
			System.out.println("How much you should allocate towards Emergency Fund: " + emergency);
			System.out.println("--------------------");
			B.insert("Savings", savings, savingsPercent);
			B.insert("Recreation", recreation, recreationPercent);
			B.insert("Emergency", emergency, emergencyPercent);
			B.getChart();
			
		}
		else {
			System.out.println("Please enter your salary: ");
			salary = userInput.nextDouble();
			System.out.println("--------------------");
			System.out.println("1. I have loans.");
			System.out.println("2. I do not have loans");
			System.out.println("--------------------");
			System.out.println("Please choose between 1 or 2. ");
			int loanChoice = userInput.nextInt();
			
			// User has a loan he/she would like to pay off in ____ months
			if (loanChoice == 1) {
				System.out.println("Please enter your principal: ");
				principal = userInput.nextDouble();
				System.out.println("--------------------");
				System.out.println("Please enter your interest rate in decimal form: ");
				interest = userInput.nextDouble();
				System.out.println("--------------------");
				System.out.println("Please enter the period in months: ");
				period = userInput.nextInt();
				System.out.println("--------------------");
				System.out.println("Is the interest monthly or annually?");
				System.out.println("1. Monthly");
				System.out.println("2. Annually");
				System.out.println("--------------------");
				int rateChoice = userInput.nextInt();
				
				// Loan interest rate is monthly
				if (rateChoice == 1) {
					loanPayment = BudgetMath.loanPayment(principal, period, interest, false);
				}
				// Loan interest rate is annually
				else { loanPayment = BudgetMath.loanPayment(principal, period, interest, true); }
				B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salary, loanPayment));
			}
			System.out.println("Please enter spending for Rent: ");
			rent = userInput.nextDouble();
			B.insert("Rent", rent, BudgetMath.getPercentSpending(salary, rent));
			System.out.println("--------------------");
			System.out.println("Please enter spending for Utilities: ");
			utilities = userInput.nextDouble();
			B.insert("Utilities", utilities, BudgetMath.getPercentSpending(salary, utilities));
			System.out.println("--------------------");
			System.out.println("Please enter spending for Groceries: "); 
			groceries = userInput.nextDouble();
			B.insert("Groceries", groceries, BudgetMath.getPercentSpending(salary, groceries));
			System.out.println("--------------------");
			System.out.println("Please enter spending for Transportation: ");
			transportation = userInput.nextDouble();
			B.insert("Transportation", transportation, BudgetMath.getPercentSpending(salary, transportation));
			System.out.println("--------------------");
			System.out.println("DisplayYourBudget will now calculate the remaining funds for the month, and will split funds into Recreation/Saving/Recreation.");
			fundsRemaining = BudgetMath.getRemainder(salary, B.totalSpending(B.getAllSpending()));
			percentRemaining = BudgetMath.getPercentSpending(salary, fundsRemaining);
			System.out.println("Remaining funds: " + fundsRemaining);
			System.out.println("Remaining percent: " + percentRemaining);
			System.out.println("--------------------");
			recreationPercent = BudgetMath.getSRPercent(percentRemaining);
			savingsPercent = BudgetMath.getSRPercent(percentRemaining);
			emergencyPercent = BudgetMath.getEmergencyPercent(percentRemaining);
			savings = BudgetMath.getPercentValue(salary, savingsPercent);
			recreation = BudgetMath.getPercentValue(salary, recreationPercent);
			emergency = BudgetMath.getPercentValue(salary, emergencyPercent);
			System.out.println("How much you should allocate towards Savings: " + savings);
			System.out.println("How much you should allocate towards Recreation: " + recreation);
			System.out.println("How much you should allocate towards Emergency: " + emergency);
			System.out.println("--------------------");
			B.insert("Savings", savings, savingsPercent);
			B.insert("Recreation", recreation, recreationPercent);
			B.insert("Emergency", emergency, emergencyPercent);
			
			B.getChart();
		}
	}
}

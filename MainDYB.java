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
		double salary = 0;
		double principal; double interest; int period; double loanPayment;
		
		int choice = userInput.nextInt();
		if (choice == 1) {
			System.out.println("Please enter your salary: ");
			salary += userInput.nextDouble();
			System.out.println("--------------------");
			System.out.println("1. I have loans.");
			System.out.println("2. I do not have loans");
			System.out.println("--------------------");
			System.out.println("Please choose between 1 or 2. ");
			int loanChoice = userInput.nextInt();
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
				if (rateChoice == 1) {
					loanPayment = BudgetMath.loanPayment(principal, period, interest, false);
				}
				else { loanPayment = BudgetMath.loanPayment(principal, period, interest, true); }
				B.insert("Loans", loanPayment);
			}
		}
		else if (choice == 2) {
			
		}
		else {
			
		}
	}
}

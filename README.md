# DisplayYourBudget


Goal Of This Project:
The goal of this project is to develop an Java applet that asks the user whether they want to:
          1) Designate how much they want to spend for a specific category
          2) Show how much room they have left based on current spending
The financial categories (subject to improvement) are the following (ordered in order of importance):
          1) Rent
          2) Mortgage/Loans
          3) Insurance
          4) Utilities
          5) Transportation
DisplayYourBudget will take all of these values, as well as a user's monthly tax adjusted salary, and determine the remainder available.

If the user has loans or a mortgage, DisplayYourBudget will prompt the user for the principal, interest and period in months. The period can be scaled up if the user would like to pay off loans faster (This assumes constant interest)

The remainder funds available could be divided into the following categories: Recreation/Saving/Emergency
DisplayYourBudget by default recommends a 25%/25%/50% split in the aforementioned categories. I plan on adding adjustability to this portion of the program.

In the applet, DisplayYourBudget will show you a circle diagram of your budget marked with values and total.


Implementation:
I am using a hash table to store the string categories, percent value of the user chose option 1, and regular double amount if option 2 was chosen. This way, I can quickly access the node at which these values are stored in.

The node class created has 3 spots, String category for the financial category, double value for current spending, and an int percent for the designation of how much the user wants to pay.


First Edit:
I have completed the hash table and the math functions needed for this program.

My next step is to create a main function first, to ensure the methods in each class are working. Then I will make the transition from java program to java applet.
          

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

My next step is to create a main method first, to ensure the methods in each class are working. Then I will make the transition from java program to java applet. 
          



Second Edit:
I have added a main method to the BudgetStorage.java file to test the data structure. So far things are working smoothly. As of 12/28/2016 I have added 2 new methods to the file and updated insert. In my original goal, I planned to have the user pick between designating a percent value of spending or inputing the amount they currently spend. I have facilitated this with two different insert methods, one for percent value(int) and the other for current spending(double).

I also added 2 more methods to access these values. Then we can transition towards a more functional main for the program.

I created a pieChart class based on information from tutorialspoint. The problem with using this class is that it initially defines the slice values within the class. I will figure out a way to define them outside. My current plan is to create a new method that takes in all of the values from BudgetStorage.


Third Edit: 
While creating the main method of BudgetMath I started to think about how I would quickly access all of the values and ensure flawless calculation. When intializing the data structure utilized in BudgetStorage I set all of the values too null. Parsing through each category manually is rather inefficient, and does not allow for other user created categories. 

I think the next step is to make sure all number values are initialized to 0 so when adding them all up to get total spending, it won't be a hassle. 
I could use an iterator to get the running sum of all values, and store that within a field of the BudgetStorage class.


Fourth Edit:
Added methods that get all of the spending values.

I created a method that returns a ArrayList of doubles that goes through the entire hash map, checks if a given Node is null, and if it isn't, then adds the spending value into the arrayList.
The second method iterates through the ArrayList and calculates the total spending. This removes the necessity for the totalSpending method in BudgetMath.





Fifth Edit:

Deleted pieChart.java
Instead, utilized XChart API (https://github.com/timmolter/XChart) to create the piechart.
Piechart method in BudgetStorage traverses through entire hash table and gets the category and percent value.

An issue: If user ends up inputing current spending, percent will be 0. 
Fix: Within the main method of the program, user will input salary. Salary will be used to calculate the percentages of spending. This will then be inserted into the Hash Table. Afterwards, I will then return the graph.

The next goal is to create a main method that utilizes all components of DisplayYourBudget. Then, I'll aim to transform the entire program into a Java Executiable.


Sixth Edit:

Added a incomplete main method (still in progress). Hopefully this will allow the program to run smoothly once I complete the Main class. Will learn how to transition from java program to executable file.


Seventh Edit:

An issue with insert came to light after I tried inserting the percent and the spending value and tried to access them. To fix this, I added the main insert method that takes in both the int percent and the double spending. This allows me to change the type of percent to double, which will allow for more accurate percentages.

Eight Edit:

Added another method in BudgetStorage that traverses the Hash Table and gives all percents. Also created an auxillary method that calculates the total percents, which will allow me to calculate remainder in BudgetMath.
In budgetMath I added recommended remainder split, and the methods of BudgetStorage will easily accomodate for this goal.
Main should be completed in the next few days. 

Ninth Edit:
Main is complete. Program works as expected. Will end up hashing out user interface and clean it up a bit before learning how to transition from main method to an actual executable.

package application;
	
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(10, 20, 10, 20));
			primaryStage.setTitle("Budgetr");
			
			// ToggleGroup for percent vs hard values
			final ToggleGroup initSelect = new ToggleGroup();
			RadioButton rb1 = new RadioButton("Percent");
			rb1.setToggleGroup(initSelect);
			RadioButton rb2 = new RadioButton("Spending");
			rb2.setToggleGroup(initSelect);
			
			// Second ToggleGroup for Annual or Monthly Interest
			final ToggleGroup loanType = new ToggleGroup();
			RadioButton annual = new RadioButton("Annual Interest");
			annual.setToggleGroup(loanType);
			RadioButton monthly = new RadioButton("Monthly Interest");
			monthly.setToggleGroup(loanType);
			RadioButton noLoan = new RadioButton("No Loan");
			noLoan.setToggleGroup(loanType);
			
			// Adding help button
			Button helpButton = new Button("Help");
			
			
			// Side HBox
			HBox helpBox = new HBox(helpButton);
			helpBox.setPadding(new Insets(0, 0, 10, 0));
			helpBox.setAlignment(Pos.TOP_LEFT);
			
			// Adding an HBox
			HBox box = new HBox(50, rb1, rb2, annual, monthly, noLoan);
			box.setPadding(new Insets(0, 120, 10, 120));
			box.setAlignment(Pos.CENTER);
			
			// Test
			HBox testBox = new HBox(helpBox, box);
			testBox.setAlignment(Pos.TOP_CENTER);
			// Loan Info Input
			Text loan = new Text("Loan Information");
			loan.setId("loan");
			Label principallbl = new Label("Principal:");
			TextField principalTxt = new TextField("");
			Label interestlbl = new Label("Interest:");
			TextField interestTxt = new TextField();
			Label periodlbl = new Label("Period:");
			TextField periodTxt = new TextField();
			
			VBox loanBox = new VBox();
			loanBox.getChildren().addAll(principallbl, principalTxt, interestlbl, interestTxt, periodlbl, periodTxt);
			loanBox.setSpacing(5);
			loanBox.setPadding(new Insets(5, 0 ,10 ,0));
			
			// Spending Input
			Text spending = new Text("Spending");
			spending.setId("spendingLabel");
			Label salarylbl = new Label("Salary:");
			TextField salaryTxt = new TextField();
			Label grocerieslbl = new Label("Groceries:");
			TextField groceriesTxt = new TextField();
			Label transportationlbl = new Label("Transportation:");
			TextField transportationTxt = new TextField();
			Label rentlbl = new Label("Rent:");
			TextField rentTxt = new TextField();
			Label utilitieslbl = new Label("Utilities:");
			TextField utilitiesTxt = new TextField();
			
			// Budget Box
			VBox budgetBox = new VBox();
			budgetBox.getChildren().addAll(salarylbl, salaryTxt, grocerieslbl, groceriesTxt, transportationlbl, transportationTxt, rentlbl, rentTxt, utilitieslbl, utilitiesTxt);
			budgetBox.setPadding(new Insets(5,0,0,0));
			budgetBox.setSpacing(5);
			
			// Loan Label Box
			VBox loanLabel = new VBox();
			loanLabel.getChildren().addAll(loan);
			// Spending Label Box
			VBox spendingLabel = new VBox();
			spendingLabel.getChildren().addAll(spending);
			spendingLabel.setPadding(new Insets(20, 0, 0, 0));
			
			// Main Box
			VBox mainBox = new VBox();
			mainBox.getChildren().addAll(loanLabel,loanBox, spendingLabel,budgetBox);
			mainBox.setPadding(new Insets(10, 0, 0, 0));
			
			// Trigger Button
			Button trigger = new Button("Budget Me");
			HBox triggerSlot = new HBox();
			triggerSlot.getChildren().addAll(trigger);
			triggerSlot.setAlignment(Pos.BOTTOM_RIGHT);
			
			// Empty PieChart
			ObservableList<PieChart.Data> pieChartData = 
					FXCollections.observableArrayList(
					new PieChart.Data("Groceries", 25),
					new PieChart.Data("Utilities", 25),
					new PieChart.Data("Rent", 25.0),
					new PieChart.Data("Transportation", 25.0));
			PieChart chart = new PieChart(pieChartData);
			chart.setTitle("Monthly Budget");
			
			// Empyty Table
			TableView<Category> table = new TableView<Category>();
			ObservableList<Category> dataTable = 
					FXCollections.observableArrayList(
							new Category("Groceries", 0.0, 0.0),
							new Category("Utilities", 0.0, 0.0),
							new Category("Rent", 0.0, 0.0),
							new Category("Transportation", 0.0, 0.0));
			final Label tableTitle = new Label("Numeric Budget Values");
			
			TableColumn categoryCol = new TableColumn("Category");
			categoryCol.setCellValueFactory(
					new PropertyValueFactory<Category, String>("category"));
			TableColumn percentCol = new TableColumn("Percent");
			percentCol.setCellValueFactory(
					new PropertyValueFactory<Category, String>("percent"));
			TableColumn spendingCol = new TableColumn("Spending");
			spendingCol.setCellValueFactory(
					new PropertyValueFactory<Category, String>("spending"));
			
			table.setItems(dataTable);
			table.getColumns().addAll(categoryCol, percentCol, spendingCol);
			
			VBox rightBox = new VBox();
			rightBox.setSpacing(5);
			rightBox.setPadding(new Insets(10, 0, 0, 10));
			rightBox.getChildren().addAll(tableTitle, table);
			
			//Layout
			root.setTop(testBox);
			root.setLeft(mainBox);
			root.setRight(rightBox);
			root.setBottom(triggerSlot);
			root.setCenter(chart);

			Scene scene = new Scene(root,1000,600);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			helpButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Help");
					alert.setHeaderText(null);
					alert.setContentText("How do I use this?\n\nIf you are trying to estimate your budget, pick\npercent and input percents in the spending categories.\nOtherwise, pick spending and input hard values.\nThen, pick a loan type, and enter the values requested.\nAfter, just hit enter and your budget will be calculated.");
					alert.showAndWait();
				}
				
			});
			
			trigger.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Map<String, Double> spending = new HashMap<String, Double>();
					Map<String, Double> percent = new HashMap<String, Double>();
					Map<String, Double> loan = new HashMap<String, Double>();
					double salary = Double.parseDouble(salaryTxt.getText());
					if (rb2.isSelected()) {
						if (annual.isSelected()) {
							// Grab all of the values neccesary to calculate loan
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest", Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 1.0);
							// Calculate loan amount first
							double loanAmount = LoanCalc.loanCalc(loan);
							// Add loanAmount to the spending map first
							spending.put("Loans", loanAmount);
							// Add in the values from userInput
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Now get the percent values of the original spending map + allocation of remainder
							Map<String, Double> spendingPercentMap = SpendingCalc.totalAllocation(spending, salary);
							// Grab the spending values of entire allocation
							Map<String, Double> spendingValuesMap = PercentCalc.amountOfSalary(spendingPercentMap, salary);
							// Set up pieChart New Data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Groceries", spendingPercentMap.get("Groceries")),
									new PieChart.Data("Utilities", spendingPercentMap.get("Utilities")),
									new PieChart.Data("Rent", spendingPercentMap.get("Rent")),
									new PieChart.Data("Transportation", spendingPercentMap.get("Transportation")),
									new PieChart.Data("Recreation", spendingPercentMap.get("Recreation")),
									new PieChart.Data("Savings", spendingPercentMap.get("Savings")),
									new PieChart.Data("Loans", spendingPercentMap.get("Loans")),
									new PieChart.Data("Emergency", spendingPercentMap.get("Emergency")));
	
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							// Add Values to Table
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", spendingPercentMap.get("Groceries"), spendingValuesMap.get("Groceries")),
											new Category("Utilities", spendingPercentMap.get("Utilities"), spendingValuesMap.get("Utilities")),
											new Category("Rent", spendingPercentMap.get("Rent"), spendingValuesMap.get("Rent")),
											new Category("Transportation", spendingPercentMap.get("Transportation"), spendingValuesMap.get("Transportation")),
											new Category("Recreation", spendingPercentMap.get("Recreation"), spendingValuesMap.get("Recreation")),
											new Category("Savings", spendingPercentMap.get("Savings"), spendingValuesMap.get("Savings")),
											new Category("Loans", spendingPercentMap.get("Loans"), spendingValuesMap.get("Loans")),
											new Category("Emergency", spendingPercentMap.get("Emergency"), spendingValuesMap.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
						}
						else if (monthly.isSelected()) {
							// Grab necessary loan values
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest", Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 0.0);
							// Calculate loan amount first
							double loanAmount = LoanCalc.loanCalc(loan);
							// Add loanAmount to the spending map first
							spending.put("Loans", loanAmount);
							// Add in the values from userInput
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Now get the percent values of the original spending map + allocation of remainder
							Map<String, Double> spendingPercentMap = SpendingCalc.totalAllocation(spending, salary);
							// Grab the spending values of entire allocation
							Map<String, Double> spendingValuesMap = PercentCalc.amountOfSalary(spendingPercentMap, salary);
							// Set up pieChart New Data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Groceries", spendingPercentMap.get("Groceries")),
									new PieChart.Data("Utilities", spendingPercentMap.get("Utilities")),
									new PieChart.Data("Rent", spendingPercentMap.get("Rent")),
									new PieChart.Data("Transportation", spendingPercentMap.get("Transportation")),
									new PieChart.Data("Recreation", spendingPercentMap.get("Recreation")),
									new PieChart.Data("Savings", spendingPercentMap.get("Savings")),
									new PieChart.Data("Loans", spendingPercentMap.get("Loans")),
									new PieChart.Data("Emergency", spendingPercentMap.get("Emergency")));
									
	
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							// Add Values to Table
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", spendingPercentMap.get("Groceries"), spendingValuesMap.get("Groceries")),
											new Category("Utilities", spendingPercentMap.get("Utilities"), spendingValuesMap.get("Utilities")),
											new Category("Rent", spendingPercentMap.get("Rent"), spendingValuesMap.get("Rent")),
											new Category("Transportation", spendingPercentMap.get("Transportation"), spendingValuesMap.get("Transportation")),
											new Category("Recreation", spendingPercentMap.get("Recreation"), spendingValuesMap.get("Recreation")),
											new Category("Savings", spendingPercentMap.get("Savings"), spendingValuesMap.get("Savings")),
											new Category("Loans", spendingPercentMap.get("Loans"), spendingValuesMap.get("Loans")),
											new Category("Emergency", spendingPercentMap.get("Emergency"), spendingValuesMap.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
						}
						else {
							// Grab spending values
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Now get the percent values of the original spending map + allocation of remainder
							Map<String, Double> spendingPercentMap = SpendingCalc.totalAllocation(spending, salary);
							// Grab the spending values of entire allocation
							Map<String, Double> spendingValuesMap = PercentCalc.amountOfSalary(spendingPercentMap, salary);
							// Set up pieChart New Data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Groceries", spendingPercentMap.get("Groceries")),
									new PieChart.Data("Utilities", spendingPercentMap.get("Utilities")),
									new PieChart.Data("Rent", spendingPercentMap.get("Rent")),
									new PieChart.Data("Transportation", spendingPercentMap.get("Transportation")),
									new PieChart.Data("Recreation", spendingPercentMap.get("Recreation")),
									new PieChart.Data("Savings", spendingPercentMap.get("Savings")),
									new PieChart.Data("Emergency", spendingPercentMap.get("Emergency")));
	
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							// Add Values to Table
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", spendingPercentMap.get("Groceries"), spendingValuesMap.get("Groceries")),
											new Category("Utilities", spendingPercentMap.get("Utilities"), spendingValuesMap.get("Utilities")),
											new Category("Rent", spendingPercentMap.get("Rent"), spendingValuesMap.get("Rent")),
											new Category("Transportation", spendingPercentMap.get("Transportation"), spendingValuesMap.get("Transportation")),
											new Category("Recreation", spendingPercentMap.get("Recreation"), spendingValuesMap.get("Recreation")),
											new Category("Savings", spendingPercentMap.get("Savings"), spendingValuesMap.get("Savings")),
											new Category("Emergency", spendingPercentMap.get("Emergency"), spendingValuesMap.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
						}
					}
					else {
						if (annual.isSelected()) {
							// Grab loan information
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest",  Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 1.0);
							// Calculate loan amount
							double loanAmount = LoanCalc.loanCalc(loan);
							// Find loanAmout percent of salary
							double percentLoanAmount = BudgetrMath.spendingPercent(salary, loanAmount);
							// Add percent to existing percent map
							percent.put("Loans", percentLoanAmount);
							// Add remaining values of percents
							percent.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							percent.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							percent.put("Rent", Double.parseDouble(rentTxt.getText()));
							percent.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Find total allocation of percentages
							Map<String, Double> totalAllocation = PercentCalc.totalAllocationPercentages(percent);
							// Now find the amount of money that represents
							Map<String, Double> hardValueAllocation = PercentCalc.amountOfSalary(totalAllocation, salary);
							// Graph the percent data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Loans", totalAllocation.get("Loans")),
									new PieChart.Data("Groceries",totalAllocation.get("Groceries")),
									new PieChart.Data("Utilities", totalAllocation.get("Utilities")),
									new PieChart.Data("Rent", totalAllocation.get("Rent")),
									new PieChart.Data("Transportation", totalAllocation.get("Transportation")),
									new PieChart.Data("Recreation", totalAllocation.get("Recreation")),
									new PieChart.Data("Savings", totalAllocation.get("Savings")),
									new PieChart.Data("Emergency", totalAllocation.get("Emergency")));
								
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							
							// Add Values to Table
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", totalAllocation.get("Groceries"), hardValueAllocation.get("Groceries")),
											new Category("Utilities", totalAllocation.get("Utilities"), hardValueAllocation.get("Utilities")),
											new Category("Rent", totalAllocation.get("Rent"), hardValueAllocation.get("Rent")),
											new Category("Transportation", totalAllocation.get("Transportation"), hardValueAllocation.get("Transportation")),
											new Category("Recreation", totalAllocation.get("Recreation"), hardValueAllocation.get("Recreation")),
											new Category("Savings", totalAllocation.get("Savings"), hardValueAllocation.get("Savings")),
											new Category("Loans", totalAllocation.get("Loans"),hardValueAllocation.get("Loans")),
											new Category("Emergency", totalAllocation.get("Emergency"), hardValueAllocation.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
							
						}
						else if (monthly.isSelected()) {
							// Grab loan values from userInput
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest",  Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 0.0);
							// Calculate loan amount
							double loanAmount = LoanCalc.loanCalc(loan);
							// Find loanAmout percent of salary
							double percentLoanAmount = BudgetrMath.spendingPercent(salary, loanAmount);
							// Add percent to existing percent map
							percent.put("Loans", percentLoanAmount);
							// Add remaining values of percents
							percent.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							percent.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							percent.put("Rent", Double.parseDouble(rentTxt.getText()));
							percent.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Find total allocation of percentages
							Map<String, Double> totalAllocation = PercentCalc.totalAllocationPercentages(percent);
							// Now find the amount of money that represents
							Map<String, Double> hardValueAllocation = PercentCalc.amountOfSalary(totalAllocation, salary);
							// Graph the percent data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Loans", totalAllocation.get("Loans")),
									new PieChart.Data("Groceries",totalAllocation.get("Groceries")),
									new PieChart.Data("Utilities", totalAllocation.get("Utilities")),
									new PieChart.Data("Rent", totalAllocation.get("Rent")),
									new PieChart.Data("Transportation", totalAllocation.get("Transportation")),
									new PieChart.Data("Recreation", totalAllocation.get("Recreation")),
									new PieChart.Data("Savings", totalAllocation.get("Savings")),
									new PieChart.Data("Emergency", totalAllocation.get("Emergency")));
								
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", totalAllocation.get("Groceries"), hardValueAllocation.get("Groceries")),
											new Category("Utilities", totalAllocation.get("Utilities"), hardValueAllocation.get("Utilities")),
											new Category("Rent", totalAllocation.get("Rent"), hardValueAllocation.get("Rent")),
											new Category("Transportation", totalAllocation.get("Transportation"), hardValueAllocation.get("Transportation")),
											new Category("Recreation", totalAllocation.get("Recreation"), hardValueAllocation.get("Recreation")),
											new Category("Savings", totalAllocation.get("Savings"), hardValueAllocation.get("Savings")),
											new Category("Loans", totalAllocation.get("Loans"),hardValueAllocation.get("Loans")),
											new Category("Emergency", totalAllocation.get("Emergency"), hardValueAllocation.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
							
						}
						else {
							// Grab allocationValues
							percent.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							percent.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							percent.put("Rent", Double.parseDouble(rentTxt.getText()));
							percent.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
							// Find total allocation of percentages
							Map<String, Double> totalAllocation = PercentCalc.totalAllocationPercentages(percent);
							// Now find the amount of money that represents
							Map<String, Double> hardValueAllocation = PercentCalc.amountOfSalary(totalAllocation, salary);
							// Graph the percent data
							ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
									new PieChart.Data("Groceries",totalAllocation.get("Groceries")),
									new PieChart.Data("Utilities", totalAllocation.get("Utilities")),
									new PieChart.Data("Rent", totalAllocation.get("Rent")),
									new PieChart.Data("Transportation", totalAllocation.get("Transportation")),
									new PieChart.Data("Recreation", totalAllocation.get("Recreation")),
									new PieChart.Data("Savings", totalAllocation.get("Savings")),
									new PieChart.Data("Emergency", totalAllocation.get("Emergency")));
								
							PieChart chart2 = new PieChart(pieChartData);
							root.setCenter(chart2);
							
							
							TableView<Category> newTable = new TableView<Category>();
							ObservableList<Category> dataTable = 
									FXCollections.observableArrayList(
											new Category("Groceries", totalAllocation.get("Groceries"), hardValueAllocation.get("Groceries")),
											new Category("Utilities", totalAllocation.get("Utilities"), hardValueAllocation.get("Utilities")),
											new Category("Rent", totalAllocation.get("Rent"), hardValueAllocation.get("Rent")),
											new Category("Transportation", totalAllocation.get("Transportation"), hardValueAllocation.get("Transportation")),
											new Category("Recreation", totalAllocation.get("Recreation"), hardValueAllocation.get("Recreation")),
											new Category("Savings", totalAllocation.get("Savings"), hardValueAllocation.get("Savings")),
											new Category("Emergency", totalAllocation.get("Emergency"), hardValueAllocation.get("Emergency")));
							

							Label titleOfTable = new Label("Numeric Budget Values");
							TableColumn categoryCol = new TableColumn("Category");
							categoryCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("category"));
							TableColumn percentCol = new TableColumn("Percent");
							percentCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("percent"));
							TableColumn spendingCol = new TableColumn("Spending");
							spendingCol.setCellValueFactory(
									new PropertyValueFactory<Category, String>("spending"));
							newTable.setItems(dataTable);
							newTable.getColumns().addAll(categoryCol, percentCol, spendingCol);
							
							VBox rightBox2 = new VBox();
							rightBox2.setSpacing(5);
							rightBox2.setPadding(new Insets(10, 0, 0, 10));
							rightBox2.getChildren().addAll(titleOfTable, newTable);
							
							root.setRight(rightBox2);
						}
					}
				}
				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

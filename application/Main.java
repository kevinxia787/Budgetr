package application;
	
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
			
			// Adding an HBox
			HBox box = new HBox(50, rb1, rb2, annual, monthly);
			box.setPadding(new Insets(0, 0, 10, 0));
			box.setAlignment(Pos.CENTER);
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
			Label salarylbl = new Label("Salary");
			TextField salaryTxt = new TextField();
			Label grocerieslbl = new Label("Groceries");
			TextField groceriesTxt = new TextField();
			Label transportationlbl = new Label("Transportation");
			TextField transportationTxt = new TextField();
			Label rentlbl = new Label("Rent");
			TextField rentTxt = new TextField();
			Label utilitieslbl = new Label("Utilities");
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
			
			//Layout
			root.setTop(box);
			root.setLeft(mainBox);
			root.setBottom(triggerSlot);

			Scene scene = new Scene(root,800,600);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			trigger.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Map<String, Double> spending = new HashMap<String, Double>();
					Map<String, Double> percent = new HashMap<String, Double>();
					Map<String, Double> loan = new HashMap<String, Double>();
					if (rb2.isSelected()) {
						if (annual.isSelected()) {
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest", Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 1.0);
							
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
						}
						else if (monthly.isSelected()) {
							loan.put("Principal", Double.parseDouble(principalTxt.getText()));
							loan.put("Interest", Double.parseDouble(interestTxt.getText()));
							loan.put("Period", Double.parseDouble(periodTxt.getText()));
							loan.put("Yearly", 1.0);
							
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
						}
						else {
							spending.put("Groceries", Double.parseDouble(groceriesTxt.getText()));
							spending.put("Transportation", Double.parseDouble(transportationTxt.getText()));
							spending.put("Rent", Double.parseDouble(rentTxt.getText()));
							spending.put("Utilities", Double.parseDouble(utilitiesTxt.getText()));
						}
					}
					else {
						if (annual.isSelected()) {
							
						}
						else if (monthly.isSelected()) {
							
						}
						else {
							
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

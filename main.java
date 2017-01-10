import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;

public class main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel gui, choiceBar, insertPanel, tablePanel;
	private JButton showBudget;
	
	public main() {
		
		BudgetStorage B = new BudgetStorage();
	
		setTitle("Display Your Budget");
		setSize(800, 1000);
		JPanel gui = new JPanel(new BorderLayout());
				
		// Choice bar at top, implemented using flowlayout and two radio button groups
		choiceBar = new JPanel(new FlowLayout());
				
		// First radioButton group
		JRadioButton percentBased = new JRadioButton("Percent Based");
		JRadioButton currentBased = new JRadioButton("Current Spending");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(percentBased); group1.add(currentBased);
		
		// Second radioButton group
		JRadioButton loanTrue = new JRadioButton("I have loans");
		JRadioButton loanFalse = new JRadioButton("I do not have loans");
		ButtonGroup group2 = new ButtonGroup();
		group2.add(loanFalse); group2.add(loanTrue);
		
		// Third radioButton group
		JRadioButton monthly = new JRadioButton("Monthly Interest");
		JRadioButton annually = new JRadioButton("Annual Interest");
		ButtonGroup group3 = new ButtonGroup();
		group3.add(monthly); group3.add(annually);
		
		//adding to choiceBar 
		choiceBar.add(percentBased); choiceBar.add(currentBased); 
		choiceBar.add(loanFalse); choiceBar.add(loanTrue);
		choiceBar.add(annually); choiceBar.add(monthly);
		
		// Side bar for financial inserting
		insertPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(insertPanel);
		insertPanel.setLayout(groupLayout);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		
		// Display Button
		JButton displayMyBudget = new JButton("Display My Budget");
		JLabel displayLabel = new JLabel("Finish");
		
		// JTextFields for side bar
		JTextField salary = new JTextField("0.0");
		JTextField loanPrincipal = new JTextField("0.0");
		JTextField interestRate = new JTextField("0.0");
		JTextField period = new JTextField("0");
		
		JTextField rentInsert = new JTextField("0.0");
		JTextField utilitiesInsert = new JTextField("0.0");
		JTextField groceriesInsert = new JTextField("0.0");
		JTextField transportationInsert = new JTextField("0.0");
		
		// JLabels for JTextFields
		JLabel salaryLabel = new JLabel("Insert salary here: ");
		JLabel loanLabel = new JLabel("Insert principal here: ");
		JLabel interestLabel = new JLabel("Insert interest rate in decimal form: ");
		JLabel periodLabel = new JLabel("Insert period in months: ");
		JLabel rentLabel = new JLabel("Rent Spending: ");
		JLabel utilitiesLabel = new JLabel("Utilities Spending: ");
		JLabel groceriesLabel = new JLabel("Groceries Spending: ");
		JLabel transportationLabel = new JLabel("Transportation Spending: ");
		
		// Grouping JTextFields
		GroupLayout.SequentialGroup jTFGroupH = groupLayout.createSequentialGroup();
		GroupLayout.SequentialGroup jTFGroupV = groupLayout.createSequentialGroup();
		// Horizontal Group
		jTFGroupH.addGroup(groupLayout.createParallelGroup()
				.addComponent(salaryLabel)
				.addComponent(loanLabel).addComponent(interestLabel).addComponent(periodLabel)
				.addComponent(rentLabel).addComponent(utilitiesLabel)
				.addComponent(groceriesLabel).addComponent(transportationLabel).addComponent(displayLabel));
		jTFGroupH.addGroup(groupLayout.createParallelGroup()
				.addComponent(salary)
				.addComponent(loanPrincipal).addComponent(interestRate).addComponent(period)
				.addComponent(rentInsert).addComponent(utilitiesInsert).addComponent(groceriesInsert).addComponent(transportationInsert)
				.addComponent(displayMyBudget));
		groupLayout.setHorizontalGroup(jTFGroupH);
		
		// Vertical Group
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(salaryLabel).addComponent(salary));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(loanLabel).addComponent(loanPrincipal));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(interestLabel).addComponent(interestRate));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(periodLabel).addComponent(period));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(rentLabel).addComponent(rentInsert));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(utilitiesLabel).addComponent(utilitiesInsert));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(groceriesLabel).addComponent(groceriesInsert));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(transportationLabel).addComponent(transportationInsert));
		jTFGroupV.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(displayLabel).addComponent(displayMyBudget));
		groupLayout.setVerticalGroup(jTFGroupV);
		
		// Clear JTextField Upon Clicking
		salary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salary.setText("");
			}
		});
		loanPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loanPrincipal.setText("");
			}
		});
		interestRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interestRate.setText("");
			}
		});
		period.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				period.setText("");
			}
		});
		rentInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rentInsert.setText("");
			}
		});
		utilitiesInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utilitiesInsert.setText("");
			}
		});
		groceriesInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				groceriesInsert.setText("");
			}
		});
		transportationInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transportationInsert.setText("");
			}
		});
		
		// Button Listener
		displayMyBudget.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				// Loan Components
				String loanValue = loanPrincipal.getText();
				String interestValue = interestRate.getText();
				String periodValue = period.getText();
				String salaryValue = salary.getText();
				
				// parse Values from Strings
				double loanAmount = Double.parseDouble(loanValue);
				double interestAmount = Double.parseDouble(interestValue);
				int periodAmount = Integer.parseInt(periodValue);
				double salaryAmount = Double.parseDouble(salaryValue);
				
				// Rest of the Financial Categories, get texts from textsFields
				String rentValue = rentInsert.getText();
				String utilitiesValue = utilitiesInsert.getText();
				String groceriesValue = groceriesInsert.getText();
				String transportationValue = transportationInsert.getText();
				
				// parse % Values from Strings
				double rentPercent = Double.parseDouble(rentValue);
				double utilitiesPercent = Double.parseDouble(utilitiesValue);
				double groceriesPercent = Double.parseDouble(groceriesValue);
				double transportationPercent = Double.parseDouble(transportationValue);
				
				// parse $ Values from Strings
				double rentAmount = Double.parseDouble(rentValue);
				double utilitiesAmount = Double.parseDouble(utilitiesValue);
				double groceriesAmount = Double.parseDouble(groceriesValue);
				double transportationAmount = Double.parseDouble(transportationValue);
				
				if (percentBased.isSelected()) {
					if (loanTrue.isSelected()) {
						// Create dataset first
						DefaultPieDataset dataset = new DefaultPieDataset();
						double loanPayment;
						// Inserting loan in BudgetStorage
						if (monthly.isSelected()) {
							loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, false);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
							dataset.setValue("Loans", loanPayment);
						}
						else {
							loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, true);
							dataset.setValue("Loans", loanPayment);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
						}
						// Inserting into BudgetStorage
						B.insert("Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent), rentPercent);
						B.insert("Utilities", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent), utilitiesPercent);
						B.insert("Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent), groceriesPercent);
						B.insert("Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent), transportationPercent);
						
						
						// Remainder Spending Allocation
						double totalPercent = B.totalPercent(B.getAllPercents()); //Values aren't inserted anymore, must insert for accuracy
						double remainder = BudgetMath.getRemainderPercent(totalPercent);
						double savingsPercent = BudgetMath.getSRPercent(remainder);
						double recreationPercent = BudgetMath.getSRPercent(remainder);
						double emergencyPercent = BudgetMath.getEmergencyPercent(remainder);
						
						// Inserting remainder
						B.insert("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent), savingsPercent);
						B.insert("Emergency", BudgetMath.getPercentValue(salaryAmount, emergencyPercent), emergencyPercent);
						B.insert("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent), recreationPercent);
						
						// Creating chart
						dataset.setValue("Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent));
						dataset.setValue("Utilites", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent));
						dataset.setValue("Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent));
						dataset.setValue("Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent));
						dataset.setValue("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent));
						dataset.setValue("Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent));
						dataset.setValue("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent));
						JFreeChart chart = ChartFactory.createPieChart(
								"Monthly Spending",
								dataset, 
								true, 
								true, 
								false
						);
						PiePlot plot = (PiePlot) chart.getPlot();
						plot.setLabelFont(new Font("Arial", Font.PLAIN, 9));
						plot.setNoDataMessage("No Data available");
						plot.setCircular(false);
						plot.setLabelGap(0.02);
						
						ChartPanel chPanel = new ChartPanel(chart);
						chPanel.setPreferredSize(new Dimension(600, 600));
						chPanel.setMouseWheelEnabled(true);
						gui.add(chPanel, BorderLayout.SOUTH);
						
						// Create a table
						String[] columnNames = {"Category", "Spending"};
						Object[][] data = {
								{"Loans", loanPayment},
								{"Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent)},
								{"Utilities", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent)},
								{"Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent)},
								{"Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent)},
								{"Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent)},
								{"Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent)},
								{"Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent)}
						};
						
						JTable table = new JTable(data, columnNames);
						JScrollPane scrollPane = new JScrollPane(table);
						JPanel tablePanel = new JPanel();
						tablePanel.add(table);
						tablePanel.setPreferredSize(new Dimension(400, 400));
						gui.add(tablePanel, BorderLayout.EAST);
						
						gui.validate();
						gui.repaint();
			
					}
					else {
						// Inserting into BudgetStorage
						B.insert("Loans", 0.0, 0.0);
						B.insert("Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent), rentPercent);
						B.insert("Utilities", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent), utilitiesPercent);
						B.insert("Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent), groceriesPercent);
						B.insert("Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent), transportationPercent);
						
						// Remainder Spending Allocation
						double totalPercent = B.totalPercent(B.getAllPercents()); //Values aren't inserted anymore, must insert for accuracy
						double remainder = BudgetMath.getRemainderPercent(totalPercent);
						double savingsPercent = BudgetMath.getSRPercent(remainder);
						double recreationPercent = BudgetMath.getSRPercent(remainder);
						double emergencyPercent = BudgetMath.getEmergencyPercent(remainder);
						
						// Insert remainder 
						B.insert("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent), savingsPercent);
						B.insert("Emergency", BudgetMath.getPercentValue(salaryAmount, emergencyPercent), emergencyPercent);
						B.insert("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent), recreationPercent);
						
						//Getting chart
						DefaultPieDataset dataset = new DefaultPieDataset();
						dataset.setValue("Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent));
						dataset.setValue("Utilites", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent));
						dataset.setValue("Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent));
						dataset.setValue("Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent));
						dataset.setValue("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent));
						dataset.setValue("Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent));
						dataset.setValue("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent));
						JFreeChart chart = ChartFactory.createPieChart(
								"Monthly Spending",
								dataset, 
								true, 
								true, 
								false
						);
						PiePlot plot = (PiePlot) chart.getPlot();
						plot.setLabelFont(new Font("Arial", Font.PLAIN, 9));
						plot.setNoDataMessage("No Data available");
						plot.setCircular(false);
						plot.setLabelGap(0.02);
						
						ChartPanel chPanel = new ChartPanel(chart);
						chPanel.setPreferredSize(new Dimension(600, 600));
						chPanel.setMouseWheelEnabled(true);
						gui.add(chPanel, BorderLayout.SOUTH);
						
						// Create a table
						String[] columnNames = {"Category", "Spending"};
						Object[][] data = {
								{"Loans", 0},
								{"Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent)},
								{"Utilities", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent)},
								{"Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent)},
								{"Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent)},
								{"Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent)},
								{"Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent)},
								{"Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent)}
						};
						
						JTable table = new JTable(data, columnNames);
						JScrollPane scrollPane = new JScrollPane(table);
						JPanel tablePanel = new JPanel();
						tablePanel.add(table);
						tablePanel.setPreferredSize(new Dimension(400, 400));
						gui.add(tablePanel, BorderLayout.EAST);
						gui.validate();
						gui.repaint();

					}
				}
				else {
					if (loanTrue.isSelected()) {
						DefaultPieDataset dataset = new DefaultPieDataset();
						double loanPayment;
						if (monthly.isSelected()) {
							loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, false);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
							dataset.setValue("Loans", loanPayment);
						}
						else {
							loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, true);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
							dataset.setValue("Loans", loanPayment);
						}
						// Inserting values into BudgetStorage
						B.insert("Rent", rentAmount, BudgetMath.getPercentSpending(salaryAmount, rentAmount));
						B.insert("Utilities", utilitiesAmount, BudgetMath.getPercentSpending(salaryAmount, utilitiesAmount));
						B.insert("Groceries", groceriesAmount, BudgetMath.getPercentSpending(salaryAmount, groceriesAmount));
						B.insert("Transportation", transportationAmount, BudgetMath.getPercentSpending(salaryAmount, transportationAmount));
						
						// Remainder Spending Allocation
						double totalPercent = B.totalPercent(B.getAllPercents()); //Values aren't inserted anymore, must insert for accuracy
						double remainder = BudgetMath.getRemainderPercent(totalPercent);
						double savingsPercent = BudgetMath.getSRPercent(remainder);
						double recreationPercent = BudgetMath.getSRPercent(remainder);
						double emergencyPercent = BudgetMath.getEmergencyPercent(remainder);
						
						// Insert remainder
						B.insert("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent), savingsPercent);
						B.insert("Emergency", BudgetMath.getPercentValue(salaryAmount, emergencyPercent), emergencyPercent);
						B.insert("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent), recreationPercent);
						
						// Getting chart
						dataset.setValue("Rent", rentAmount);
						dataset.setValue("Utilites", utilitiesAmount);
						dataset.setValue("Groceries", groceriesAmount);
						dataset.setValue("Transportation", transportationAmount);
						dataset.setValue("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent));
						dataset.setValue("Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent));
						dataset.setValue("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent));
						JFreeChart chart = ChartFactory.createPieChart(
								"Monthly Spending",
								dataset, 
								true, 
								true, 
								false
						);
						PiePlot plot = (PiePlot) chart.getPlot();
						plot.setLabelFont(new Font("Arial", Font.PLAIN, 9));
						plot.setNoDataMessage("No Data available");
						plot.setCircular(false);
						plot.setLabelGap(0.02);
						
						ChartPanel chPanel = new ChartPanel(chart);
						chPanel.setPreferredSize(new Dimension(600, 600));
						chPanel.setMouseWheelEnabled(true);
						gui.add(chPanel, BorderLayout.SOUTH);
						
						// Create table
						String[] columnNames = {"Category", "Spending"};
						Object[][] data = {
								{"Loans", loanPayment},
								{"Rent", rentAmount},
								{"Utilities", utilitiesAmount},
								{"Groceries", groceriesAmount},
								{"Transportation", transportationAmount},
								{"Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent)},
								{"Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent)},
								{"Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent)}
						};
						
						JTable table = new JTable(data, columnNames);
						JScrollPane scrollPane = new JScrollPane(table);
						JPanel tablePanel = new JPanel();
						tablePanel.add(table);
						tablePanel.setPreferredSize(new Dimension(400, 400));
						gui.add(tablePanel, BorderLayout.EAST);
						gui.validate();
						gui.repaint();

					}
					else {
						// Insert into Budget Storage
						B.insert("Loans", 0.0, 0.0);
						B.insert("Rent", rentAmount, BudgetMath.getPercentSpending(salaryAmount, rentAmount));
						B.insert("Utilities", utilitiesAmount, BudgetMath.getPercentSpending(salaryAmount, utilitiesAmount));
						B.insert("Groceries", groceriesAmount, BudgetMath.getPercentSpending(salaryAmount, groceriesAmount));
						B.insert("Transportation", transportationAmount, BudgetMath.getPercentSpending(salaryAmount, transportationAmount));
						
						// Remainder Spending Allocation
						double totalPercent = B.totalPercent(B.getAllPercents()); //Values aren't inserted anymore, must insert for accuracy
						double remainder = BudgetMath.getRemainderPercent(totalPercent);
						double savingsPercent = BudgetMath.getSRPercent(remainder);
						double recreationPercent = BudgetMath.getSRPercent(remainder);
						double emergencyPercent = BudgetMath.getEmergencyPercent(remainder);
						
						// Insert remainder
						B.insert("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent), savingsPercent);
						B.insert("Emergency", BudgetMath.getPercentValue(salaryAmount, emergencyPercent), emergencyPercent);
						B.insert("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent), recreationPercent);
						
						// Getting chart
						DefaultPieDataset dataset = new DefaultPieDataset();
						dataset.setValue("Rent", BudgetMath.getPercentValue(salaryAmount, rentPercent));
						dataset.setValue("Utilites", BudgetMath.getPercentValue(salaryAmount, utilitiesPercent));
						dataset.setValue("Groceries", BudgetMath.getPercentValue(salaryAmount, groceriesPercent));
						dataset.setValue("Transportation", BudgetMath.getPercentValue(salaryAmount, transportationPercent));
						dataset.setValue("Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent));
						dataset.setValue("Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent));
						dataset.setValue("Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent));
						JFreeChart chart = ChartFactory.createPieChart(
								"Monthly Spending",
								dataset, 
								true, 
								true, 
								false
						);
						PiePlot plot = (PiePlot) chart.getPlot();
						plot.setLabelFont(new Font("Arial", Font.PLAIN, 9));
						plot.setNoDataMessage("No Data available");
						plot.setCircular(false);
						plot.setLabelGap(0.02);
						
						ChartPanel chPanel = new ChartPanel(chart);
						chPanel.setPreferredSize(new Dimension(600, 600));
						chPanel.setMouseWheelEnabled(true);
						gui.add(chPanel, BorderLayout.SOUTH);
						
						// Create table
						String[] columnNames = {"Category", "Spending"};
						Object[][] data = {
								{"Loans", 0},
								{"Rent", rentAmount},
								{"Utilities", utilitiesAmount},
								{"Groceries", groceriesAmount},
								{"Transportation", transportationAmount},
								{"Savings", BudgetMath.getPercentValue(salaryAmount, savingsPercent)},
								{"Recreation", BudgetMath.getPercentValue(salaryAmount, recreationPercent)},
								{"Emergency",  BudgetMath.getPercentValue(salaryAmount, emergencyPercent)}
						};
						
						JTable table = new JTable(data, columnNames);
						
						JScrollPane scrollPane = new JScrollPane(table);
						JPanel tablePanel = new JPanel();
						tablePanel.add(table);
						tablePanel.setPreferredSize(new Dimension(400, 400));
						gui.add(tablePanel, BorderLayout.EAST);
						gui.validate();
						gui.repaint();
					}
				}
				
				
			}
		});
		
		//add to GUI
		gui.add(choiceBar, BorderLayout.NORTH);
		gui.add(insertPanel, BorderLayout.WEST);
		this.add(gui);
				
				
	}		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				main frame = new main();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
			
		});
	}	
}

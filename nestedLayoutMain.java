import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class nestedLayoutMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel gui, choiceBar, insertPanel, tablePanel, chartPanel;
	private JButton showBudget;
	
	public nestedLayoutMain() {
		
		BudgetStorage B = new BudgetStorage();
	
		setTitle("Display Your Budget");
		setSize(800, 800);
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
		JTextField salary = new JTextField("value");
		JTextField loanPrincipal = new JTextField("value");
		JTextField interestRate = new JTextField("decimal ");
		JTextField period = new JTextField("value");
		
		JTextField rentInsert = new JTextField("value");
		JTextField utilitiesInsert = new JTextField("value");
		JTextField groceriesInsert = new JTextField("value");
		JTextField transportationInsert = new JTextField("value");
		
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
		showBudget = new JButton("Display My Budget");
		showBudget.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				if (percentBased.isSelected()) {
					if (loanTrue.isSelected()) {
						// Loan Components
						String loanValue = loanPrincipal.getText();
						double loanAmount = Double.parseDouble(loanValue);
						String interestValue = interestRate.getText();
						double interestAmount = Double.parseDouble(interestValue);
						String periodValue = period.getText();
						int periodAmount = Integer.parseInt(periodValue);
						String salaryValue = salary.getText();
						double salaryAmount = Double.parseDouble(salaryValue);
						// Inserting loan in BudgetStorage
						if (monthly.isSelected()) {
							Double loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, false);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
						}
						else {
							Double loanPayment = BudgetMath.loanPayment(loanAmount, periodAmount, interestAmount, true);
							B.insert("Loans", loanPayment, BudgetMath.getPercentSpending(salaryAmount, loanPayment));
						}
						// Rest of the Financial Categories
						
					}
					else {
						
					}
				}
				else {
					if (loanTrue.isSelected()) {
						
					}
					else {
						
					}
				}
			}
			
		});
		
		
		//add to GUI
		gui.add(choiceBar, BorderLayout.NORTH);
		gui.add(insertPanel, BorderLayout.WEST);
		add(gui);
				
				
	}		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				nestedLayoutMain frame = new nestedLayoutMain();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
			
		});
	}	
}

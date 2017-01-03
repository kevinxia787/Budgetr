import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.XChartPanel;

public class DYBMainJFrame extends JFrame {
	
	private JPanel insertPanel, remainderPanel, chartPanel, tablePanel;
	private JTextField tfRent, tfU, tfG, tfT;
	private JButton enter, percentBased, spendingBased, yesLoan, noLoan, monthly, annualy;
	private JLabel chartLabel, rentLabel, utilitiesLabel, groceriesLabel, transportationLabel, savingsLabel, recreationLabel, emergencyLabel;
	
	
	public static void main (String[] args) {
		
		new DYBMainJFrame();
		
	}
		
	private DYBMainJFrame() {
		
		BudgetStorage B = new BudgetStorage();
		
		this.setSize(1000, 1000);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Display Your Budget!");
		
		// Insert Labels here:
		rentLabel = new JLabel("Amount spent on rent:");
		utilitiesLabel = new JLabel("Amount spent on utilities:");
		groceriesLabel = new JLabel("Amount spent on groceries:");
		transportationLabel = new JLabel("Amount spent on transportation:");
		
		// Insert TextFields here:
		tfRent = new JTextField("Insert rent spending here");
		tfU = new JTextField("Insert utilities spending here");
		tfG = new JTextField("Insert groceries spending here");
		tfT = new JTextField("Insert transportation spending here");
		
		// insertPanel portion
		insertPanel = new JPanel();
		GroupLayout insertLayout = new GroupLayout(insertPanel);
		insertPanel.setLayout(insertLayout);
		this.add(insertPanel);
		
		insertLayout.setAutoCreateGaps(true);
		insertLayout.setAutoCreateContainerGaps(true);
		
		// Creating a sequential group for the financial categories
		GroupLayout.SequentialGroup insertGroupH = insertLayout.createSequentialGroup();
		
		insertGroupH.addGroup(insertLayout.createParallelGroup().addComponent(rentLabel).addComponent(utilitiesLabel).addComponent(groceriesLabel).addComponent(transportationLabel));
		insertGroupH.addGroup(insertLayout.createParallelGroup().addComponent(tfRent).addComponent(tfU).addComponent(tfG).addComponent(tfT));
		insertLayout.setHorizontalGroup(insertGroupH);
		
		// Second sequential group for vertical axis:
		GroupLayout.SequentialGroup insertGroupV = insertLayout.createSequentialGroup();
		
		insertGroupV.addGroup(insertLayout.createParallelGroup(Alignment.BASELINE).addComponent(rentLabel).addComponent(tfRent));
		insertGroupV.addGroup(insertLayout.createParallelGroup(Alignment.BASELINE).addComponent(utilitiesLabel).addComponent(tfU));
		insertGroupV.addGroup(insertLayout.createParallelGroup(Alignment.BASELINE).addComponent(groceriesLabel).addComponent(tfG));
		insertGroupV.addGroup(insertLayout.createParallelGroup(Alignment.BASELINE).addComponent(transportationLabel).addComponent(tfT));
		insertLayout.setVerticalGroup(insertGroupV);
		
		// Recommended Spending labels here:
		savingsLabel = new JLabel ("How much you should allocate towards savings:");
		recreationLabel = new JLabel ("How much you should allocate towards recreation:");
		emergencyLabel = new JLabel ("How much you should allocate towards emergency:");
		
	
		
		
		
	/*		
		// Inserting chart into its own panel
		chartPanel = new  XChartPanel<PieChart>(B.getChart());
		this.add(chartPanel, BorderLayout.CENTER);
		
		// Chart Label
		chartLabel = new JLabel("Here is your monthly spending.", SwingConstants.CENTER);
		this.add(chartLabel, BorderLayout.SOUTH);
	*/	
		
		
		// Display the window
		this.pack();
		this.setVisible(true);
		
		
		
		
		
	}
	
}

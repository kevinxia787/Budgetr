import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DYBMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel, buttonPanel1, buttonPanel2, card1, card2, card3, card4, card5, card6, card7, card8;
	private JLabel principal, interest, period,rent, util, groc, transp;
	private JButton nextButton1;
	private CardLayout cardLayout = new CardLayout();
	
	public DYBMain() {
		
		BudgetStorage B = new BudgetStorage();
		
		setTitle("Display Your Budget");
		setSize(300, 200);
		mainPanel = new JPanel();
		buttonPanel1 = new JPanel();
		buttonPanel2 = new JPanel();
		mainPanel.setLayout(cardLayout);
		card1 = new JPanel(new BorderLayout()); card2 = new JPanel(new BorderLayout()); card3 = new JPanel(); card4 = new JPanel();
		card5 = new JPanel(); card6 = new JPanel(); card7 = new JPanel(); card8 = new JPanel();
		
		
		
		// Formating Card 1
		JLabel card1Label = new JLabel("<html>Welcome to Display Your Budget!<br>This wizard will help show your total monthly spending.<br>Begin by pressing Next!</html>");
		card1Label.setHorizontalAlignment(JLabel.CENTER);
		card1Label.setVerticalAlignment(JLabel.CENTER);
		card1.add(card1Label, BorderLayout.CENTER);
		
		
		// Formating Card 2
		JLabel card2Label = new JLabel("<html>Please choose between the following: <br> Percent Based Calculations<br>Current Spending Values</html>");
		JRadioButton percentCheckBox = new JRadioButton("Percent Based");
		JRadioButton currentSpendingCheckBox  = new JRadioButton("Current Spending Based");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(percentCheckBox); group1.add(currentSpendingCheckBox);
		card2Label.setHorizontalAlignment(JLabel.CENTER);
		card2Label.setVerticalAlignment(JLabel.CENTER);
		card2.add(card2Label, BorderLayout.NORTH);
		card2.add(percentCheckBox, BorderLayout.WEST);
		card2.add(currentSpendingCheckBox, BorderLayout.EAST);
		
		// Formating Card 3
		JLabel card3Label = new JLabel("<html>Do you have loans?<br></html>");
		JRadioButton yesCheck = new JRadioButton("Yes");
		JRadioButton noCheck = new JRadioButton("No");
		ButtonGroup group2 = new ButtonGroup();
		group2.add(noCheck); group2.add(yesCheck);
		card3Label.setHorizontalAlignment(JLabel.CENTER);
		card3Label.setVerticalAlignment(JLabel.CENTER);
		card3.add(card3Label, BorderLayout.CENTER);
		card3.add(yesCheck, BorderLayout.WEST);
		card3.add(noCheck, BorderLayout.EAST);
		
		// Formating Card 4
		
		
		mainPanel.add(card1, "1"); mainPanel.add(card2, "2"); mainPanel.add(card3, "3"); mainPanel.add(card4, "4");
		mainPanel.add(card5, "5"); mainPanel.add(card6, "6"); mainPanel.add(card7, "7"); mainPanel.add(card8, "8");
		
		
		// First next button
		nextButton1 = new JButton("Next");
		nextButton1.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(mainPanel);
			}
							
		});
		
		
		buttonPanel1.add(nextButton1);
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel1, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				DYBMain frame = new DYBMain();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
			
		});
	}

	
}

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class nestedLayoutMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel gui, choicePanel, tablePanel, chartPanel;
	private JButton showBudget;
	
	public nestedLayoutMain() {
				
		setTitle("Display Your Budget");
		setSize(600, 600);
		JPanel gui = new JPanel(new BorderLayout());
				
		// Choice bar at top, implemented using flowlayout and two radio button groups
		JPanel choiceBar = new JPanel(new FlowLayout());
				
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
		
		//adding to choiceBar 
		choiceBar.add(percentBased); choiceBar.add(currentBased); 
		choiceBar.add(loanFalse); choiceBar.add(loanTrue);
		
		//add to GUI
		gui.add(choiceBar, BorderLayout.NORTH);
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

// First BC Tech Club Project:
// This is a GUI that calculates
// the user's taxes.

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaxCalculator {
	
	// Creates a GUI that asks the user's income
	// and outputs how much they should pay in taxes.
	@SuppressWarnings("serial")
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel question = new JLabel("How much did you earn in 2020?");
		JTextField income = new JTextField();
		JLabel taxes = new JLabel("");
		JButton submit = new JButton("Submit");
		
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		question.setBounds(10,20, 200, 25);
		income.setBounds(10, 55, 80, 25);
		taxes.setBounds(10, 90, 250, 25);
		submit.setBounds(90, 55,80, 25);
		
		submit.addActionListener( new AbstractAction("add") {
				@Override
				public void actionPerformed(ActionEvent e) {
					String incomeResult = income.getText();
					double finalIncome;
					try {
						finalIncome = Double.parseDouble(incomeResult);
						if(finalIncome < 0) {
							taxes.setText("Error: Please input a positive number");
						} else {
							taxes.setText("You owe $" + taxCalculator(finalIncome));
						}
					} catch(Exception e1) {
						taxes.setText("Error: Please input a number");
					}				
				}}
		);
		
		panel.add(question);
		panel.add(income);
		panel.add(taxes);
		panel.add(submit);
		
		frame.setTitle("Tax Calculator");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}	
	
	public static double taxCalculator(double income) {
		double tax = 0;
		double incomePrep = 0;
		double taxPrep = 0;
		
		if((income <= 9875)) {
			tax = income * 0.1;
		}
		else if((income > 9875)&&(income <= 40125)) {
			incomePrep = 9875;
			taxPrep = taxCalculator(incomePrep);
			tax = taxPrep + (income - incomePrep)* 0.12;
		}
		else if((income > 40125)&&(income <= 85525)) {
			incomePrep = 40125;
			taxPrep = taxCalculator(incomePrep);
			tax = taxPrep + (income - incomePrep)* 0.22;
		}
		else if((income > 85525)&&(income <= 163300)) {
			incomePrep = 85525;
			taxPrep = taxCalculator(incomePrep);
			tax = taxPrep + (income - incomePrep)* 0.24;
		}
		else if((income > 163300)&&(income <= 207350)) {
			incomePrep = 163300;
			taxPrep = taxCalculator(incomePrep); //33271.5
			tax = taxPrep + (income - incomePrep)* 0.32;
		}
		else if((income > 207350)&&(income <= 518400)) {
			incomePrep = 207350;
			taxPrep = taxCalculator(incomePrep);
			tax = taxPrep + (income - incomePrep)* 0.35;
		}
		else if((income > 518400)) {
			incomePrep = 518400;
			taxPrep = taxCalculator(incomePrep);
			tax =  taxPrep + (income - incomePrep)*0.37;
		}
		else {
			tax = 0;
		}
		return tax;
	}
}

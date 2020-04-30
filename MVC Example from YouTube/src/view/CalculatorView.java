package view;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")

public class CalculatorView extends JFrame {
	
	// instance variables 
	private JTextField firstNumber = new JTextField(10); // text field for first number
	private JLabel additonLabel = new JLabel("+"); // label for plus symbol
	
	private JTextField secondNumber = new JTextField(10); // text field for second num
	private JButton calculateButton = new JButton("Calculate"); // button for Calc
	
	private JTextField calcSolution = new JTextField(10); //field to output the solution
	// constructor for the panel
	public CalculatorView(){
		JPanel calcPanel = new JPanel(); // create new jPanel which will get called when constructor is called
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes
		this.setSize(600, 200); // confused about the "this"
		
		calcPanel.add(firstNumber); // add the labels and buttons to the new JPanel
		calcPanel.add(additonLabel); // this will mean these will be part of the obj
		calcPanel.add(secondNumber); // when the obj is constructed
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		this.add(calcPanel); // not sure what 'this' means here
		
	}
	// think these are to get the data from the fields
	public int getFirstNumber() {
		
		return Integer.parseInt(firstNumber.getText());
		
	}
	public int getSecondNumber() {
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	
	public int getCalculationSolution() {
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	// takes a int and turns it into string makes string appear in the output box
	
	public void setCalcSolution(int solution) {
		
		calcSolution.setText(Integer.toString(solution));
	}
	
	public void addCalculationListerner(ActionListener listenForCalcButton) {
		
		 calculateButton.addActionListener(listenForCalcButton);
	}
	
	public void displayErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	

}

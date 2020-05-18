package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CalculatorModel;
import view.CalculatorView;



public class CalculateListerner implements ActionListener {
	
	
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculateListerner(CalculatorView theView, CalculatorModel theModel) 
	
	{
		this.theModel = theModel;
		this.theView = theView;
		
	}
	
//	CalculatorView theView, CalculatorModel theModel

	@Override
	public void actionPerformed(ActionEvent e) {


			
			int firstNumber, secondNumber =0;
			
			try {
				firstNumber = theView.getFirstNumber();//gets first number from the view
				secondNumber = theView.getSecondNumber(); // gets second number from the view
				// calls the model to add the 2 numbers together
				theModel.addTwoNumbers(firstNumber, secondNumber); // calls the Model to add the 2 numbers that were passed in togeher
				theView.setCalcSolution(theModel.getCalculationValue());// gets the solution and outputs it on the screen
				
			}
			catch(NumberFormatException ex) {
				theView.displayErrorMessage("You need to enter a number");
			}
			
			// TODO Auto-generated method stub
			
		}
	}



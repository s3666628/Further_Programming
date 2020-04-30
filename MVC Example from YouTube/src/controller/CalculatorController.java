package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
	// instance variables 
	private CalculatorView theView;
	private CalculatorModel theModel;
	// contstructor which takes objs of Model and View
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView; //assigns what is passed in to the instance variables
		this.theModel = theModel;
		
		this.theView.addCalculationListerner(new CalculateListerner()); // adds action listener to the view
		
		
		
		
		
	}
	// inner class which implements action listener
	class CalculateListerner implements ActionListener{

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

}

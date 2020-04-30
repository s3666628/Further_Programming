package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class MVCCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculatorView theView = new CalculatorView();
		CalculatorModel theModel = new CalculatorModel();
		CalculatorController theController = new CalculatorController(theView, theModel);
		
		theView.setVisible(true); 
		

	}

}

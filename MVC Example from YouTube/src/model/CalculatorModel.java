package model;

public class CalculatorModel {
	
	// instance var for calc value
	private int calculationValue;
	
	// method to add 2 ints together - assigns to the instance variable
	public void addTwoNumbers(int firstNumber, int secondNumber) {
		
		calculationValue = firstNumber + secondNumber;
	}
	//getter for the instance variable
	public int getCalculationValue() {
		
		return calculationValue;
	}
	

}

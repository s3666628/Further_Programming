package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddPlayerPanel;
import view.MainGameFrame;
import view.RemovePlayerPanel;
import view.CardGameToolBar;
import model.GameEngine;
import model.GameEngineImpl;


public class CardGameController {
	// instance variables 
	private MainGameFrame theView;
	private GameEngineImpl theModel;
	private CardGameToolBar theToolBar;
	private AddPlayerPanel addPlayerSubView;
	private RemovePlayerPanel remPlayerSubView;
	private int addPlayerNum =1;
	private int remPlayerNum =2;
	// contstructor which takes objs of Model and View
	public CardGameController(MainGameFrame theView, GameEngineImpl theModel) {
		this.theView = theView; //assigns what is passed in to the instance variables
		this.theModel = theModel;
		this.theToolBar = theView.getToolBar();
		this.addPlayerSubView = theView.getAddPlayerSubView();
		this.remPlayerSubView = theView.getRemovePlayerPanel();
		theToolBar.addPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, addPlayerNum)); 
		theToolBar.remPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, remPlayerNum)); 
		// adds action listener to the view
//		theToolBar.addRemPlayerListerner(new RemovePlayerButtonActionListener(theView, theModel)); 
		addPlayerSubView.addSubmitListener(new SubmitNewPlayerButtonActionListener(theView, theModel));
		addPlayerSubView.cancelButtonListener(new CloseButtonActionListener (theView, 2));
		
		
		
		
	}
	// inner class which implements action listener
//	class CalculateListerner implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			int firstNumber, secondNumber =0;
//			
//			try {
//				firstNumber = theView.getFirstNumber();//gets first number from the view
//				secondNumber = theView.getSecondNumber(); // gets second number from the view
//				// calls the model to add the 2 numbers together
//				theModel.addTwoNumbers(firstNumber, secondNumber); // calls the Model to add the 2 numbers that were passed in togeher
//				theView.setCalcSolution(theModel.getCalculationValue());// gets the solution and outputs it on the screen
//				
//			}
//			catch(NumberFormatException ex) {
//				theView.displayErrorMessage("You need to enter a number");
//			}
//			
//			// TODO Auto-generated method stub
//			
//		}
		
		 
	}
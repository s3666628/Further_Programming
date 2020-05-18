package client;

import javax.swing.SwingUtilities;

import controller.CardGameController;
import model.GameEngineImpl;
import model.PlayerImpl;
import model.card.Suit;
import view.CardGameFrame;
import view.ConsoleLoggerCallback;

public class GuiCardGame {

	public static void main(String[] args) {

		// runs everything to do with the UI on separate thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				
				GameEngineImpl theModel = new GameEngineImpl();
				CardGameFrame theView = new CardGameFrame();
				CardGameController theController = new CardGameController(theView, theModel);
				
				
				// add ConsoleLoggerCallback
				theModel.registerCallback(new ConsoleLoggerCallback(theModel));
				

				theModel.addPlayer(new PlayerImpl("P1", "Player One", 1000));
				theModel.addPlayer(new PlayerImpl("P2", "Player Two", 1000));
				theModel.addPlayer(new PlayerImpl("P3", "Player Three", 3000));
				theModel.addPlayer(new PlayerImpl("X4", "Player Four", 4000));
				
				// removes player
				theModel.removePlayer("X4");
				
				theModel.placeBet("P1", 100);
				
				theModel.placeBet("P2", 100, Suit.CLUBS);
				
//				engine.dealPlayer("P2", TEST_DELAY);
//				engine.dealPlayer("P2", TEST_DELAY);
//				engine.dealPlayer("P1", TEST_DELAY);
//				
//				engine.dealHouse(TEST_DELAY);
				
				theModel.resetAllBetsAndHands();
			}
			
			

		});
		
		
	}

}

package client;

import javax.swing.SwingUtilities;

import model.GameEngine;
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

				
				GameEngine engine = new GameEngineImpl();
				new CardGameFrame();
				
				
				// add ConsoleLoggerCallback
				engine.registerCallback(new ConsoleLoggerCallback(engine));
				

				engine.addPlayer(new PlayerImpl("P1", "Player One", 1000));
				engine.addPlayer(new PlayerImpl("P2", "Player Two", 1000));
				engine.addPlayer(new PlayerImpl("P3", "Player Three", 3000));
				engine.addPlayer(new PlayerImpl("X4", "Player Four", 4000));
				
				// removes player
				engine.removePlayer("X4");
				
				engine.placeBet("P1", 100);
				
				engine.placeBet("P2", 100, Suit.CLUBS);
				
//				engine.dealPlayer("P2", TEST_DELAY);
//				engine.dealPlayer("P2", TEST_DELAY);
//				engine.dealPlayer("P1", TEST_DELAY);
//				
//				engine.dealHouse(TEST_DELAY);
				
				engine.resetAllBetsAndHands();
			}
			
			

		});
		
		
	}

}

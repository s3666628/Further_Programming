package client;

import javax.swing.SwingUtilities;

import controller.CardGameController;
import model.GameEngineImpl;
import view.MainGameFrame;
import view.ConsoleLoggerCallback;
import view.GuiCallback;

public class GuiCardGame {

	public static void main(String[] args) {

		// runs everything to do with the UI on separate thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				GameEngineImpl theModel = new GameEngineImpl();


				// add ConsoleLoggerCallback
				theModel.registerCallback(new ConsoleLoggerCallback(theModel));
				// add Gui Callback
				// removes player


				MainGameFrame theView = new MainGameFrame(theModel);
				CardGameController theController = new CardGameController(theView, theModel);
				theModel.registerCallback(new GuiCallback(theModel, theView));
			}

		});

	}

}

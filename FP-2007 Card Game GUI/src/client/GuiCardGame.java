package client;

import javax.swing.SwingUtilities;

import view.CardGameFrame;

public class GuiCardGame {

	public static void main(String[] args) {

		// runs everything to do with the UI on separate thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				new CardGameFrame();
			}

		});
		
		
	}

}

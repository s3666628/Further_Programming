package client;

import javax.swing.SwingUtilities;

import model.CirclesModel;
import view.CirclesFrame;

public class CircleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CirclesModel model = new CirclesModel(21);
		// runs everything to do with the UI on separate thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				new CirclesFrame(model);
			}

		});

	}

}

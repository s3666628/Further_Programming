package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CardPack;

@SuppressWarnings("serial")
public class CardGameHandPanel extends JPanel {

	JLabel displayText;

	public CardGameHandPanel(String displaytext) {

		setLayout(new GridLayout(0, 6, 5, 5)); // might need to change this
		setBackground(Color.GREEN);

		this.displayText = new JLabel(displaytext);
		add(displayText);

		// get number of cards in deck
		int numberCards = CardPack.values().length;
		int counter = 0;
		while (counter < numberCards) {
			// gets a random card image at the moment
			ImageIcon imageIcon = CardPack.getRandom().getImageIcon();
			; // load the image to a imageIcon
//	
//			use helper method to resize the icon
			imageIcon = CardGameHelperMethods.resizeImageIcon(imageIcon, 70, 110);

			JLabel labelOne = new JLabel(imageIcon); // add image icon to the label
			add(labelOne); // add the label to the panel
			counter += 1;

		}

	}

}

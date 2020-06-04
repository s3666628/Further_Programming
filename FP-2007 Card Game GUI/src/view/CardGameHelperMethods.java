package view;

import java.awt.Image;
import java.util.Collection;
import javax.swing.ImageIcon;
import model.Player;
import model.card.Suit;

public class CardGameHelperMethods {

	public static ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
		// takes an imageIcon and re-scales it - returns an image icon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		ImageIcon newImageIcon = new ImageIcon(newimg);
		return newImageIcon;

	}
	
	public static String[] createPlayerIdList(Collection<Player> allPlayers) {
		String[] playerNames = new String[allPlayers.size()];
		int counter = 0;	
		for (Player player : allPlayers) {
			playerNames[counter] = player.getId();
			counter += 1;
			System.out.println(player.getId());
		}

		return playerNames;

	}
	
	public static String[] getSuites () {
		String[] allSuites = new String[5];
		int counter = 1;
		allSuites[0] = "None (Score Bet)";
		for (Suit suit : Suit.values()) {
			allSuites[counter] = suit.toString();
			counter += 1;
			System.out.println(suit.toString());
			}
		return allSuites;
				
	}

}

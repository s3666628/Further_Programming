package view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class CardGameHelperMethods {

	public static ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
		// takes an imageIcon and re-scales it - returns an image icon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		ImageIcon newImageIcon = new ImageIcon(newimg);
		return newImageIcon;

	}

}

package view;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CirclesPanel extends JPanel {

	private void generateGrid(int numberImages) {

		int counter = 0;
		while (numberImages > counter) {

//			System.out.print("checking counter" + counter);
			add(new JLabel(new ImageIcon(CircleImages.YELLOW.getImagePath())));
			add(new JLabel(new ImageIcon(CircleImages.BLUE.getImagePath())));
			add(new JLabel(new ImageIcon(CircleImages.GREEN.getImagePath())));
			add(new JLabel(new ImageIcon(CircleImages.RED.getImagePath())));
			add(new JLabel(new ImageIcon(CircleImages.ORANGE.getImagePath())));
			counter += 1;

		}
	}

	public CirclesPanel() {

		setLayout(new GridLayout(0, 6, 5, 5));
		this.generateGrid(3);

	}

}

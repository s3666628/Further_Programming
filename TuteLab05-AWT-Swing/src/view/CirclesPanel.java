package view;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.PanelMouseListener;
import control.ToolBarButtonListener;

@SuppressWarnings("serial")
public class CirclesPanel extends JPanel {

	JLabel blueLabel;
	JLabel greenLabel;
	JLabel redLabel;
	JLabel orangeLabel;
	JLabel yellowLabel;

	private void generateGrid(int numberImages) {

		int counter = 0;
		while (numberImages > counter) {

			System.out.println("checking counter" + counter);

//			add(new JLabel(CircleImages.BLUE.getImageIcon()));
//			add(new JLabel(CircleImages.GREEN.getImageIcon()));
//			add(new JLabel(CircleImages.RED.getImageIcon()));
//			add(new JLabel(CircleImages.ORANGE.getImageIcon()));
//			add(new JLabel(CircleImages.YELLOW.getImageIcon()));
			// create new objects
			JLabel blueLabel = new JLabel(CircleImages.BLUE.getImageIcon());
			JLabel greenLabel = new JLabel(CircleImages.GREEN.getImageIcon());
			JLabel redLabel = new JLabel(CircleImages.RED.getImageIcon());
			JLabel orangeLabel = new JLabel(CircleImages.ORANGE.getImageIcon());
			JLabel yellowLabel = new JLabel(CircleImages.YELLOW.getImageIcon());
			// adds new objects to the panel as they are created
			add(blueLabel);
			add(greenLabel);
			add(redLabel);
			add(orangeLabel);
			add(yellowLabel);

//			
//			add(new JLabel(new ImageIcon(CircleImages.BLUE.getImagePath())));
//			add(new JLabel(new ImageIcon(CircleImages.GREEN.getImagePath())));
//			add(new JLabel(new ImageIcon(CircleImages.RED.getImagePath())));
//			add(new JLabel(new ImageIcon(CircleImages.ORANGE.getImagePath())));
			counter += 1;

		}



//		blue.addActionListener(new ToolBarButtonListener());
//		green.addActionListener(new ToolBarButtonListener());
//		orange.addActionListener(new ToolBarButtonListener());
//		red.addActionListener(new ToolBarButtonListener());
//		yellow.addActionListener(new ToolBarButtonListener());

	}

	public CirclesPanel() {

		setLayout(new GridLayout(0, 6, 5, 5));
		this.generateGrid(4);

	}

}

package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CirclesPanel extends JPanel {

	JLabel blueLabel;
	JLabel greenLabel;
	JLabel redLabel;
	JLabel orangeLabel;
	JLabel yellowLabel;

	// this creates the panel with all of the images

	final static private int TOTAL_CIRCLES = 21; // num of icons we want in the panel

	public CirclesPanel(CirclesFrame circlesFrame) {
		
		setLayout(new GridLayout(0, 6, 5, 5));
		final int SIZE = CircleImages.values().length;

			 // len of Enums array
			// loop to create an label of each image inside the panel
			int counter = 0;
			while (TOTAL_CIRCLES > counter) {

				System.out.println("checking counter" + counter);
				// use this for place labels in random pattern
				int randomNum = (int) (Math.random() * SIZE);

//				add(new JLabel(CircleImages.values()[randomNum].getImageIcon()));
				// create a new label for each iteration of the loop
				JLabel labelOne = new JLabel(CircleImages.values()[randomNum].getImageIcon());
				add(labelOne); // add the label to the panel
				labelOne.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

//						statusbar.status1.setText(String.format("Selected %s", images.toString()));
						System.out.println("mouse event being called on mouse enter");
						labelOne.setIcon(circlesFrame.getImages().getImageIcon());

					}
					
				});
				counter += 1; //update the counter which is outside of the while loop

			}

		}

	// call the method which generates the grid

}



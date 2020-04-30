package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import controller.ToolBarButtonListener;

@SuppressWarnings(value = { "serial" })
public class CirclesToolBar extends JToolBar {

	public CirclesToolBar(CirclesFrame circlesFrame) {
		// create some new icons so we can use these with the buttons

		ButtonGroup bubbleButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		for (CircleImages images : CircleImages.values()) { // gets an array of enums

			AbstractButton button = new JToggleButton(images.getImageIcon());
			add(button); // add button to the frame
			button.addActionListener(new ToolBarButtonListener()); // add listener

			bubbleButtonsGroup.add(button); // add button to group
			button.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
			button.addActionListener(new ToolBarButtonListener());
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

//					statusbar.status1.setText(String.format("Selected %s", images.toString()));
//					circlesFrame.updateLabel(images);
					circlesFrame.updateColor(images);
					

				}

			});

		}
		bubbleButtonsGroup.getElements().nextElement().doClick();
	}

}

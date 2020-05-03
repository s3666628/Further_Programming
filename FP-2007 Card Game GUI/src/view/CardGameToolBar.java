package view;

import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import model.ComponentNames;

@SuppressWarnings("serial")
public class CardGameToolBar extends JToolBar {

	CardGameToolBar(int vertical) {

		ButtonGroup toolButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		for (ComponentNames names : ComponentNames.values()) { // gets an array of enums

			AbstractButton button = new JToggleButton(names.getImageIcon());
			add(button); // add button to the frame
			toolButtonsGroup.add(button); // add button to group
			button.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it

		}
		;
	}
}

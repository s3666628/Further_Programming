package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import controller.AddPlayerButtonActionListener;
import model.ComponentNames;

@SuppressWarnings("serial")



public class CardGameToolBar extends JToolBar {
	
	AbstractButton testButton = new JToggleButton("test Button");

	CardGameToolBar(int vertical, CardGameFrame cardGameFrame) {
		
		

		ButtonGroup toolButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		for (ComponentNames names : ComponentNames.values()) { // gets an array of enums
			
			// resize buttons
			AbstractButton button = new JToggleButton(CardGameHelperMethods.resizeImageIcon(names.getImageIcon(), 130, 35));
			add(button); // add button to the frame
			button.addActionListener(new AddPlayerButtonActionListener());
			toolButtonsGroup.add(button); // add button to group
			button.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it

		};
		
		toolButtonsGroup.add(testButton);
	}
	
	public void addPlayerButtonListener(ActionListener listenForCalcButton) {
		
		 
		testButton.addActionListener(listenForCalcButton);
	}
	
}

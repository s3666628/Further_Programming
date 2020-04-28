package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class CardGameToolBar extends JToolBar {
	
	CardGameToolBar(){
		
		ButtonGroup toolButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		AbstractButton button = new JToggleButton("Add Player");
		add(button);
		
	};

}

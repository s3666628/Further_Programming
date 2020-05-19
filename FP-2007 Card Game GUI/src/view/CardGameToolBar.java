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
	
	private AbstractButton addPlayerButton;
	private AbstractButton removePlayerButton;
	
	CardGameToolBar(int vertical, MainGameFrame cardGameFrame) {
		
		

		ButtonGroup toolButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar
		
		this.addPlayerButton = new JToggleButton(CardGameHelperMethods.resizeImageIcon(ComponentNames.ADDPLAYER.getImageIcon(), 130, 35));
		add(addPlayerButton);
		toolButtonsGroup.add(addPlayerButton);
		addPlayerButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
		
		
		this.removePlayerButton = new JToggleButton(CardGameHelperMethods.resizeImageIcon(ComponentNames.REMOVE_PLAYER.getImageIcon(), 130, 35));
		add(removePlayerButton);
		toolButtonsGroup.add(removePlayerButton);
		removePlayerButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
		
//		for (ComponentNames names : ComponentNames.values()) { // gets an array of enums
//			
//			// resize buttons
//			AbstractButton button = new JToggleButton(CardGameHelperMethods.resizeImageIcon(names.getImageIcon(), 130, 35));
//			add(button); // add button to the frame
//			button.addActionListener(new AddPlayerButtonActionListener());
//			toolButtonsGroup.add(button); // add button to group
//			button.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
//
//		};
		
		
	}
	
	// methods for attaching action listeners to the various buttons
	
	public void addPlayerListerner(ActionListener AddPlayerButtonActionListener) {
		
		 
		addPlayerButton.addActionListener(AddPlayerButtonActionListener);
	}
	
	public void removePlayerListerner(ActionListener RemovePlayerButtonActionListener) {
		
		 
		removePlayerButton.addActionListener(RemovePlayerButtonActionListener);
	}
	
}

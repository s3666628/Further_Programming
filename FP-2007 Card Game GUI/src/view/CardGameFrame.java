package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CardGameFrame extends JFrame {

	CardGameFrame() {

		super("Card Game");// add title

		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons

		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built
		
		
		// add new menu bar to the main frame
		this.add(new CardGameMenuBar(this), BorderLayout.NORTH);
		// add main game panel to the - might need one of these for each player added or something like that 
		this.add(new CardGamePanel(), BorderLayout.CENTER);
		// add tool bar to the main frame
		this.add(new CardGameToolBar(), BorderLayout.EAST);
		
		
		
		
		
		setSize(800, 1200);
//		pack(); 
		this.setVisible(true); // by default frame is not visible
		

	}
}

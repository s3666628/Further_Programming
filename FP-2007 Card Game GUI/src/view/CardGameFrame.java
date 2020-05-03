package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class CardGameFrame extends JFrame {

	public CardGameFrame() {

		super("Card Game");// add title

		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons

		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built
		
		
		// add new menu bar to the main frame
		this.add(new CardGameMenuBar(this), BorderLayout.PAGE_START);
		// add main game panel to the - might need one of these for each player added or something like that 
		this.add(new CardGamePanel(), BorderLayout.CENTER);
		// add tool bar to the main frame
		CardGameToolBar toolbar = new CardGameToolBar(JToolBar.VERTICAL);
		MatteBorder matteBorder = new MatteBorder(1,1,1,1, Color.BLUE);
		toolbar.setBorder(matteBorder);
		toolbar.setOrientation(JToolBar.VERTICAL);
		this.add(toolbar, BorderLayout.WEST);
		// add statusbar to the frame
		CardGameStatus statusBar = new CardGameStatus();		
		this.add(statusBar, BorderLayout.SOUTH);
		this.add(new TabbedPaneDemo(), BorderLayout.CENTER);
		
		
		
		
		
		setSize(800, 1200);
//		pack(); 
		setVisible(true); // by default frame is not visible
		

	}
}

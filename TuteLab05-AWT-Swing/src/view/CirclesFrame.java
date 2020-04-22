package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CirclesFrame extends JFrame {

	public CirclesFrame() {
		
		super("AWT/Swing Tutelab Exercises");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons
		
		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built
		
		// add children components
		
		this.add(new CirclesToolBar(), BorderLayout.NORTH);
		this.add(new CirclesPanel(), BorderLayout.CENTER);
		this.add(new CirclesStatus(), BorderLayout.SOUTH);
		
		setSize(400, 600);
		this.setVisible(true); // by default frame is not visible
	}
	
}

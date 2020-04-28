package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CirclesFrame extends JFrame {
	
	private CirclesStatus statusBar;
	private CircleImages images;

	public CirclesFrame() {
		
		super("AWT/Swing Tutelab Exercises");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons
		
		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built
		
		// add children components
		
		statusBar = new CirclesStatus();
		
		
		this.add(new CirclesToolBar(this), BorderLayout.NORTH);
		this.add(new CirclesPanel(this), BorderLayout.CENTER);
//		this.add(new CirclesStatus(), BorderLayout.SOUTH);
		this.add(statusBar, BorderLayout.SOUTH);
		
		setSize(400, 600);
		pack(); 
		this.setVisible(true); // by default frame is not visible
		
	}

	public void updateColor(CircleImages images) {
		// TODO Auto-generated method stub
		
		this.images = images;
		statusBar.updateLabel(this.images);
	}

	public CirclesStatus getStatusBar() {
		return statusBar;
	}

	public CircleImages getImages() {
		return images;
	}


	

	
}

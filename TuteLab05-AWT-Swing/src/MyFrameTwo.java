import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MyFrameTwo extends JFrame {
	
	public MyFrameTwo()
	{
	
	super("AWT/Swing Tutelab Exercises");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	setLayout(new BorderLayout());
	this.add(new JButton("North"), BorderLayout.NORTH);
//	this.add(new JButton("East"), BorderLayout.EAST);
	this.add(new JButton("South"), BorderLayout.SOUTH);
//	this.add(new JButton("West "), BorderLayout.WEST);
	
	setSize(600, 800);
	setVisible(true);
	
	}

}

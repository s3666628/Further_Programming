package view;


import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import control.ToolBarButtonListener;

@SuppressWarnings(value = { "serial" })
public class CirclesToolBar extends JToolBar {
	
	private ImageIcon bluePng;
	private ImageIcon greenPng;
	private ImageIcon orangePng;
	private ImageIcon redPng;
	private ImageIcon yellowPng;
	
	
	public CirclesToolBar()
	{
		// create some new icons so we can use these with the buttons
		// this works but tring something else 
		
		ImageIcon bluePng = new ImageIcon(CircleImages.BLUE.getImagePath());
		ImageIcon greenPng = new ImageIcon(CircleImages.GREEN.getImagePath());
		ImageIcon orangePng = new ImageIcon(CircleImages.ORANGE.getImagePath());
		ImageIcon redPng = new ImageIcon(CircleImages.RED.getImagePath());
		ImageIcon yellowPng = new ImageIcon(CircleImages.YELLOW.getImagePath());
		
		// create a group so we can make buttons behave like radio button
		// Ross Task 01
		ButtonGroup bubbleButtonsGroup = new ButtonGroup();
		
		AbstractButton blue = new JToggleButton(bluePng);
		AbstractButton green = new JToggleButton(greenPng);
		AbstractButton orange = new JToggleButton(orangePng);
		AbstractButton red = new JToggleButton(redPng);
		AbstractButton yellow = new JToggleButton(yellowPng);
		
		
//		// create new buttons
//		JToggleButton blueButton = new JToggleButton(bluePng);
//		JToggleButton greenButton = new JToggleButton(greenPng);
//		JToggleButton oraneButton = new JToggleButton(orangePng);
//		JToggleButton redButton = new JToggleButton(redPng);
//		JToggleButton yellowButton = new JToggleButton(yellowPng);
		
		//add new buttons so that they are part of the frame
		
		add(blue);
		add(green);
		add(orange);
		add(red);
		add(yellow);
		
//		add(new JToggleButton(green));
//		add(new JToggleButton(orangePng));
//		add(new JToggleButton(redPng));
//		add(new JToggleButton(yellowPng));
		
		//add event listeners
		blue.addActionListener(new ToolBarButtonListener());
		green.addActionListener(new ToolBarButtonListener());
		orange.addActionListener(new ToolBarButtonListener());
		red.addActionListener(new ToolBarButtonListener());
		yellow.addActionListener(new ToolBarButtonListener());
		
		
		

		
		// add buttons to the group
		bubbleButtonsGroup.add(blue);
		bubbleButtonsGroup.add(green);
		bubbleButtonsGroup.add(orange);
		bubbleButtonsGroup.add(red);
		bubbleButtonsGroup.add(yellow);
		


		
		
		


		
		
	}

}

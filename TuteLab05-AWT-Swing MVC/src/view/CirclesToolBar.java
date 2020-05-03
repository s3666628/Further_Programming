package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import controller.ToolBarButtonListener;
import model.CircleColor;
import model.CirclesModel;

@SuppressWarnings(value = { "serial" })
public class CirclesToolBar extends JToolBar implements PropertyChangeListener{

	public CirclesToolBar(CirclesModel model) {
		// create some new icons so we can use these with the buttons

		ButtonGroup bubbleButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		for (CircleColor images : CircleColor.values()) { // gets an array of enums

			AbstractButton button = new JToggleButton(images.getImageIcon());
			add(button); // add button to the frame
			
			if (model.getSelectedColor() == images) {
				button.setSelected(true);
			}
			
			
			
//			button.addActionListener(new ToolBarButtonListener()); // add listener

			bubbleButtonsGroup.add(button); // add button to group
			button.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
//			button.addActionListener(new ToolBarButtonListener());
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

//					statusbar.status1.setText(String.format("Selected %s", images.toString()));
//					circlesFrame.updateLabel(images);
//					model.updateColor(images);
					model.setSelectedColor(images);
					

				}

			});

		}
//		bubbleButtonsGroup.getElements().nextElement().doClick();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}

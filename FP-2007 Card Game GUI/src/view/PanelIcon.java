package view;

import javax.swing.ImageIcon;

public class PanelIcon extends ImageIcon {
	
	private ImageIcon icon;

	public PanelIcon(String iconPath) {
		super();
		this.icon =	new ImageIcon("circle_blue.png");
		System.out.println("creating new icon");
	}
	

//	ImageIcon icon = new ImageIcon("circle_blue.png");
	
	

}

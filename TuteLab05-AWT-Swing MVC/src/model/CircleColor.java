package model;

import javax.swing.ImageIcon;

public enum CircleColor {
	// enum fields
	BLUE {
		@Override
		public String getImagePath() {
			String message = "images/circle_blue.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon blue = new ImageIcon(CircleColor.BLUE.getImagePath());
			return blue;
		}
		public String toString() {
			return "Blue";
			
		}
		
	},
	GREEN {
		@Override
		public String getImagePath() {
			String message = "images/circle_green.png";
			return message;
		}

		public ImageIcon getImageIcon() {

			ImageIcon green = new ImageIcon(CircleColor.GREEN.getImagePath());
//			String message = "images/circle_green.png";
			return green;
		}
		public String toString() {
			return "Green";
			
		}
	},
	ORANGE {
		@Override
		public String getImagePath() {
			String message = "images/circle_orange.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon orange = new ImageIcon(CircleColor.ORANGE.getImagePath());
			return orange;
		}
		public String toString() {
			return "Orange";
			}
		
	},
	RED {
		@Override
		public String getImagePath() {
			String message = "images/circle_red.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			// TODO Auto-generated method stub
			ImageIcon red = new ImageIcon(CircleColor.RED.getImagePath());
			return red;
		}
		public String toString() {
			return "Red";
			}
	},

	YELLOW {
		@Override
		public String getImagePath() {
			String message = "images/circle_yellow.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(CircleColor.YELLOW.getImagePath());
			return yellow;
		}
		public String toString() {
			return "Yellow";
			}
	};

	public abstract String getImagePath();

	public abstract ImageIcon getImageIcon();
	
	public abstract String toString();
	
	public static CircleColor getRandom() {
		return values()[(int)(Math.random()* values().length)];
		
	}
	
	
}
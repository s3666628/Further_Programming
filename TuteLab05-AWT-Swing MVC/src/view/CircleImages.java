package view;

import javax.swing.ImageIcon;

public enum CircleImages {
	// enum fields
	BLUE {
		@Override
		public String getImagePath() {
			String message = "images/circle_blue.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon blue = new ImageIcon(CircleImages.BLUE.getImagePath());
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

			ImageIcon green = new ImageIcon(CircleImages.GREEN.getImagePath());
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
			ImageIcon orange = new ImageIcon(CircleImages.ORANGE.getImagePath());
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
			ImageIcon red = new ImageIcon(CircleImages.RED.getImagePath());
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
			ImageIcon yellow = new ImageIcon(CircleImages.YELLOW.getImagePath());
			return yellow;
		}
		public String toString() {
			return "Yellow";
			}
	};

	public abstract String getImagePath();

	public abstract ImageIcon getImageIcon();
	
	public abstract String toString();
}
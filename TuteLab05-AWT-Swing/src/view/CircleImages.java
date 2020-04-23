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
	},

	YELLOW {
		@Override
		public String getImagePath() {
			String message = "images/circle_yellow.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(CircleImages.RED.getImagePath());
			return yellow;
		}
	};

	public abstract String getImagePath();

	public abstract ImageIcon getImageIcon();
}
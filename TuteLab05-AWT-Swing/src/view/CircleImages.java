package view;

public enum CircleImages {
	// enum fields
	BLUE {
		@Override
		public String getImagePath() {
			String message = "images/circle_blue.png";
			return message;
		}
	},
	GREEN {
		@Override
		public String getImagePath() {
			String message = "images/circle_green.png";
			return message;
		}
	},
	ORANGE {
		@Override
		public String getImagePath() {
			String message = "images/circle_orange.png";
			return message;
		}
	},
	RED {
		@Override
		public String getImagePath() {
			String message = "images/circle_red.png";
			return message;
		}
	},

	YELLOW {
		@Override
		public String getImagePath() {
			String message = "images/circle_yellow.png";
			return message;
		}
	};

	public abstract String getImagePath();
}
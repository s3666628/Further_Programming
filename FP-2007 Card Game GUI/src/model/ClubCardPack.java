package model;

import javax.swing.ImageIcon;

public enum ClubCardPack {
	// enum fields
	ACE_CLUBS {
		@Override
		public String getImagePath() {
			String message = "images/AC.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon aceClubs = new ImageIcon(ClubCardPack.ACE_CLUBS.getImagePath());
			return aceClubs;
		}
		public String toString() {
			return "Ace of Clubs";
			
		}
		
	},
	TWO_CLUBS {
		@Override
		public String getImagePath() {
			String message = "images/2C.png";
			return message;
		}

		public ImageIcon getImageIcon() {

			ImageIcon green = new ImageIcon(ClubCardPack.TWO_CLUBS.getImagePath());
//			String message = "images/circle_green.png";
			return green;
		}
		public String toString() {
			return "Two Of Clubs";
			
		}
	},
	THREE_CLUBS {
		@Override
		public String getImagePath() {
			String message = "images/3C.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon orange = new ImageIcon(ClubCardPack.THREE_CLUBS.getImagePath());
			return orange;
		}
		public String toString() {
			return "Three of Clubs";
			}
		
	},
	FOUR_CLUBS {
		@Override
		public String getImagePath() {
			String message = "images/4C.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			// TODO Auto-generated method stub
			ImageIcon red = new ImageIcon(ClubCardPack.FOUR_CLUBS.getImagePath());
			return red;
		}
		public String toString() {
			return "Four of Clubs";
			}
	},

	FIVE_CLUBS {
		@Override
		public String getImagePath() {
			String message = "images/5C.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(ClubCardPack.FIVE_CLUBS.getImagePath());
			return yellow;
		}
		public String toString() {
			return "Yellow";
			}
	};

	public abstract String getImagePath();



	public abstract ImageIcon getImageIcon();
	
	public abstract String toString();
	
	public static ClubCardPack getRandom() {
		return values()[(int)(Math.random()* values().length)];
		
	}
	
	
}
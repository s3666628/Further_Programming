package model;

import javax.swing.ImageIcon;

public enum PlayerIcons {
	// enum fields
	PLAYER1 {
		@Override
		public String getImagePath() {
			String message = "player_1_icon.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon aceClubs = new ImageIcon(PlayerIcons.PLAYER1.getImagePath());
			return aceClubs;
		}
		public String toString() {
			return "Player One";
			
		}
		
	},
	PLAYER2 {
		@Override
		public String getImagePath() {
			String message = "player_2_icon.png";
			return message;
		}

		public ImageIcon getImageIcon() {

			ImageIcon green = new ImageIcon(PlayerIcons.PLAYER2.getImagePath());
//			String message = "images/circle_green.png";
			return green;
		}
		public String toString() {
			return "Player Two";
			
		}
	},
	PLAYER3 {
		@Override
		public String getImagePath() {
			String message = "player_3_icon.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon orange = new ImageIcon(PlayerIcons.PLAYER3.getImagePath());
			return orange;
		}
		public String toString() {
			return "Player Three";
			}
		
	},
	PLAYER4 {
		@Override
		public String getImagePath() {
			String message = "player_3_icon.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			// TODO Auto-generated method stub
			ImageIcon red = new ImageIcon(PlayerIcons.PLAYER4.getImagePath());
			return red;
		}
		public String toString() {
			return "Player Four";
			}
	
	};

	public abstract String getImagePath();

	public abstract ImageIcon getImageIcon();
	
	public abstract String toString();
	
	public static PlayerIcons getRandom() {
		return values()[(int)(Math.random()* values().length)];
		
	}
	
	
}
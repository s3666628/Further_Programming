package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public enum ComponentNames {
	// enum fields
	ADDPLAYER {
		@Override
		public String getComponentName() {
			String message = "images/button_add_player.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon blue = new ImageIcon(ComponentNames.ADDPLAYER.getComponentName());
			return blue;
		}
		public String toString() {
			return "Add Player";
			
		}
		
	},
	REMOVE_PLAYER {
		@Override
		public String getComponentName() {
			String message = "images/button_remove_player.png";
			return message;
		}

		public ImageIcon getImageIcon() {

			ImageIcon green = new ImageIcon(ComponentNames.REMOVE_PLAYER.getComponentName());
//			String message = "images/circle_green.png";
			return green;
		}
		public String toString() {
			return "Remove Player";
			
		}
	},
	DISPLAY_ALL_PLAYER {
		@Override
		public String getComponentName() {
			String message = "images/button_display_all.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon orange = new ImageIcon(ComponentNames.DISPLAY_ALL_PLAYER.getComponentName());
			return orange;
		}
		public String toString() {
			return "Display All Players";
			}
		
	},
	PLACE_BET {
		@Override
		public String getComponentName() {
			String message = "images/button_place_bet.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			// TODO Auto-generated method stub
			ImageIcon red = new ImageIcon(ComponentNames.PLACE_BET.getComponentName());
			return red;
		}
		public String toString() {
			return "Place Bet";
			}
	},

	MANUAL_DEAL {
		@Override
		public String getComponentName() {
			String message = "images/button_manual_deal.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(ComponentNames.MANUAL_DEAL.getComponentName());
			return yellow;
		}
		public String toString() {
			return "Manual Deal";
			}
	},
	AUTO_DEAL {
		@Override
		public String getComponentName() {
			String message = "images/button_auto_deal.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(ComponentNames.AUTO_DEAL.getComponentName());
			return yellow;
		}
		public String toString() {
			return "Auto Deal";
			}
	},
	ABOUT_THIS_GAME {
		@Override
		public String getComponentName() {
			String message = "images/button_about.png";
			return message;
		}

		@Override
		public ImageIcon getImageIcon() {
			ImageIcon yellow = new ImageIcon(ComponentNames.ABOUT_THIS_GAME.getComponentName());
			return yellow;
		}
		public String toString() {
			return "About This Game";
			}

	};

	public abstract String getComponentName();

	public abstract ImageIcon getImageIcon();
	
	public abstract String toString();
	
	public static ComponentNames getRandom() {
		return values()[(int)(Math.random()* values().length)];
		

		
	}
	
	
}
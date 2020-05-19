package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import model.ComponentNames;

@SuppressWarnings("serial")
public class CardGameMenuBar extends JMenuBar {

	JMenuBar menuBar;
	JMenu playerJmenu, dealerJmenu, aboutJMenu, dealerSubMenu;
	JMenuItem playerMenuItem1, playerMenuItem2, playerMenuItem3;
	JMenuItem dealMenuItem1, dealMenuItem2, dealMenuItem3, aboutlMenuItem;
	JMenuItem aboutMenuItem;
	AboutGameDiaglogBox aboutDialog;

// code for this section based on tutorial at this locations	
//	https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

	CardGameMenuBar(MainGameFrame cardGameFrame) {

		// PLAYERS MENU
		// 1 - create new menu bar
		menuBar = new JMenuBar();
		// 2 create the menus to go on the menu bar
		playerJmenu = new JMenu("Player");
		dealerJmenu = new JMenu("Deal");
		aboutJMenu = new JMenu("About");
//		// 2 a - add one sub menu
		dealerSubMenu = new JMenu("Deal Cards to Player");

		// 3 create menu items
		playerMenuItem1 = new JMenuItem(ComponentNames.ADDPLAYER.toString());
		playerMenuItem1.setMnemonic(KeyEvent.VK_P);
		playerMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));

		playerMenuItem2 = new JMenuItem(ComponentNames.REMOVE_PLAYER.toString());
		playerMenuItem2.setMnemonic(KeyEvent.VK_R);
		playerMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));

		playerMenuItem3 = new JMenuItem(ComponentNames.DISPLAY_ALL_PLAYER.toString());
		playerMenuItem3.setMnemonic(KeyEvent.VK_D);
		playerMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));

		dealMenuItem1 = new JMenuItem(ComponentNames.PLACE_BET.toString());
		dealMenuItem1.setMnemonic(KeyEvent.VK_B);
		dealMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));

		dealMenuItem2 = new JMenuItem(ComponentNames.MANUAL_DEAL.toString());
		dealMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

		dealMenuItem3 = new JMenuItem(ComponentNames.AUTO_DEAL.toString());
		dealMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

		aboutlMenuItem = new JMenuItem(ComponentNames.ABOUT_THIS_GAME.toString());
		aboutlMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.ALT_MASK));
		// this is the code for the pop up box
		aboutlMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("About Menu item has been clicked");
				// set size of dialog
				aboutDialog = new AboutGameDiaglogBox(cardGameFrame, "About this Game", 200, true);

			}

		});

		// add all of the items to the menus
		playerJmenu.add(playerMenuItem1);
		playerJmenu.add(playerMenuItem2);
		playerJmenu.add(playerMenuItem3);
		dealerJmenu.add(dealMenuItem1);
		dealerSubMenu.add(dealMenuItem2);
		dealerSubMenu.add(dealMenuItem3);
		dealerJmenu.add(dealerSubMenu);
		aboutJMenu.add(aboutlMenuItem);
		// add to main menu bars
		menuBar.add(playerJmenu);
		menuBar.add(dealerJmenu);
		menuBar.add(aboutJMenu);
		// NB ADD MENU BAR TO FRAME

//		menuBar.setVisible(true);
		add(menuBar);

	}

}

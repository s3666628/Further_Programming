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
	JMenuItem addPlayerMenuItem, removePlayerMenuItem, displayAllPlayerMenuItem;
	JMenuItem placeBetMenuItem, manualDealMenuItem, autoDealMenuItem, aboutlMenuItem;
	JMenuItem aboutMenuItem;
	AboutGameDiaglogBox aboutDialog;

// code for this section based on tutorial at this locations	
//	https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

	public CardGameMenuBar(MainGameFrame cardGameFrame) {

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
		addPlayerMenuItem = new JMenuItem(ComponentNames.ADDPLAYER.toString());
		addPlayerMenuItem.setMnemonic(KeyEvent.VK_P);
		addPlayerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));

		removePlayerMenuItem = new JMenuItem(ComponentNames.REMOVE_PLAYER.toString());
		removePlayerMenuItem.setMnemonic(KeyEvent.VK_R);
		removePlayerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));

		displayAllPlayerMenuItem = new JMenuItem(ComponentNames.DISPLAY_ALL_PLAYER.toString());
		displayAllPlayerMenuItem.setMnemonic(KeyEvent.VK_D);
		displayAllPlayerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));

		placeBetMenuItem = new JMenuItem(ComponentNames.PLACE_BET.toString());
		placeBetMenuItem.setMnemonic(KeyEvent.VK_B);
		placeBetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));

		manualDealMenuItem = new JMenuItem(ComponentNames.MANUAL_DEAL.toString());
		manualDealMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

		autoDealMenuItem = new JMenuItem(ComponentNames.AUTO_DEAL.toString());
		autoDealMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

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
		playerJmenu.add(addPlayerMenuItem);
		playerJmenu.add(removePlayerMenuItem);
		playerJmenu.add(displayAllPlayerMenuItem);
		dealerJmenu.add(placeBetMenuItem);
		dealerSubMenu.add(manualDealMenuItem);
		dealerSubMenu.add(autoDealMenuItem);
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
	
	public void addPlayerListerner(ActionListener AddRemovePlayerButtonActionListener) {

		addPlayerMenuItem.addActionListener(AddRemovePlayerButtonActionListener);

	}

	public void remPlayerListerner(ActionListener AddRemovePlayerButtonActionListener) {

		removePlayerMenuItem.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void viewAllPlayerActionListener (ActionListener AddRemovePlayerButtonActionListener) {

		displayAllPlayerMenuItem.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void placeBetActionListener (ActionListener AddRemovePlayerButtonActionListener) {

		placeBetMenuItem.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void autoDealActionListener (ActionListener AutoDealButtonActionListener) {

		autoDealMenuItem.addActionListener(AutoDealButtonActionListener);
	}

}

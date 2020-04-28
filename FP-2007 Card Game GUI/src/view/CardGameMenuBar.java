package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

@SuppressWarnings("serial")
public class CardGameMenuBar extends JMenuBar implements MenuListener {

	JMenuBar menuBar;
	JMenu playerJmenu, dealerJmenu, aboutJMenu, dealerSubMenu;
	JMenuItem playerMenuItem1, playerMenuItem2, playerMenuItem3;

	JMenuItem dealMenuItem1, dealMenuItem2, dealMenuItem3, aboutlMenuItem;

	JMenuItem aboutMenuItem;
	
	cardGameDiaglogBox aboutDialog;
	


//	https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

	CardGameMenuBar(CardGameFrame cardGameFrame) {

		// PLAYERS MENU
		// 1 - create new menu bar

		menuBar = new JMenuBar();

		// 2 create the menus to go on the menu bar
		playerJmenu = new JMenu("Player");
		dealerJmenu = new JMenu("Deal");
		aboutJMenu = new JMenu("About");
//		// 2 a - add one sub munu
		dealerSubMenu = new JMenu("Deal Cards to Player");
		// dialog box 
//		JDialog d = new JDialog(cardGameFrame, "About This Game"); 
//		JLabel l = new JLabel("this is a dialog box"); 
//		d.add(l);
		
		
		

		// 3 create menu items
//
		playerMenuItem1 = new JMenuItem("Add Player");
		playerMenuItem1.setMnemonic(KeyEvent.VK_P);
		playerMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));

		playerMenuItem2 = new JMenuItem("Remove Player");
		playerMenuItem2.setMnemonic(KeyEvent.VK_R);
		playerMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));

		playerMenuItem3 = new JMenuItem("Display all Players");
		playerMenuItem3.setMnemonic(KeyEvent.VK_D);
		playerMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));

		dealMenuItem1 = new JMenuItem("Player Place Bet");
		dealMenuItem1.setMnemonic(KeyEvent.VK_B);
		dealMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));

		dealMenuItem2 = new JMenuItem("Manual Deal");
		dealMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

		dealMenuItem3 = new JMenuItem("Auto Deal");
		dealMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

		aboutlMenuItem = new JMenuItem("About This Game");
		aboutlMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.ALT_MASK));
		// this is the code for the pop up box
		aboutlMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("About Menu item has been clicked");
				 // setsize of dialog 
				aboutDialog = new cardGameDiaglogBox(cardGameFrame, "About this Game", "beeby", 100, true);
//				aboutDialog.setSize(100, 100); 
	  
	            // set visibility of dialog 
//				aboutDialog.setVisible(true); 
//				JDialog.showMessageDialog(cardGameFrame,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);   
				
			}
			
	
		
				
				
	});
//
//
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



	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}

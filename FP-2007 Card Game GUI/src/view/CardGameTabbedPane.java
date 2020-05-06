package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import model.PlayerIcons;

import java.util.Iterator;

@SuppressWarnings("serial")

// most code has been take from the demo of tab panes from Oracle
//https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
public class CardGameTabbedPane extends JPanel {

	static ArrayList<PlayersSample> AllPlayers = createPlayers();

	public static ArrayList<PlayersSample> createPlayers() {
		ArrayList<PlayersSample> listOfPlayers = new ArrayList<PlayersSample>();

		PlayersSample player1 = new PlayersSample("Philip Beeby", 2000, 100, "Suit", "Hearts");
		PlayersSample player2 = new PlayersSample("Daniel Stephens", 9000, 10, "Score", "N/A");
		PlayersSample player3 = new PlayersSample("David Wallace", 1000, 40, "Suit", "Clubs");
		PlayersSample player4 = new PlayersSample("Ian James", 3000, 200, "Suit", "Diamonds");
//		this.betAmount = betAmount;
//		this.betType = betType;
//		this.betSuit = betSuit;

		listOfPlayers.add(player1);
		listOfPlayers.add(player2);
		listOfPlayers.add(player3);
		listOfPlayers.add(player4);
		return listOfPlayers;

	}

	public String createPlayerScore(ArrayList<PlayersSample> players) {
		String displayText = "<html>";
		Iterator<PlayersSample> i = players.iterator();
		while (i.hasNext()) {
			displayText = displayText + i.next().toString() + "<br/>";
			System.out.println(displayText);
		}
		displayText = displayText + "</html>";
		;
		return displayText;
	}

	public CardGameTabbedPane() {
		super(new GridLayout(2, 4));

		JTabbedPane tabbedPane = new JTabbedPane();

		ImageIcon icon = new PanelIcon("test");
		String PlayerInfo = createPlayerScore(AllPlayers);

		Iterator<PlayersSample> i = AllPlayers.iterator();
		int PlayerNumber = 1;
		while (i.hasNext()) {
			PlayersSample player = i.next();

			System.out.println(player.toString());
			// makes a text panel
//			JComponent panel1 = makeTextPanel2("<html>"+player.toString()+"</html>"); // loop through the players scores here.
			JComponent panel1 = makeTextPanel2(player); // loop through the players scores here.
			tabbedPane.addTab("Player: " + PlayerNumber, PlayerIcons.getRandom().getImageIcon(), panel1,
					"Details for player");
//			tabbedPane.setMnemonicAt(0, "VK"+PlayerNumber);
			PlayerNumber += 1;
		}

//		JComponent panel1 = makeTextPanel(PlayerInfo); // loop through the players scores here.
//		tabbedPane.addTab("Players Details", icon, panel1, "Displays Points for all Players");
//		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//		
//		JComponent panel2 = makeTextPanel("Panel #2");
//		tabbedPane.addTab("Current Player Points", icon, panel2, "Does twice as much nothing");
//		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//
//		JComponent panel3 = makeTextPanel("Panel #3");
//		tabbedPane.addTab("Current Player Bets", icon, panel3, "Still does nothing");
//		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//
//		JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
//		panel4.setPreferredSize(new Dimension(50, 50));
//		tabbedPane.addTab("Tab 4", icon, panel4, "Does nothing at all");
//		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		filler.setVerticalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(6, 2));
		panel.add(filler);
		return panel;
	}

	protected JComponent makeTextPanel2(PlayersSample player) {
		
//		this.playerName = playerName; done
//		this.playerScore = playerScore;
//		this.betAmount = betAmount; done
//		this.betType = betType;
//		this.betSuit = betSuit;

		JPanel panel = new JPanel(false); // only need this once
		   LayoutManager layout = new GridLayout(4,4);

//		   panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		      panel.setLayout(layout); 
		      panel.setSize(100, 200);
		      panel.setBorder(BorderFactory.createTitledBorder("Player: "+ player.getPlayerName()));
		
		JFormattedTextField betAmountTextField;
		JFormattedTextField playerScoreTextField;
		// format bet amount
		NumberFormat amountFormat = NumberFormat.getCurrencyInstance();
		betAmountTextField = new JFormattedTextField(amountFormat);
		betAmountTextField.setName("Bet Amount");
		betAmountTextField.setColumns(10);
		betAmountTextField.setEditable(false);
		JLabel amountLabel = new JLabel("Player Bet Amount $:");
		amountLabel.setLabelFor(betAmountTextField);
		betAmountTextField.setValue(player.getBetAmount()); // will need to change this as hard coded at the moment

		// format score		
		NumberFormat principleFormat = NumberFormat.getNumberInstance();
	      playerScoreTextField = new JFormattedTextField(principleFormat);
	      playerScoreTextField.setName("Player Score");
	      playerScoreTextField.setColumns(10);
	      playerScoreTextField.setEditable(false);
	      JLabel scoreLabel = new JLabel("Player Score");
	      scoreLabel.setLabelFor(playerScoreTextField);
	      playerScoreTextField.setValue(player.getPlayerScore());
	      
	      
		// format bet type
	    JFormattedTextField playerBetTypeTextField = new JFormattedTextField(player.getBetType());
		playerBetTypeTextField.setName("Player Bet Type");
		playerBetTypeTextField.setColumns(10);
		playerBetTypeTextField.setEditable(false);
		JLabel betTypeLabel = new JLabel("Player Bet Type");
		betTypeLabel.setLabelFor(playerBetTypeTextField);
		playerBetTypeTextField.setValue(player.getBetType());
		
		// format bet Suit
	    JFormattedTextField playerBetSuitTextField = new JFormattedTextField(player.getBetSuit());
	    playerBetSuitTextField.setName("Player Chosen Suit");
	    playerBetSuitTextField.setColumns(10);
	    playerBetSuitTextField.setEditable(false);
		JLabel betSuitLabel = new JLabel("Player Chosen Suit");
		betSuitLabel.setLabelFor(playerBetSuitTextField);
		playerBetSuitTextField.setValue(player.getBetSuit());
		      
	      
			panel.add(amountLabel);
			panel.add(betAmountTextField);
			panel.add(scoreLabel);
			panel.add(playerScoreTextField);
			panel.add(betTypeLabel);
			panel.add(playerBetTypeTextField);
			panel.add(betSuitLabel);
			panel.add(playerBetSuitTextField);


		return panel;
	}

}

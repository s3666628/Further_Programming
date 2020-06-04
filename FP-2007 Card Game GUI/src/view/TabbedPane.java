package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Player;
import model.PlayerIcons;
import model.PlayerImpl;
import model.bet.Bet;
import model.GameEngine;

import java.util.Iterator;

@SuppressWarnings("serial")

// most code has been take from the demo of tab panes from Oracle
//https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
public class TabbedPane extends JPanel {

	public static HashMap<String, JComponent> playerPanel = new HashMap<String, JComponent>(); // stores panel for
																								// players

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

	private JTabbedPane tabbedPane;

	static int playerNumber = 1;
	static int playerPanelNum = 0;

	public TabbedPane(MainGameFrame cardGameFrame) {
		super(new GridLayout(4, 4));
		this.tabbedPane = new JTabbedPane();
		ImageIcon icon = new PanelIcon("test"); // not used at the moment
		add(tabbedPane);

	}

	public void refreshTabbedPane(Player player) {
		tabbedPane.remove(playerPanel.get(player.getId()));
		playerNumber -= 1;
		addNewPlayerToTabbedFrame(player);
		playerPanelNum += 1;
	}

	public void addNewPlayerToTabbedFrame(Player player) {

		JComponent panel1 = makeTextPanel(player); // .
//		panel1.setPreferredSize(new Dimension(50, 2));
		tabbedPane.addTab("Player: " + playerNumber, PlayerIcons.getRandom().getImageIcon(), panel1,
				"Details for player");
		playerPanel.put(player.getId(), panel1); // add player id and panel to hash map
		System.out.println("Player panel numner is: " + playerPanelNum);
		System.out.println("Player has been added to Hash Map" + playerPanel.get(player.getId()));
		
		playerNumber += 1;
		playerPanelNum += 1;

	}

	public void removePlayerFromTabbedFrame(Player player) throws NullPointerException, IllegalArgumentException {
		if (player.getId() == null) {
			throw new NullPointerException("Player Id is null");
		}
		if (playerPanel.get(player.getId()) == null) {
			throw new NullPointerException("Cannot locate Player ID to remove Player Panel");
		}
		playerNumber -= 1; // reduce the num of players

		tabbedPane.remove(playerPanel.get(player.getId())); // remove the player panel object

	}

	protected JComponent makeTextPanel(Player player) {

		// TODO some of this has hard coded values atm

		JPanel panel = new JPanel(false); // only need this once
		JPanel cardPlayerPanel =  new PlayerHandPanel(player, player.getName());
//		JPanel cardDealerPanel =  new DealerHandPanel("dealer");
		
		Box theBox = Box.createVerticalBox();
		
		
		LayoutManager layout = new GridLayout(5, 5);

//		   panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setLayout(layout);
//		      panel.setSize(10, 10);
//		panel.setPreferredSize(new Dimension(2, 2));
		panel.setBorder(BorderFactory.createTitledBorder("Player: " + player.getName()));

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
		betAmountTextField.setValue(player.getBet().getAmount()); // will need to change this as hard coded at the
																	// moment

		// format score
		NumberFormat principleFormat = NumberFormat.getNumberInstance();
		playerScoreTextField = new JFormattedTextField(principleFormat);
		playerScoreTextField.setName("Player Score");
		playerScoreTextField.setColumns(10);
		playerScoreTextField.setEditable(false);
		JLabel scoreLabel = new JLabel("Player Score");
		scoreLabel.setLabelFor(playerScoreTextField);
		playerScoreTextField.setValue(player.getPoints());

		// format bet type
		JFormattedTextField playerBetTypeTextField = new JFormattedTextField(player.getBet());
		playerBetTypeTextField.setName("Player Bet Type");
		playerBetTypeTextField.setColumns(10);
		playerBetTypeTextField.setEditable(false);
		JLabel betTypeLabel = new JLabel("Player Bet Type");
		betTypeLabel.setLabelFor(playerBetTypeTextField);
		playerBetTypeTextField.setValue(player.getBet());

		// format bet Suit
		JFormattedTextField playerBetSuitTextField = new JFormattedTextField("None");
		playerBetSuitTextField.setName("Player Chosen Suit");
		playerBetSuitTextField.setColumns(10);
		playerBetSuitTextField.setEditable(false);
		JLabel betSuitLabel = new JLabel("Player Chosen Suit");
		betSuitLabel.setLabelFor(playerBetSuitTextField);
		Bet playerBet = player.getBet();
//		playerBet.
		playerBetSuitTextField.setValue(player.getBet());
		
		

		panel.add(amountLabel);
		panel.add(betAmountTextField);
		panel.add(scoreLabel);
		panel.add(playerScoreTextField);
		panel.add(betTypeLabel);
		panel.add(playerBetTypeTextField);
		panel.add(betSuitLabel);
		panel.add(playerBetSuitTextField);
//		panel.add(cardPanel);
		theBox.add(panel);
		theBox.add(cardPlayerPanel);
//		theBox.add(cardDealerPanel);

		return theBox;
	}

}

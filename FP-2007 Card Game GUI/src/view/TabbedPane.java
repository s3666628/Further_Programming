package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Player;
import model.PlayerIcons;
import model.PlayerImpl;
import model.GameEngine;

import java.util.Iterator;

@SuppressWarnings("serial")

// most code has been take from the demo of tab panes from Oracle
//https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
public class TabbedPane extends JPanel {
	// all the players code is for testing purposes so we can add players for A2a
	
	static ArrayList<PlayersSample> AllPlayers = createPlayers();
	
//	static ArrayList<PlayersSample> AllCurrentPlayers =  getAllPlayers() 
	

	public static ArrayList<PlayersSample> createPlayers() {
		ArrayList<PlayersSample> listOfPlayers = new ArrayList<PlayersSample>();
		

		PlayersSample player1 = new PlayersSample("Philip Beeby", 2000, 100, "Suit", "Hearts");
		PlayersSample player2 = new PlayersSample("Daniel Stephens", 9000, 10, "Score", "N/A");
		PlayersSample player3 = new PlayersSample("David Wallace", 1000, 40, "Suit", "Clubs");
		PlayersSample player4 = new PlayersSample("Ian James", 3000, 200, "Suit", "Diamonds");
		

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
	private JTabbedPane tabbedPane;
	
	static int PlayerNumber = 1;
	
	public TabbedPane(MainGameFrame cardGameFrame) {
		super(new GridLayout(2, 4));

//		JTabbedPane tabbedPane = new JTabbedPane();
		
		this.tabbedPane = new JTabbedPane();
		
		ImageIcon icon = new PanelIcon("test"); // not used at the moment
//		String PlayerInfo = createPlayerScore(AllPlayers);

//		Iterator<PlayersSample> i = AllPlayers.iterator();
//		int PlayerNumber = 1;
//		while (i.hasNext()) {
//			PlayersSample player = i.next();
//			System.out.println(player.toString());
//			// makes a text panel
//			JComponent panel1 = makeTextPanel2(player); // loop through the players scores here.
//			panel1.setPreferredSize(new Dimension(50, 2));
//			tabbedPane.addTab("Player: " + PlayerNumber, PlayerIcons.getRandom().getImageIcon(), panel1,
//					"Details for player");
//			PlayerNumber += 1;
//		}

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
//		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
	public void addNewPlayerToTabbedFrame(Player player) {
		
		JComponent panel1 = makeTextPanel(player); // .
		panel1.setPreferredSize(new Dimension(50, 2));
		tabbedPane.addTab("Player: " + PlayerNumber, PlayerIcons.getRandom().getImageIcon(), panel1,
				"Details for player");
		PlayerNumber += 1;
		
	}
//
//	protected JComponent makeTextPanel(String text) {
//		JPanel panel = new JPanel(false);
//		JLabel filler = new JLabel(text);
//		filler.setHorizontalAlignment(JLabel.CENTER);
//		filler.setVerticalAlignment(JLabel.CENTER);
//		panel.setLayout(new GridLayout(6, 2));
//		panel.add(filler);
//		return panel;
//	}

	protected JComponent makeTextPanel(Player player) {
		
		//TODO some of this has hard coded values atm

		JPanel panel = new JPanel(false); // only need this once
		LayoutManager layout = new GridLayout(4, 4);

//		   panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setLayout(layout);
//		      panel.setSize(10, 10);
		panel.setPreferredSize(new Dimension(2, 2));
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
		betAmountTextField.setValue(player.getBet().getAmount()); // will need to change this as hard coded at the moment

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
		JFormattedTextField playerBetSuitTextField = new JFormattedTextField("Hearts");
		playerBetSuitTextField.setName("Player Chosen Suit");
		playerBetSuitTextField.setColumns(10);
		playerBetSuitTextField.setEditable(false);
		JLabel betSuitLabel = new JLabel("Player Chosen Suit");
		betSuitLabel.setLabelFor(playerBetSuitTextField);
		playerBetSuitTextField.setValue("Heats");

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

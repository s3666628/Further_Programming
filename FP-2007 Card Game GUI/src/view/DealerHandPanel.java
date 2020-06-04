package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ClubCardPack;
import model.GameEngineImpl;
import model.Player;
import model.card.Card;
import model.card.Hand;

@SuppressWarnings("serial")
public class DealerHandPanel extends JPanel {

	JLabel displayText;
	JLabel displayCardText;
	private JLabel cardImageLabel;
	private ImageIcon cardImage;
	
	void displayDealtCard(){
		
	}
	
	public ImageIcon getImageIcon(String path) {
		
		ImageIcon cardImage = new ImageIcon(path);
		return cardImage;
		}
//
	public DealerHandPanel(Hand houseHand, Card card) {
		
		
//		setLayout(new GridLayout(0, 6, 5, 5)); // might need to change this
		setBackground(Color.GREEN);

		this.displayText = new JLabel("Dealer");
		add(displayText);
	

		// get number of cards in deck
		

//		Hand playerHand = player.getHand();
		Collection<Card> playerCards = houseHand.getCards();
		
//	
		for (Iterator<Card> iterator = playerCards.iterator(); iterator.hasNext();) {
			  Card dealerCard = iterator.next();
			  System.out.println("PLAYER HAS CARD "+dealerCard.toString());
			  System.out.println("PLAYER HAS CARD "+dealerCard.toString());	  
			  

//			  }
			  System.out.println(dealerCard.toString());
			  
			  this.displayCardText = new JLabel(dealerCard.toString());
			  this.cardImage = getImageIcon("images/"+dealerCard.toString()+".png");			  
			  this.cardImageLabel = new JLabel(CardGameHelperMethods.resizeImageIcon(cardImage, 70, 110));

			  
			  System.out.println("images/"+dealerCard.toString()+".png");
			  
			  add(displayCardText);	
			  add(cardImageLabel);
			}
		
//		int counter = 0;
//		while (counter < numberCards) {
//			// gets a random card image at the moment
//			ImageIcon imageIcon = CardPack.getRandom().getImageIcon();
//			; // load the image to a imageIcon
////	
////			use helper method to resize the icon
//			imageIcon = CardGameHelperMethods.resizeImageIcon(imageIcon, 70, 110);
//
//			JLabel labelOne = new JLabel(imageIcon); // add image icon to the label
//			add(labelOne); // add the label to the panel
//			counter += 1;

		}
		


	
	
	
	public DealerHandPanel(Player player, Card card){
		
		
//		setLayout(new GridLayout(0, 6, 5, 5)); // might need to change this
		setBackground(Color.GREEN);
		
		
	

		this.displayText = new JLabel(player.getName());
		add(displayText);
		this.displayCardText = new JLabel(card.toString());
		add(displayCardText);

		
		




		}
		


	}




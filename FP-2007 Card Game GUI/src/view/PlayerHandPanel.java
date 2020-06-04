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
public class PlayerHandPanel extends JPanel {

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
	public PlayerHandPanel(Player player, String displaytext) {
		
		
//		setLayout(new GridLayout(0, 6, 5, 5)); // might need to change this
		setBackground(Color.GREEN);

		this.displayText = new JLabel(displaytext);
		add(displayText);
	

		// get number of cards in deck
		
		
		Hand playerHand = player.getHand();
		Collection<Card> playerCards = playerHand.getCards();
		
	
		for (Iterator<Card> iterator = playerCards.iterator(); iterator.hasNext();) {
			  Card card = iterator.next();
			  System.out.println("PLAYER HAS CARD "+card.toString());
			  System.out.println("PLAYER HAS CARD "+card.toString());	  
			  

//			  }
			  System.out.println(card.toString());
			  
			  this.displayCardText = new JLabel(card.toString());
			  this.cardImage = getImageIcon("images/"+card.toString()+".png");			  
			  this.cardImageLabel = new JLabel(CardGameHelperMethods.resizeImageIcon(cardImage, 70, 110));

			  
			  System.out.println("images/"+card.toString()+".png");
			  
			  add(displayCardText);	
			  add(cardImageLabel);
			}	

		}
		


	
	
	
	public PlayerHandPanel(Player player, Card card){
		
		
//		setLayout(new GridLayout(0, 6, 5, 5)); // might need to change this
		setBackground(Color.GREEN);
		
		
	

		this.displayText = new JLabel(player.getName());
		add(displayText);
		this.displayCardText = new JLabel(card.toString());
		add(displayCardText);

		
		




		}
		


	}




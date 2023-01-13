package hw03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Thomas
 * Holds a 52 card Deck of playing cards
 */
public class Deck {
	
	
	private final String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
	private final String[] names = {"2","3","4","5","6","7","8","9","10","J","Q","K","A" };
	private final int[] values = { 2,3,4,5,6,7,8,9,10,11,12,13,14};
	private Card[] cards;
	
	public Deck() {
		int j = 0;
		cards = new Card[52];
		
		for(String suit: suits) {
			for(int i = 0; i<13; i++) {
				cards[j]=new Card(suit,names[i],values[i]);
				j++;
			}
		}
	}
	
	public void shuffle() {
		List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
	}
	
	/**
	 * @param players zero or more hands to deal to
	 * Shuffles the deck, then distributes all cards evenly to all hands
	 */
	public void deal(Player[] players) {
		// TODO: shuffle the deck, then distribute all cards in the deck to all players
		//            using the player.addCard(card) method
		//       Use a round-robin distribution... one card to each player, then back to the first player
		//            until all cards have been distributed
		//       At the end of the deal, some players may have 1 more card than others... that's OK
		//            but distribution should be as even as possible
		
		int i=0;
		this.shuffle();
		while(i<52) {
			for (int j=0; j<players.length;j++) {
				if (i<52) {
					players[j].addCard(cards[i]);
					i++;
				}
				else {
					i++;
				}
				
			}
		}
		
	}
}

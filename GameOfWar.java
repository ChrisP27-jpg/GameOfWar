package hw03;

import java.util.Collections;

public class GameOfWar {
	private Deck deck;
	private Player[] players;	

	public GameOfWar(String[] playerNames) {
		// TODO: instantiate the players array, and initialize that
		//		array using the playerNames array passed in as an argument.
		// 	Also, instantiate the deck, and invoke the deck deal method
		//		on your list of players.
		players = new Player[playerNames.length];
		for (int i=0; i<playerNames.length; i++) {
			players[i]= new Player(playerNames[i]);
		}
		deck=new Deck();
		deck.deal(players);
	}
	
	private Player winner() {
		// TODO: Loop through all players. If any player is a winner,
		//		return that player. If not, return null
		for (Player player:players) {
			if (player.isWinner()==true) {
				return player;
			}
		}
		return null;
	}
	
	public void play() {
		while(winner()==null) {
			battle();
		}
		System.out.println("Winner is: " + winner());
	}
	
	private void battle() {
		boolean isTie=true;
		Card maxCard=null;
		Player winner=null;
		Hand table=new Hand(); // Keep track of all cards played
		while(isTie) {
			isTie=false;
			maxCard=null;
			for(Player player : players) {
				Card card = player.getCard();
				if (card==null) continue;
				if (maxCard==null || card.getValue()>maxCard.getValue()) {
					maxCard=card;
					isTie=false;
					winner=player;
				} else if (maxCard.getValue()==card.getValue()) {
					isTie=true;
				}
				table.add(card);
			}
			if (isTie) {
				System.out.println("  Tied on a " + maxCard.getName() + " it's a war!");
				for(Player player : players) {
					table.add(player.getCard());
					table.add(player.getCard());
					table.add(player.getCard());
				}
			}
			assert(table.size()<52); 
		}
		System.out.print("Player " + winner + " won with " + maxCard + " and got " + table.size() + " cards");
		Collections.shuffle(table); // Randomize the results to avoid endless ties
		while(true) {
			Card card=table.poll();
			if (card==null) break;
			winner.addCard(card);
		}
		int ds=0;
		System.out.print(" -- ");
		for(Player player : players) {
			ds+=player.handSize();
			System.out.print(player + ": " + player.handSize() + " cards ");
		}
		System.out.println();
		assert(ds==52);
	}

	public static void main(String[] args) {
		assert(args.length>0);
		// TODO: make a new GameOfWar, passing in the command line
		// 	arguments as the list of player names, 
		//    then play the game.
		
		GameOfWar game = new GameOfWar(args);
		
		game.play();
	}

}

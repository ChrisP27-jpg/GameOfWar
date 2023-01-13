package hw03;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name) {
		super();
		this.name = name;
		this.hand = new Hand();
	}
	
	public void addCard(Card newCard) {
		hand.add(newCard);
	}
	
	public Card getCard() {
		Card card = hand.poll();
		return card;
	}
	
	public int handSize() {
		return hand.size();
	}
	
	public boolean isWinner() {
		if(hand.size()==52) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return name;
	}

}

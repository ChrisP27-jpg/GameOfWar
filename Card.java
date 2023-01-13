package hw03;

public class Card {
	private String suit;
	private String name;
	private int value;
	
	public Card(String suit, String name, int value) {
		super();
		this.suit = suit;
		this.name = name;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name + " " + suit.substring(0,1);	
	}
	
}

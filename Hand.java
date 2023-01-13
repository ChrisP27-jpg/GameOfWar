package hw03;

import java.util.LinkedList;

public class Hand extends LinkedList<Card> {

	private static final long serialVersionUID = 1L;
	
	public boolean add(Card card) {
		if (card==null) return false;
		return super.add(card);
	}

}

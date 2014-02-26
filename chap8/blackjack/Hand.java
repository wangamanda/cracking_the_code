package blackjack;

import java.util.ArrayList;

public class Hand<T extends Card>{

	protected ArrayList<T> HandCards = new ArrayList<T>();

	public int Score(){
		int s;
		for(T card: HandCards){
			s += HandCards.getValue();
		}
		return s;
	}

	public void addCard(T card){
		HandCards.add(card);
	}
}

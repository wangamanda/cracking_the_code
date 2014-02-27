package blackjack;

import java.util.ArrayList;

public class Hand<T extends Card>{

	protected ArrayList<T> cards = new ArrayList<T>();

	public int score(){
		int s = 0;
		for(T card: cards){
			s += card.Value();
		}
		return s;
	}

	public void addCard(T card){
		cards.add(card);
	}
}

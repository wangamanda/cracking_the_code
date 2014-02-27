package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card>{

	private ArrayList<T> cards;
	private int dealtIndex = 0;

	public Deck(){
	
	}

	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}

	public void shuffle(){
		T card1 = cards.get(0);
		T card2 = cards.get(cards.size()-1);
		cards.set(0, card2);
		cards.set(cards.size()-1, card1);
		for (int i = 1 ; i < cards.size() ; i ++ ){
			Random r = new Random();
			int n = r.nextInt(i);
			T card3 = cards.get(i);
			T card4 = cards.get(n);
			cards.set(i, card4);
			cards.set(n, card3);
		}
	}

	public T[] HandCards(int number){
		if (cards.size() - dealtIndex < number){
			return null;
		}
		T[] handcards = (T[]) new Card[number];
		int count = 0;
		while (count < number){
			T card = cards.get(dealtIndex++);
			handcards[count++] = card;
			card.markUnavailable();
		}
		return handcards;
	}

	public T dealCard(){
		if (cards.size() - dealtIndex == 0){
			return null;
		}
		T card = cards.get(dealtIndex++);
		card.markUnavailable();
		return card;
	}
}

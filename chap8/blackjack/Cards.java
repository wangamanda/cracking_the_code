package blackjack;

public abstract class Cards{
	Suit suit;
	int value;

	public Cards(Suit s, int v){
		suit = s;
		value = v;
	}

	public abstract int getValue();

	public Suit getSuit(){
		return suit;
	}
}

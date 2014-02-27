package blackjack;

public abstract class Card{
	protected Suit suit;
	protected int faceValue;
	private boolean available = true;

	public Card(Suit s, int v){
		suit = s;
		faceValue = v;
	}

	public abstract int getValue();

	public Suit getSuit(){
		return suit;
	}

	public boolean isAvailable(){
		return available;
	}

	public void markAvailable(){
		available = true;
	}

	public void markUnavailable(){
		available = false;
	}
}

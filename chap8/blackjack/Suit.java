package blackjack;

public enum Suit{
	Heart(0),
	Spade(1),
	Dimond(2),
	Club(3);

	private int value;
	private Suit(int v){
		value = v;
	}

	public int getValue(){
		return value;
	}

	public Suit getSuit(int v){
		switch(v){
			case 0:
				return Suit.Heart;
			case 1:
				return Suit.Spade;
			case 2:
				return Suit.Dimond;
			case 3:
				return Suit.Club;
			default:
				return null;
		}
	}
}

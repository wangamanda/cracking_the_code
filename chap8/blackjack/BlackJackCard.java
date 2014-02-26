package blackjack;

public class BlackJackCard extends Cards{
	private boolean BustAce = false;

	BlackJackCard(Suit s, int v){
		super(s, v);
	}

	public int getValue(){
		if(faceValue == 1){
			if(BustAce){
				return 1;
			}else{
				return 11;
			}
		}else if(faceValue >= 10 && faceValue <= 13){
			return 10;
		}else{
			return faceValue;
		}
	}

}

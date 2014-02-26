package blackjack;

public class BlackJackCard extends Cards{

	BlackJackCard(Suit s, int v){
		super(s, v);
	}

	public int getValue(){
		if(faceValue == 1){
			if(isAce()){
				return 1;
			}
		}else if(faceValue >= 10 && faceValue <= 13){
			return 10;
		}else{
			return faceValue;
		}
	}

	public boolean isAce(){
		if (faceValue == 1){
			return true;
		}
		return false;
	}

	public boolean isFace(){
		if (faceValue >= 10 && faceValue <= 13){
			return true;
		}
		return false;
	}

	public int maxValue(){
		if(isAce()){
			return 11;
		}else{
			return faceValue;
		}
	}

	public int minValue(){
		if(isAce()){
			return 1;
		}else{
			return faceValue;
		}
	}

}

package blackjack;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard>{
	public int score(){
		ArrayList<Integer> scores = getPossibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minAbove = Integer.MAX_VALUE;
		for (int score : scores){
			if(score > 21 && score < minAbove){
				minAbove = score;
			}else if(score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minAbove : maxUnder;
	}

	public ArrayList<Integer> getPossibleScores(){
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (BlackJackCard card : cards){
			addPossibleScores(card, scores);
		}
		return scores;
	}

	public void addPossibleScores(BlackJackCard card, ArrayList<Integer> scores){
		if (scores.size() == 0){
			scores.add(0);
		}
		int length = scores.size();
		for (int i = 0 ; i < length ; i ++ ){
			int score = scores.get(i);
			scores.set(i, score + card.minValue());
			if(card.minValue() != card.maxValue()){
				scores.add(score + card.maxValue());
			}
		}
	}

	public boolean isBust(){
		if (score() > 21){
			return true;
		}
		return false;
	}

	public boolean is21(){
		return score() == 21;
	}

	public boolean isBlackJack(){
		if (cards.size() != 2){
			return false;
		}
		BlackJackCard val1 = cards.get(0);
		BlackJackCard val2 = cards.get(1);
		if ((val1.isFace() && val2.isAce()) || (val1.isAce() && val2.isFace())){
			return true;
		}
		return false;
	}
}

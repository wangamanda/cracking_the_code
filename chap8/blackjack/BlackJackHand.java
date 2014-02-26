package blackjack;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard>{
	public int score(){
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int maxUnder = Integer.MIN_VALUE;
		int minAbove = Integer.MAX_VALUE;
		for (int score : scores){
			if(score > 21 && score < minAbove){
				minAbove = score;
			}
		}
	}
}

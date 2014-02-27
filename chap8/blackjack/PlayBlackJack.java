package blackjack;

import java.util.ArrayList;

public class PlayBlackJack{
	public static void main(String args[]){
		int num = 5;
		BlackJackGame game = new BlackJackGame(num);
		game.initializeDeck();
		boolean success = game.initDeal();
		if (!success){
			System.out.println("Out of card!");
		}else{
			ArrayList<Integer> blackjacks = game.getBlackJack();
			if (blackjacks.size() > 0){
				System.out.println("BlackJacks: ");
				for (int i = 0 ; i < blackjacks.size() ; i ++ ){
					System.out.println(i+" ");
				}
			}else{
				success = game.playAllHands();
				if(!success){
					System.out.println("Out of card!");
				}else{
					ArrayList<Integer> winners = game.getWinners();
					if(winners.size() > 0){
						System.out.println("Winners: ");
						for (int i = 0 ; i < winners.size() ; i ++ ){
							System.out.println(i+" ");
						}
					}
				}
			}
		}
	}
}

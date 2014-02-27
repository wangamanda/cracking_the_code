package blackjack;

import java.util.ArrayList;

public class BlackJackGame{
	int UNTIL = 16;
	private BlackJackHand[] hands;
	private Deck<BlackJackCard> deck;

	public BlackJackGame(int numplayer){
		hands = new BlackJackHand[numplayer];
		for (int i = 0 ; i < numplayer ; i ++ ){
			hands[i] = new BlackJackHand();
		}
	}

	public boolean initDeal(){
		for (BlackJackHand hand : hands){
			BlackJackCard card1 = deck.dealCard();
			BlackJackCard card2 = deck.dealCard();
			if(card1 == null || card2 == null){
				return false;
			}
			hand.addCard(card1);
			hand.addCard(card2);
		}
		return true;
	}

	public ArrayList<Integer> getBlackJack(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0 ; i < hands.length ; i ++ ){
			if(hands[i].isBlackJack()){
				arr.add(i);
			}
		}
		return arr;
	}

	public ArrayList<Integer> getWinners(){
		int winningscore = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0 ; i < hands.length ; i ++ ){
			if(hands[i].score() > winningscore){
				winningscore = hands[i].score();
				arr.clear();
				arr.add(i);
			}else if(hands[i].score() == winningscore){
				arr.add(i);
			}
		}
		return arr;
	}

	public boolean playAllHands(){
		for (BlackJackHand hand : hands){
			if(!playHand(hand)){
				return false;
			}
		}
		return true;
	}

	public boolean playHand(BlackJackHand hand){
		while(hand.score() < UNTIL){
			BlackJackCard card1 = deck.dealCard();
			if (card1 == null){
				return false;
			}
			hand.addCard(card1);
		}
		return true;
	}

	public void initializeDeck(){
		deck = new Deck<BlackJackCard>();
		ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		for (int i = 0 ; i < 13 ; i ++ ){
			for (int j = 0 ; j < 4 ; j ++ ){
				Suit suit = Suit.getSuit(j);
				BlackJackCard card = new BlackJackCard(suit, i+1);
				cards.add(card);
			}
		}
		deck.setDeckOfCards(cards);
		deck.shuffle();
	}
}

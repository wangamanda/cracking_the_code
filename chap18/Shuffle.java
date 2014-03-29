import java.util.Random;
import java.util.Arrays;

public class Shuffle{
	public static void main(String[] args){
		int[] cards = new int[52];
		for(int i = 0 ; i < cards.length ; i ++ ){
			cards[i] = i;
		}

		System.out.println(Arrays.toString(cards));
		for(int i = 0 ; i < cards.length ; i ++ ){
			int t = rand(0, i);
			int tmp = cards[i];
			cards[i] = cards[t];
			cards[t] = tmp;
		}

		System.out.println(Arrays.toString(cards));
	}

	public static int rand(int low, int high){
		return low+(int)(Math.random()*(high-low+1));
	}
}

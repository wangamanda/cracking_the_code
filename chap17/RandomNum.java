import java.util.Random;

public class RandomNum{
	public static int rand5(){
		Random r = new Random();
		int n = r.nextInt(5);
		return n;
	}

	public static int rand7(){
		while(true){
			int n = rand5()*5 + rand5();
			if(n < 21){
				return n % 7;
			}
		}
	}

	public static void main(String[] args){
		int res = rand7();
		System.out.println(res+"");
	}
}

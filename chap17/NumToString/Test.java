package NumToString;

public class Test{

	public static void main(String[] args){
		int N = Integer.parseInt(args[0]);
		System.out.println(N+"");
		PrintNum p = new PrintNum();
		String res = p.getStringFromInt(N);
		System.out.println(res);
	}
}

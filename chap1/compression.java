public class compression{

	public static void main(String args[]){

		String input = "aabcccccaaa";
		String output = compress(input);
		System.out.println(input);
		System.out.println(output);
	}

	public static String compress(String a){

		int len = a.length();
		StringBuffer b = new StringBuffer();
		int cnt = 1;

		for (int i = 1 ; i < len ; i ++ ){
			if (a.charAt(i) == a.charAt(i-1)){
				cnt ++ ;
			}else{
				b.append(a.charAt(i-1));
				b.append(Integer.toString(cnt));
				cnt = 1;
			}
		}
		if (a.charAt(len-1) == a.charAt(len-2)){
			b.append(a.charAt(len-1));
			b.append(Integer.toString(cnt));
		}else{
			cnt = 1;
			b.append(a.charAt(len-1));
			b.append(Integer.toString(cnt));
		}

		if (a.length() <= b.length()){
			return a;
		} else {
			return b.toString();
		}
	}
}

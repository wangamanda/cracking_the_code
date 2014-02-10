public class permutation2{
	
	public static void main(String args[]){
	
		String[][] str = {{"abcef","acbfe"},{"hello", "oelhl"},{"fine","enffi"}};
		for (String[] s: str){
		String a = s[0];
		String b = s[1];

		if (isPermutation(a, b)){
			System.out.println( a + " is a permutation of string: " + b);
		} else {
			System.out.println( a + " is not a permutation of string: " + b);
		}
		}
	}

	public static boolean isPermutation(String a, String b){
		
		if (a.length() != b.length()){
			return false;
		}
		
		int[] arr = new int[256];
		char[] ta = a.toCharArray();
		for (char c: ta ){
			arr[c]++;
		}

		char[] tb = b.toCharArray();
		for (char c:tb){
			arr[c]--;
			if(arr[c] < 0){
				return false;
			}
		}

		return true;

	}
}

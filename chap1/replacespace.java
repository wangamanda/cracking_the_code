public class replacespace {

	public static void main(String args[]){
	
		String input = "Mr John Simth    ";
		int l = 13;

		char[] arr = input.toCharArray();
		System.out.println(input);
		String output = replace(input, l);
		String output2 = replace2(arr, l);
		System.out.println(output);
		System.out.println(output2);
		System.out.println(arr);
	}

	public static String replace(String a, int l){
	
		char[] c = new char[l];
		char[] d = new char[a.length()];
		c = a.toCharArray();

		for (int i = 0, j = 0 ; i < l; ){
			if (c[i] != ' '){
				d[j] = c[i];
				i ++ ;
				j ++ ;
			} else if (c[i] == ' '){
				d[j] = '%';
				j ++ ;
				d[j] = '2';
				j ++ ;
				d[j] = '0';
				j ++ ;
				i ++ ;
			}
		}
		System.out.println();
		return String.valueOf(d);
	}

	public static String replace2(char[] arr, int l){
		
		int cnt = 0;
		for(int i = 0 ; i < l ; i ++ ){
		
			char c = arr[i];
			if (c == ' '){
				cnt ++ ;
			}
		}

		int len = l + (cnt << 1);	
		int j = len-1;
		for (int i = l-1 ; i >=0 ; i --  ){
			
			if (arr[i] != ' '){
				arr[j] = arr[i];
				j -- ;
			} else {
				arr[j] = '0';
				j -- ;
				arr[j] = '2';
				j -- ;
				arr[j] = '%';
				j --;
			}
		}

		return String.valueOf(arr);
	}
}

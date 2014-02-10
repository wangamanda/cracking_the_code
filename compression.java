import java.io.*;

public class compression{
	public static void main(String args[]) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();

		int len = str.length();
		int i;
		int j = 0;
		int count = 1;
		char b[];
		int m;
		b = new char[len<<1];
		if (len == 1){
			System.out.println(str);
			return;
		}
		for (i = 1 ; i < len ; i ++){
			if (str.charAt(i) == str.charAt(i-1)){
				count ++ ;
			}
			else{
				b[j] = str.charAt(i-1);
				j ++ ;
				String temp = Integer.toString(count);
				int temp_len = temp.length();
				for (m = 0 ; m < temp_len ; m ++){
					b[j] = temp.charAt(m);
					j ++ ;
				}
				count = 1;
			}
		}
		b[j] = str.charAt(i-1);
		j ++ ;
		String temp = Integer.toString(count);
		int temp_len = temp.length();
		for (m = 0 ; m < temp_len ; m ++){
			b[j] = temp.charAt(m);
			j ++ ;
		}

		if (j > len){
			for (i = 0 ; i < len ; i ++)
				System.out.print(str.charAt(i));
		}
		else{
			for (i = 0 ; i < j ; i ++)
				System.out.print(b[i]);
		}
	
	System.out.print("\n");
	}

}

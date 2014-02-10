import java.io.*;

public class replace{
	public static void main(String args[]) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		int len = str.length();
		char arr[];
		arr = new char[len];
		int j = len-1;
		int i = len-1;
		int temp;
		
		while ((temp = str.codePointAt(i)) == ' ')
		{
			i --;
		}
		

		for ( ; i >= 0 ; i --)
		{
			temp = str.codePointAt(i);
			if (temp == (int)' ')
			{
				arr[j] = '0';
				j -- ;
				arr[j] = '2';
				j -- ;
				arr[j] = '%';
				j -- ; 
			}
			else
			{
				arr[j] = (char)temp;
				j -- ;
			}
		}
		for (i = j ; i < len ; i ++)
		{
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}
}

import java.io.*;

public class permutation{
	public static void main(String args[]) throws IOException {
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);
		String str1 = br1.readLine();
		InputStreamReader isr2 = new InputStreamReader(System.in);
		BufferedReader br2 = new BufferedReader(isr2);
		String str2 = br2.readLine();
		int len1,len2;
		len1 = str1.length();
		len2 = str2.length();
		int string1[];
		string1 = new int[256];
		int string2[];
		string2 = new int[256];
		int n1,n2;
		int i;
		boolean a = true;
		for (i = 0 ; i < 256 ; i ++)
		{
			string1[i] = 0;	
			string2[i] = 0;
		}
		int temp1, temp2;
		for (n1 = 0 ; n1 < len1 ; n1 ++)
		{
			temp1 = str1.codePointAt(n1);
			string1[temp1]++;
		}
		for (n2 = 0 ; n2 < len2 ; n2 ++)
		{
			temp2 = str2.codePointAt(n2);
			string2[temp2]++;
		}
		for (i = 0 ; i < 256 ; i ++)
		{
			if (string1[i] != string2[i])
				a = false;
		}
		System.out.println(a);
	}
}

import java.util.Arrays;
import java.util.Comparator;

class Compare implements Comparator<String>{
	private String sortChars(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public int compare(String a, String b){
		a = sortChars(a);
		b = sortChars(b);
		return a.compareTo(b);
	}
}

public class Anagram{
	public static void main(String args[]){
		String[] strings = new String[5];
		strings[0] = "dog";
		strings[1] = "orchestra";
		strings[2] = "cat";
		strings[3] = "god";
		strings[4] = "carthorse";
//		Handle(strings);
		Sorting(strings);
		for(int i = 0 ; i < 5 ; i ++ ){
			System.out.println(strings[i]);
		}
	}

	public static void Handle(String[] strs){
		int n = strs.length;
		String[] s = new String[n];
		for(int i = 0 ; i < n ; i ++ ){
			s[i] = strs[i];
			char[] c = s[i].toCharArray();
			Arrays.sort(c);
			s[i] = new String(c);
		}
		Sort(strs, s, 0, n-1);
	}

	public static void Sorting(String[] str){
		Arrays.sort(str, new Compare());
	}

	public static void Sort(String[] str, String[] s, int start, int end){
		if(start > end){
			return;
		}
		String pivot = s[start];
		int i = start;
		int j = end;
		while(i <= j){
			while(i <= j && s[i].equals(pivot)){
				i++;
			}
			while(i <= j && !s[j].equals(pivot)){
				j--;
			}
			if(i <= j){
				String tmp = str[i];
				String t = s[i];
				str[i] = str[j];
				s[i] = s[j];
				str[j] = tmp;
				s[j] = t;
				i++;
				j--;
			}
		}
		if(i >= start && i <= end){
			Sort(str, s, i, end);
		}
	}
}

import java.util.Arrays;

public class FindString{
	public static void main(String args[]){
		String[] strings = {"art", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String s = args[0];
		int n = Find(strings, s);
		System.out.println(Arrays.toString(strings));
		System.out.println(n+" "+s);
	}

	public static int Find(String[] str, String s){
		int len = str.length;
		int res = Search(str, s, 0, len-1);
		return res;
	}

	public static int Search(String[] str, String s, int start, int end){
		while(start <= end){
			int mid = start + (end-start)/2;
			if (str[mid].isEmpty()){
				int left = mid-1;
				int right = mid+1;
				while(left >= start && str[left].isEmpty() && right <= end && str[right].isEmpty()){
					left--;
					right++;
				}

				if(left >= start && !str[left].isEmpty()){
					mid = left;
				}else if(right <= end && !str[right].isEmpty()){
					mid = right;
				}else{
					return -1;
				}
			}
			if (s.compareTo(str[mid]) < 0){
				end = mid-1;
			}else if(s.compareTo(str[mid]) > 0){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}

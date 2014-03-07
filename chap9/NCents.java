import java.util.ArrayList;
import java.util.Arrays;

public class NCents{
	public static void main(String args[]){
		String k = args[0];
		int n = Integer.parseInt(k);
		ArrayList<int[]> res = new ArrayList<int[]>();
		res = NumMethods(n, 4);
		System.out.println(n+"");
		for(int i  = 0 ; i < res.size(); i ++ ){
			int[] r = res.get(i);
			System.out.println(Arrays.toString(r));
		}
	}

	public static ArrayList<int[]> NumMethods(int total, int k){
		ArrayList<int[]> res = new ArrayList<int[]>();
		int step = 25;
		if(k == 4){
			step = 25;
		}
		if(k == 3){
			step = 10;
		}
		if(k == 2){
			step = 5;
		}
		if(k == 1){
			step = 1;
			int[] tmp = new int[1];
			tmp[0] = total;
			res.add(tmp);
			return res;
		}
		
		if(total == 0){
			return null;
		}


		for (int i = total/step ; i >= 0 ; i -= 1){
			ArrayList<int[]> tmp = new ArrayList<int[]>();
			tmp = NumMethods(total - step*i, k-1);
			if(tmp != null && tmp.size() > 0){
				for(int j = 0 ; j < tmp.size() ; j ++ ){
					int[] t = tmp.get(j);
					int[] arr = new int[k];
					for(int m = 0 ; m < t.length ; m ++ ){
						arr[m] = t[m];
					}
					arr[k-1] = i;
					res.add(arr);
				}
			}else{
				int arr[] = new int[k];
				arr[k-1] = i;
				for(int m = 0 ; m < k-1 ; m ++ ){
					arr[m] = 0;
				}
				res.add(arr);
			}
		}
		return res;
	}
}

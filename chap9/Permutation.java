import java.util.ArrayList;

public class Permutation{
	public static void main(String args[]){
		String str = args[0];
		ArrayList<String> res = new ArrayList<String>();
		res = getPermuts(str);
		for (int i = 0 ; i < res.size() ; i ++ ){
			System.out.println(res.get(i));
		}
		System.out.println(res.size() + "");
	}

	public static ArrayList<String> getPermuts(String str){
		ArrayList<String> res = new ArrayList<String>();
		if(str == null){
			return null;
		}else if(str.length() == 0 || str.length() == 1){
			res.add(str);
			return res;
		}else{
			char first = str.charAt(0);
			String sub = str.substring(1);
			ArrayList<String> pers = getPermuts(sub);
			for (String p : pers){
				for (int i = 0 ; i <= sub.length() ; i++ ){
					String s = insert(p, first, i);
					res.add(s);
				}
			}
			return res;
		}
	}

	public static String insert(String str, char c, int n){
		String former = str.substring(0,n);
		String latter = str.substring(n);
		return former+c+latter;
	}
}

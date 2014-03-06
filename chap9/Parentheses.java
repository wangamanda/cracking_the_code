import java.util.ArrayList;

public class Parentheses{
	public static void main(String args[]){
		String s = args[0];
		int n = Integer.parseInt(s);
		ArrayList<String> pa = getParentheses(new String(), n, n);
		for (int i = 0 ; i < pa.size() ; i ++ ){
			System.out.println(pa.get(i));
		}
	}

	public static ArrayList<String> getParentheses(String s, int left, int right){
		ArrayList<String> res = new ArrayList<String>();
		if(right == 0){
			res.add(s);
		}else if(left == 0) {
			for (int i = 0 ; i < right ; i ++ ){
				s += ")";
			}
			res.add(s);
		}else{
			if(left == right){
				s += "(";
				return getParentheses(s, left-1, right);
			}else{
				s += "(";
				ArrayList<String> r1 = getParentheses(s, left-1, right);
				for (String str : r1){
					res.add(str);
				}
				s = s.substring(0, s.length()-1);
				s += ")";
				ArrayList<String> r2 = getParentheses(s, left, right-1);
				for (String str : r2){
					res.add(str);
				}
			}
		}
		return res;
	}
}

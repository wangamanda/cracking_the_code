import java.util.HashMap;

public class CountParentheses{
	public static void main(String args[]){
		String s = "1^0|0|1";
		boolean b = true;
		HashMap<String, int> res = new HashMap<String, int>();
		int n = Count(s, b, 0, s.length()-1, res);
		System.out.println(n+"");
	}

	public static int Count(String exp, boolean bool, int start, int end, HashMap<String, int> map){
		String key = start+end+bool+"";
		if(map.contains(key)){
			return map.get(key);
		}
		int c = 0;
		for(int i = start+1 ; i < end ; i += 2){
			char op = exp.charAt(i);
			if(bool == true){
				if(op == '|')
			}
		}
	}
}

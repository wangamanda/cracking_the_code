import java.util.HashMap;

public class CountParentheses{
	public static void main(String args[]){
		String s = "1^0|0|1";
		boolean b = false;
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		int n = Count(s, b, 0, s.length()-1, res);
		System.out.println(n+"");
	}

	public static int Count(String exp, boolean bool, int start, int end, HashMap<String, Integer> map){//bool is the boolean value we expected from substring start to end
		String key = ""+start+end+bool;
		if(map.containsKey(key)){
			return map.get(key);
		}
		if(start == end){
			if(bool == true && exp.charAt(start) == '1'){
				return 1;
			}
			if(bool == false && exp.charAt(start) == '0'){
				return 1;
			}
			return 0;
		}
		int c = 0;
		for(int i = start+1 ; i < end ; i += 2){
			char op = exp.charAt(i);
			if(bool == true){
				if(op == '&'){
					c += Count(exp, true, start, i-1, map)*Count(exp, true, i+1, end, map);
				}else if(op == '|'){
					c += Count(exp, true, start, i-1, map)*Count(exp, false, i+1, end, map);
					c += Count(exp, false, start, i-1, map)*Count(exp, true, i+1, end, map);
					c += Count(exp, true, start, i-1, map)*Count(exp, true, i+1, end, map);
				}else if(op == '^'){
					c += Count(exp, true, start, i-1, map)*Count(exp, false, i+1, end, map);
					c += Count(exp, false, start, i-1, map)*Count(exp, true, i+1, end, map);
				}
			}else{
				if(op == '&'){
					c += Count(exp, false, start, i-1, map)*Count(exp, false, i+1, end, map);
					c += Count(exp, true, start, i-1, map)*Count(exp, false, i+1, end, map);
					c += Count(exp, false, start, i-1, map)*Count(exp, true, i+1, end, map);
				}else if(op == '|'){
					c += Count(exp, false, start, i-1, map)*Count(exp, false, i+1, end, map);
				}else if(op == '^'){
					c += Count(exp, true, start, i-1, map)*Count(exp, true, i+1, end, map);
					c += Count(exp, false, start, i-1, map)*Count(exp, false, i+1, end, map);
				}
			}
		}
		map.put(key, c);
		return c;
	}
}

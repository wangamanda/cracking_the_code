import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Queue;

public class OneDistanceWords{
	public static void main(String[] args){
		Set<String> dictionary = new TreeSet<String>();
		String[] words = {"abcde","abced","abcce","aeccd","abddd","acebd","abdde","abdce","bbdec","bacef"};
		for(String word : words){
			dictionary.add(word);
		}

		String start = "abcde";
		String end = "abddd";
		LinkedList<String> res = getWords(start, end, dictionary);
		System.out.println(res);
	}

	public static LinkedList<String> getWords(String start, String end, Set<String> dictionary){
		Queue<String> openList = new LinkedList<String>();
		Set<String> closeList = new TreeSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>();
		
		openList.add(start);
		closeList.add(start);
		while(!openList.isEmpty()){
			String w = openList.poll();
			ArrayList<String> neighbors = getNeighbors(w);
			for(String s : neighbors){
				if(s.equals(end)){
					LinkedList<String> res = new LinkedList<String>();
					res.add(s);
					while(w != null){
						res.add(0, w);
						w = backtrackMap.get(w);
					}
					return res;
				}else{
					if(dictionary.contains(s) && !closeList.contains(s)){
						openList.add(s);
						closeList.add(s);
						backtrackMap.put(s, w);
					}
				}
			}
		}

		return null;
	}

	public static ArrayList<String> getNeighbors(String s){
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0 ; i < s.length() ; i ++ ){
			char[] words = s.toCharArray();
			for(char c = 'a' ; c <= 'z' ; c ++ ){
				if(c != s.charAt(i)){
					words[i] = c;
					res.add(new String(words));
				}
			}
		}
		return res;
	}
}

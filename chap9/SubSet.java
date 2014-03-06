import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class SubSet{

	public static void main(String args[]){
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0 ; i < 10 ; i ++ ){
			set.add(i);
		}
		ArrayList<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();
		FindSubsets(set, subsets);
		System.out.println("Number of subsets: "+subsets.size());
	}

	public static void FindSubsets (Set<Integer> set, ArrayList<HashSet<Integer>> subsets){
		HashSet<Integer> t = new HashSet<Integer>();
		subsets.add(t);
		for (Integer i : set){
			int n = subsets.size();
			for (int j = 0 ; j < n ; j ++ ){
				HashSet<Integer> tmp = subsets.get(j);
				HashSet<Integer> ntmp = new HashSet<Integer>();
				for (Integer k : tmp){
					ntmp.add(k);
				}
				ntmp.add(i);
				subsets.add(ntmp);
			}
		}
	}
}

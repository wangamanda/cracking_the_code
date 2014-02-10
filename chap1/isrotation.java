public class isrotation{

	public static void main(String args[]){
	
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String s3 = "ttlewaterb";
		
		System.out.println("String s1: "+s1);
		System.out.println("String s2: "+s2);
		System.out.println("String s3: "+s3);

		if (isrotation(s1,s2)){
			System.out.println("String s1 is rotation of s2.");
		}else{
			System.out.println("String s1 is not rotation of s2.");
		}
		if (isrotation(s1,s3)){
			System.out.println("String s1 is rotation of s3.");
		}else{
			System.out.println("String s1 is not rotation of s3.");
		}

	}

	public static boolean isrotation(String s1, String s2){
	
		if (s1.length() != s2.length()){
			return false;
		}

		String s = s1+s1;
		if (isSubstring(s2,s)){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isSubstring(String sub, String s){
	
		if (s.contains(sub)){
			return true;
		}else{
			return false;
		}
	}
}

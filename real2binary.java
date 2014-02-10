public class real2binary{

	public static void main(String args[]){
	
		double a = 0.25;
		System.out.println(a);

		String s = realbinary(a);
		System.out.println(s);
	}

	public static String realbinary(double m){
	
		if (m >= 1 | m <= 0){
			return ("ERROR");
		}

		int cnt = 0;
		StringBuilder result = new StringBuilder();
		result.append(".");
		
		while (m > 0){
		
			if(cnt >= 32){
				return "ERROR";
			}

			double r = m * 2;
			if (r >= 1){
				result.append("1");
				cnt ++ ;
				m = r - 1;
			} else {
				result.append("0");
				cnt ++ ;
				m = r;
			}
		}
		
		return result.toString();
	}
}

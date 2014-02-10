public class DoubletoBinary{

	public static void main(String args[]){
		
		double a = 0.75;

		String s = toBinary(a);
		System.out.println("The double "+Double.toString(a)+" equals to binary: "+s);
	}

	public static String toBinary(double a){
	
		StringBuilder s = new StringBuilder();
		s.append(".");
		int n = 32;

		while(a != 0){
			a = a*2;
			if(a >= 1){
				a = a - 1;
				s.append(1);
			}else{
				s.append(0);
			}
			n--;
			if(n == 0){
				s = new StringBuilder();
				s.append("ERROR");
				break;
			}
		}

		return s.toString();
	}
}

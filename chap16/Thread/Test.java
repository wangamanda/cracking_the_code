package Thread;

import java.lang.Thread;

public class Test{
	public static void main(String[] args){
		NewThread n1 = new NewThread();
		n1.start();
		try{
			while(n1.count < 5){
				Thread.sleep(250);
			}
		}catch(InterruptedException exp){
			exp.printStackTrace();
		}
	}
}

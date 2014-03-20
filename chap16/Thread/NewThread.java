package Thread;

import java.lang.Thread;

public class NewThread extends Thread{
	public int count = 0;
	public void run(){
		try{
			while(count < 5){
				Thread.sleep(500);
				count ++ ;
			}
		}catch(InterruptedException exp){
			System.out.println("interrupted exception.");
		}
	}
}


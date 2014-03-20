import java.lang.Runnable;

public class RunnableThread implements Runnable{
	static int count = 0;
	public void run(){
		try{
			while(count < 5){
				Thread.sleep(500);
				count++;
			}
		}catch(InterruptedException exp){
			System.out.println("interrupted exception.");
		}
	}

	public static void main(String[] args){
		RunnableThread instance = new RunnableThread();
		Thread thread = new Thread(instance);
		thread.start();
		try{
			while(count < 5){
				Thread.sleep(250);
			}
		}catch(InterruptedException exp){
			exp.printStackTrace();
		}
	}
}

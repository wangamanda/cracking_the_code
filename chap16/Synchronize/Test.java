package Synchronize;

import java.lang.Thread;

public class Test{
	public static void main(String[] args){
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		MyThread t1 = new MyThread("1", obj1);
		MyThread t2 = new MyThread("2", obj2);
		t1.start();
		t2.start();

		try{
			System.out.println("main thread");
			Thread.sleep(3000);
		}catch(InterruptedException exp){
			exp.printStackTrace();
		}
	}
}

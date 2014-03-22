package Synchronize;

public class MyObject{

	public static synchronized void foo(String a){
		try{
			System.out.println("Thread "+a+" foo() start;");
			Thread.sleep(100);
			System.out.println("Thread "+a+" foo() end.");
		}catch(InterruptedException exp){
			System.out.println("Thread "+a+" foo() interrupted exception.");
		}
	}

	public static synchronized void bar(String a){
		try{
			System.out.println("Thread "+a+" bar() start;");
			Thread.sleep(100);
			System.out.println("Thread "+a+" bar() end.");
		}catch(InterruptedException exp){
			System.out.println("Thread "+a+" bar() interrupted exception.");
		}
	}
}

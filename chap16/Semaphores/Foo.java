package Semaphores;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Foo{

	public Semaphore sem1;
	public Semaphore sem2;
	public Semaphore sem3;
	public int pauseTime = 1000;

	public Foo(){
		try{
			sem1 = new Semaphore(1);
			sem2 = new Semaphore(1);
			sem3 = new Semaphore(1);
			sem1.acquire();
			sem2.acquire();
			sem3.acquire();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void First(){
		try{
			System.out.println("First starts");
			Thread.sleep(pauseTime);
			System.out.println("First ends");
			sem1.release();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void Second(){
		try{
			sem1.acquire();
			sem1.release();
			System.out.println("Second starts");
			Thread.sleep(pauseTime);
			System.out.println("Second ends");
			sem2.release();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void Third(){
		try{
			sem2.acquire();
			sem2.release();
			System.out.println("Third starts");
			Thread.sleep(pauseTime);
			System.out.println("Third ends");
			sem3.release();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

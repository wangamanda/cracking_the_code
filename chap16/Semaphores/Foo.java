package Semaphores;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Foo{

	public Foo(){
		try{
			Semaphore sem1 = new Semaphore(1);
			Semaphore sem2 = new Semaphore(1);
			Semaphore sem3 = new Semaphore(1);
			sem1.aquire();
			sem2.aquire();
			sem3.aquire();
		}catch(Exception ex){
			return ex.printStackTrace();
		}
	}
}

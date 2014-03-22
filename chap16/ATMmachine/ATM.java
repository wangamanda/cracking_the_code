package ATMmachine;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM{
	private int balance = 1000;
	private Lock lock;

	public ATM(){
		lock = new ReentrantLock();
	}

	public int getBalance(){
		return balance;
	}

	public int withdraw(int amount){
		lock.lock();
		try{
			balance -= amount;
			Thread.sleep(200);
		}catch(InterruptedException exp){
			System.out.println("Interruption exception during withdraw");
		}
		lock.unlock();
		return balance;
	}

	public int deposit(int amount){
		lock.lock();
		try{
			balance += amount;
			Thread.sleep(200);
		}catch(InterruptedException exp){
			System.out.println("Interruption exception during deposit");
		}
		lock.unlock();
		return balance;
	}

}

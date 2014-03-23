package Philosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class chopstick{
	Lock lock;
	public chopstick(){
		lock = new ReentrantLock();
	}

	public boolean pickup(){
		return lock.tryLock();
	}

	public boolean putdown(){
		if(pickup()){
			lock.unlock();
			return true;
		}
		return false;
	}
}

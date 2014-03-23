package Philosopher;

import java.lang.Thread;

public class philosopher{
	private chopstick left;
	private chopstick right;
	
	public philosopher(chopstick l, chopstick r){
		left = l;
		right = r;
	}

	public boolean pickup(){
		if(left.pickup() && right.pickup()){
			return true;
		}else{
			if(left.pickup() && !right.pickup()){
				return left.putdown();
			}
			if(!left.pickup() && right.pickup()){
				return right.putdown();
			}
			return false;
		}
	}

	public boolean eat(){
		if(pickup()){
			chew();
			return putdown();
		}
		return false;
	}

	public boolean putdown(){
		if(pickup()){
			return right.putdown() && left.putdown();
		}
		return false;
	}

	public void chew(){
		try{
			Thread.sleep(100);
		}catch(InterruptedException exp){

		}
	}
}

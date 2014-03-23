package Philosopher;

public class Test{
	public static void main(String[] args){
		chopstick c1 = new chopstick();
		chopstick c2 = new chopstick();
		philosopher p = new philosopher(c1, c2);
	}
}

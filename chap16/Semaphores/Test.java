package Semaphores;

public class Test{
	public static Foo foo = new Foo();
	public static String str;

	public static void main(String[] args){
		MyThread thread1 = new MyThread("first", foo);
		MyThread thread2 = new MyThread("second", foo);
		MyThread thread3 = new MyThread("third", foo);

		thread1.start();
		thread2.start();
		thread3.start();

		try{
			foo.sem3.acquire();
		}catch(Exception ex){
			ex.printStackTrace();
		}

		foo.sem3.release();
	}
}

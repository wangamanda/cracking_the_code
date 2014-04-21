package Semaphores;

public class MyThread extends Thread{
	String str;
	public static Foo foo;

	public MyThread(String s, Foo f){
		str = s;
		foo = f;
	}

	public void run(){
		if(str == "first"){
			foo.First();
		}else if(str == "second"){
			foo.Second();
		}else if(str == "third"){
			foo.Third();
		}
	}	
}

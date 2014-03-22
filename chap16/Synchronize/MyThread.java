package Synchronize;

import java.lang.Thread;

public class MyThread extends Thread{
	String name;
	MyObject obj;

	public MyThread(String n, MyObject o){
		name = n;
		obj = o;
	}

	public void run(){
		if(name == "1"){
			MyObject.foo(name);
		}else{
			MyObject.bar(name);
		}
	}
}

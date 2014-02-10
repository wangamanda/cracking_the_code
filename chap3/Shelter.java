package chap3;

import java.util.LinkedList;
import java.util.Random;

class Animal{
	private String name;
	private Animal nextAnimal;
	private Animal prevAnimal;

	public Animal(){
		name = new String();
		nextAnimal = null;
		prevAnimal = null;
		
	}

	public Animal(String a){
		name = a;
		nextAnimal = null;
		prevAnimal = null;
	}

	public String getName(){
		return name;
	}

	public Animal getNext(){
		return nextAnimal;
	}

	public Animal getPrev(){
		return prevAnimal;
	}

	public void setNext(Animal a){
		nextAnimal = a;
	}

	public void setPrev(Animal a){
		prevAnimal = a;
	}
}

class Cat extends Animal{
	private String name;
	private Cat nextCat;
	private Cat prevCat;
	private Animal prevAnimal;
	private Animal nextAnimal;

	public Cat(){
		name = new String();
		nextAnimal = null;
		prevAnimal = null;
		prevCat = null;
		nextCat = null;
	}

	public Cat(String c){
		name = c;
		nextAnimal = null;
		prevAnimal = null;
		prevCat = null;
		nextCat = null;
	}

	public Cat getNextCat(){
		return nextCat;
	}

	public Cat getPrevCat(){
		return prevCat;
	}

	public void setNextCat(Cat c){
		nextCat = c;
	}

	public void setPrevCat(Cat c){
		prevCat = c;
	}
}

class Dog extends Animal{
	private String name;
	private Dog nextDog;
	private Dog prevDog;
	private Animal prevAnimal;
	private Animal nextAnimal;

	public Dog(){
		name = new String();
		nextAnimal = null;
		prevAnimal = null;
		prevDog = null;
		nextDog = null;
	}

	public Dog(String c){
		name = c;
		nextAnimal = null;
		prevAnimal = null;
		prevDog = null;
		nextDog = null;
	}

	public Dog getNextDog(){
		return nextDog;
	}

	public Dog getPrevDog(){
		return prevDog;
	}

	public void setNextDog(Dog c){
		nextDog = c;
	}

	public void setPrevDog(Dog c){
		prevDog = c;
	}
}

public class Shelter{
	public LinkedList<Animal> l;
	public Animal Ahead;
	public Animal Atail;
	public Cat Chead;
	public Cat Ctail;
	public Dog Dhead;
	public Dog Dtail;

	public Shelter(){
		l = new LinkedList<Animal>();
		Ahead = null;
		Atail = null;
		Chead = null;
		Ctail = null;
		Dhead = null;
		Dtail = null;
	}

	public Shelter(Animal a){
		this();
		l.addFirst(a);
		Ahead = a;
		Atail = a;
		if (a instanceof Cat){
			Cat c = (Cat)a;
			Chead = c;
			Ctail = c;
		}else{
			Dog d = (Dog)a;
			Dhead = d;
			Dtail = d;
		}
	}

	public Animal getHead(){
		return Ahead;
	}

	public Animal getTail(){
		return Atail;
	}

	public void setHead(Animal a){
		Ahead = a;
	}

	public void setTail(Animal a){
		Atail = a;
	}

	public Cat getCatHead(){
		return Chead;
	}

	public Cat getCatTail(){
		return Ctail;
	}

	public void setCatHead(Cat c){
		Chead = c;
	}

	public void setCatTail(Cat c){
		Ctail = c;
	}

	public Dog getDogHead(){
		return Dhead;
	}

	public Dog getDogTail(){
		return Dtail;
	}

	public void setDogHead(Dog d){
		Dhead = d;
	}

	public void setDogTail(Dog d){
		Dtail = d;
	}

	public void Enqueue(Animal a){
		if(getHead() != null){
			Ahead.setPrev(a);
		}
		a.setNext(Ahead);
		setHead(a);
		l.addFirst(a);
		if (getTail() == null){
			setTail(a);
		}
		if (a instanceof Cat){
			Cat c = (Cat)a;
			if (getCatHead() != null){
				Chead.setPrev(c);
			}
			c.setNextCat(Chead);
			setCatHead(c);
			if (getCatTail() == null){
				setCatTail(c);
			}
		}else{
			Dog d = (Dog)a;
			if (getDogHead() != null){
				Dhead.setPrev(d);
			}
			d.setNextDog(Dhead);
			setDogHead(d);
			if (getDogTail() == null){
				setDogTail(d);
			}
		}
	}

	public Animal DequeueAny(){
		if (getTail() == null){
			return null;
		}
		Animal a = l.removeLast();
		Animal p = a.getPrev();
		setTail(p);
		if (p == null){
			setHead(p);
		}
		p.setNext(null);
		return a;
	}

	public Animal DequeueCat(){
		if (getCatTail() == null){
			return null;
		}
		Cat c = getCatTail();
		Cat p = c.getPrevCat();
		boolean b = l.removeLastOccurrence((Object)(Animal)c);
		setCatTail(p);
		if (p == null){
			setCatHead(p);
		}
		p.setNextCat(null);
		return (b==true)?(Animal)c:null;
	}

	public Animal DequeueDog(){
		if (getDogTail() == null){
			return null;
		}
		Dog c = getDogTail();
		Dog p = c.getPrevDog();
		boolean b = l.removeLastOccurrence((Object)(Animal)c);
		setDogTail(p);
		if (p == null){
			setDogHead(p);
		}
		p.setNextDog(null);
		return (b==true)?(Animal)c:null;
	}

	public static void main(String args[]){
		Shelter s = new Shelter();
		Random r = new Random();
		for (int i = 0 ; i < 10 ; i ++ ){	
			int t1 = r.nextInt(1000);
			String name1 = String.valueOf(t1);
			Cat c = new Cat(name1);
			s.Enqueue(c);
			int t2 = r.nextInt(1000);
			String name2 = String.valueOf(t2);
			Dog d = new Dog(name2);
			s.Enqueue(d);
		}
		System.out.println(s.toString());
		/*
		for (int i = 0 ; i < 5 ; i ++ ){
			s.DequeueAny();
			s.DequeueCat();
			s.DequeueDog();
			System.out.println(s.toString());
		}
		*/
	}
}

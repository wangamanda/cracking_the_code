package chap3;

import java.util.LinkedList;

class Animal{

	protected String name;
	protected int order;

	public Animal(){
	}

	public Animal(String a){
		name = a;
		order = 0;
	}

	public void setOrder(int o){
		order = o;
	}

	public int getOrder(){
		return order;
	}
	
	public String getName(){
		return name;
	}
}

class Dog extends Animal{

	public Dog(){
	}

	public Dog(String a){
		super(a);
	}
}

class Cat extends Animal{

	public Cat(){
	}

	public Cat(String a){
		super(a);
	}
}

public class ShelterAnimal{

	LinkedList<Animal> cats;
	LinkedList<Animal> dogs;


	public ShelterAnimal(){
	
		cats = new LinkedList<Animal>();
		dogs = new LinkedList<Animal>();
	}

	public void Enqueue(Animal a){
		int n1;
		int n2;

		if (cats.size() == 0){
			n1 = 0;
		}else{
			n1 = cats.getFirst().getOrder();
		}

		if (dogs.size() == 0){
			n2 = 0;
		}else{
			n2 = dogs.getFirst().getOrder();
		}
		
		int n;
		n = (n1 > n2)? n1:n2;
		a.setOrder(n+1);
		if(a instanceof Cat){
			cats.addFirst(a);

		}else{
			dogs.addFirst(a);
		}
	}	

	public Animal DequeueCat(){
		Animal a = cats.pollLast();
		return a;
	}

	public Animal DequeueDog(){
		Animal a = dogs.pollLast();
		return a;
	}

	public Animal DequeueAny(){
		Animal a;
		int n1;
		int n2;

		if (cats.size() == 0){
			n1 = 0;
		}else{
			n1 = cats.getLast().getOrder();
		}

		if (dogs.size() == 0){
			n2 = 0;
		}else{
			n2 = dogs.getLast().getOrder();
		}

		if (n1 == 0 && n2 == 0){
			return null;
		}
		if (n1 < n2){
			a = cats.pollLast();
		}else{
			a = dogs.pollLast();
		}

		return a;
	}

	public static void main(String args[]){
		ShelterAnimal sa = new ShelterAnimal();
		Cat c = new Cat("Cat1");
		sa.Enqueue(c);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		Dog d = new Dog("Dog1");
		sa.Enqueue(d);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		c = new Cat("Cat2");
		sa.Enqueue(c);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		c = new Cat("Cat3");
		sa.Enqueue(c);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		d = new Dog("Dog2");
		sa.Enqueue(d);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		c = new Cat("Cat4");
		sa.Enqueue(c);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		d = new Dog("Dog3");
		sa.Enqueue(d);
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		System.out.println("After Enqueue a cat, a dog, 2 cats, a dog, a cat and a dog");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		sa.DequeueAny();
		System.out.println("After Dequeue an animal, a dog and a cat:");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		sa.DequeueCat();
		System.out.println("After Dequeue an animal, a dog and a cat:");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		sa.DequeueDog();
		System.out.println("After Dequeue an animal, a dog and a cat:");
		for (Animal o : sa.cats){
			System.out.println(o.getName()+" "+o.getOrder());
		}
		for (Animal o : sa.dogs){
			System.out.println(o.getName()+" "+o.getOrder());
		}
	}
}

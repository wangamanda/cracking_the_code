import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person{
	private int Hgt;
	private int Wgt;
	public static Comparator<Person> compareHgt = new ByHgt();
	public static Comparator<Person> compareWgt = new ByWgt();
	public Person(int h, int w){
		Hgt = h;
		Wgt = w;
	}

	public int getHgt(){
		return Hgt;
	}

	public int getWgt(){
		return Wgt;
	}

	private static class ByHgt implements Comparator<Person>{
		public int compare(Person p1, Person p2){
			return p1.getHgt() - p2.getHgt();
		}
	}

	private static class ByWgt implements Comparator<Person>{
		public int compare(Person p1, Person p2){
			return p1.getWgt() - p2.getWgt();
		}
	}
}

public class PersonTower{
	public static void main(String args[]){
		ArrayList<Person> arr = new ArrayList<Person>();
		Person p1 = new Person(65, 100);
		arr.add(p1);
		Person p2 = new Person(70, 150);
		arr.add(p2);
		Person p3 = new Person(56, 90);
		arr.add(p3);
		Person p4 = new Person(75, 190);
		arr.add(p4);
		Person p5 = new Person(60, 95);
		arr.add(p5);
		Person p6 = new Person(68, 110);
		arr.add(p6);
		Collections.sort(arr, Person.compareHgt);
//		Collections.sort(arr, Person.compareWgt);
		
	}
}

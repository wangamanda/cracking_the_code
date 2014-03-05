package Hashtab;

import java.util.LinkedList;

public class Hash<K, V>{
	private final int Size = 100;
	private LinkedList<Element<K, V>>[] list;

	public Hash(){
		list = (LinkedList<Element<K, V>>[]) new LinkedList[Size];
	}

	public int getHashCode(K k){
		return k.toString().length();
	}

	public void put(Element<K, V> e){
		int x = getHashCode(e.getKey());
		LinkedList<Element<K, V>> l = list[x];
		if(l == null){
			l = new LinkedList<Element<K, V>>();
			list[x] = l;
		}
		for (Element<K, V> ele : l){
			if(ele.equals(l)){
				l.remove(ele);
				break;
			}
		}
		l.add(e);
	}

	public V get(K key){
		int x = getHashCode(key);
		LinkedList<Element<K, V>> l = list[x];
		if(l == null){
			return null;
		}
		for(Element<K, V> e : l){
			if(e.isEqual(key)){
				return e.getValue();
			}
		}
		return null;
	}
}

package Hashtab;

public class Element<K, V>{
	private K key;
	private V value;

	public Element(K k, V v){
		key = k;
		value = v;
	}

	public K getKey(){
		return key;
	}

	public V getValue(){
		return value;
	}
	
	public boolean equals(Element<K, V> e){
		return e.getKey().equals(key);
	}

	public boolean isEqual(K k){
		return key.equals(k);
	}
}

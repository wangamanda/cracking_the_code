public class CircularArray<T>{
	T[] items;
	int head = 0;

	public CircularArray(int n){
		items = (T[]) new Object[n];
	}

	public int convert(int n){
		while(n < 0){
			n += items.length;
		}
		return (n + head)%(items.length);
	}

	public T get(int n){
		return items[convert(n)];
	}

	public void set(int n, T t){
		items[convert(n)] = t;
	}
}

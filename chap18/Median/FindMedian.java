package Median;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Comparator;
import java.util.Arrays;

public class FindMedian{

	public static PriorityQueue<Integer> maxHeap;
	public static PriorityQueue<Integer> minHeap;
	public static void main(String[] args){
		int N = 11;
		int[] arr = new int[N];
		MaxHeapComparator maxComparator = new MaxHeapComparator();
		MinHeapComparator minComparator = new MinHeapComparator();
		maxHeap = new PriorityQueue<Integer>(N-N/2, maxComparator);
		minHeap = new PriorityQueue<Integer>(N/2, minComparator);
		Random r = new Random();

		for(int i = 0 ; i < N ; i ++ ){
			int n = r.nextInt(100);
			insert(n);
			arr[i] = n;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int res = getMedian();
		System.out.println(res+"");
	}

	public static void insert(int n){
		if(maxHeap.size() == minHeap.size()){
			if(maxHeap.size() == 0){
				maxHeap.offer(n);
			}else{
				if(n > maxHeap.peek()){
					maxHeap.offer(minHeap.poll());
					minHeap.offer(n);
				}else{
					maxHeap.offer(n);
				}
			}
		}else{
			if(n < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(n);
			}else{
				minHeap.offer(n);
			}
		}
	}

	public static int getMedian(){
		if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}else{
			return (maxHeap.peek()+minHeap.peek())/2;
		}
	}
}

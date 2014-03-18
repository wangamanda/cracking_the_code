import java.io.*;
import java.util.Scanner;

public class IntegersInFile{
	public static void main(String[] args) throws FileNotFoundException{//this exception need to be reported
		long NumberOfInt = (long)Integer.MAX_VALUE+1;
		byte[] numbers = new byte[(int)NumberOfInt/8];//long need to be changed to int as array subindex
		int res = 0;

		Scanner scan = new Scanner(new FileReader("abc.txt"));//FileReader in java.io, exception needs report
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			numbers[n/8] |= 1 << (n%8);
		}

		for(int i = 0 ; i < numbers.length ; i ++ ){
			for(int j = 0 ; j < 8 ; j ++ ){
				if((numbers[i] & (1 << j)) == 0){
					res = 8*i + j;
				}
			}
		}
	}

	public static void FindMissingInt() throws FileNotFoundException{
		int RangeSize = 1024*1024;
		int RangeNum = 2048;
		byte[] bits = new byte[RangeSize / 8];
		int[] blocks = new int[RangeNum];

		Scanner scan = new Scanner(new FileReader("abc.txt"));
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			blocks[n/RangeSize] += 1;
		}

		//find which block an missing number is in
		int start = -1;
		for(int i = 0 ; i < blocks.length ; i ++ ){
			if(blocks[i] < RangeSize){
				start = i * RangeSize;
				break;
			}
		}

		//scan all over again and fill the block we found before with only the numbers within the range
		scan = new Scanner(new FileReader("abc.txt"));
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			if(n >= start && n < start + RangeSize){
				n -= start;
				bits[n/8] |= (byte)(1 << (n%8));
			}
		}

		//find in the block which bit is 0, that is the missing number
		for(int i = 0 ; i < RangeSize/8 ; i ++ ){
			for(int j = 0 ; j < 8 ; j ++ ){
				if((bits[i] & (1 << j)) == 0){
					System.out.println(i*8+j+start);
					break;
				}
			}
		}
	}
}

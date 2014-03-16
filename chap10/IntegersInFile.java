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
}

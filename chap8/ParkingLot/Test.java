package ParkingLot;

import java.util.Random;

public class Test{
	public static void main(String args[]){
		ParkingLot lot = new ParkingLot();

		Vehicle v = null;
		for (int i = 0 ; i < 20 ; i ++ ){
			Random rr = new Random();
			int r = rr.nextInt(10);
			if (r < 2){
				v  = new Bus();
			}else if (r < 4){
				v = new Car();
			}else{
				v = new Motorcycle();
			}
			lot.parkVehicle(v);
		}
	}
}

package ParkingLot;

public class Bus extends Vehicle{
	public Bus(){
		vehicleSize = VehicleSize.Large;
		int spotsNum = 5;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		return this.vehicleSize == spot.getSize();
	}
}

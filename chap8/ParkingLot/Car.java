package ParkingLot;

public class Car extends Vehicle{
	public Car(){
		vehicleSize = VehicleSize.Compact;
		spotsNum = 1;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		return this.vehicleSize == spot.getSize() || spot.getSize() == VehicleSize.Large;
	}
}

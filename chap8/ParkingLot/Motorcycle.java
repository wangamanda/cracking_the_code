package ParkingLot;

public class Motorcycle extends Vehicle{
	public Motorcycle(){
		spotsNum = 1;
		vehicleSize = VehicleSize.Motorcycle;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		VehicleSize vs = spot.getSize();
		return vs == VehicleSize.Motorcycle || vs == VehicleSize.Compact || vs == VehicleSize.Large;
	}
}

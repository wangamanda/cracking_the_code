package ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle{
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String LicensePlate;
	protected VehicleSize vehicleSize;
	protected int spotsNum;//number of spots needed to park the vehicle

	public int getSpotsNeeded(){
		return spotsNum;
	}

	public VehicleSize getSize(){
		return vehicleSize;
	}

	public void parkInSpot(ParkingSpot ps){
		parkingSpots.add(ps);
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);

	public void clearSpots(){
		for (int i = 0 ; i < parkingSpots.size() ; i ++ ){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}
}

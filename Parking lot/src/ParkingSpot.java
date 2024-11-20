import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class ParkingSpot {
    private final int spotNo;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNo, VehicleType vehicleType) {
        this.spotNo = spotNo;
        this.vehicleType = vehicleType;
    }

    public int getSpotNo() {
        return this.spotNo;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }


    public synchronized void park(Vehicle vehicle) {
        if(isAvailable() && vehicle.getVehicleType() == vehicleType) {
            parkedVehicle = vehicle;
        }  else {
            throw new IllegalArgumentException("Parking spot unavailable or wrong vehicle type");
        }
    }

    public synchronized void unpark(Vehicle vehicle) {
        parkedVehicle = null;
    }
}

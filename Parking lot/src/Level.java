import Vehicle.Vehicle;
import Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int numSpots, int floor) {
        this.floor = floor;
        parkingSpots = new ArrayList<>();

        int numBikes = numSpots * 50;
        int numCars = numSpots * 40;

        for(int i = 0; i <= numBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }

        for(int i = numBikes + 1; i <= numCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i = numBikes + numCars + 1; i < numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean park(Vehicle vehicle) {
        for(ParkingSpot spot: parkingSpots) {
            if(spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.park(vehicle);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle) {
        for(ParkingSpot spot: parkingSpots) {
            if(spot.getParkedVehicle().equals(vehicle)) {
                spot.park(vehicle);
                return true;
            }
        }

        return false;
    }


    public void getAvailabiliy() {
        System.out.println("Level number " + floor);
        for(ParkingSpot spot: parkingSpots) {
            System.out.println("Spot " + spot.getSpotNo() + (spot.isAvailable() ? " is available for " : " is occupied by ") + spot.getVehicleType());
        }
    }
}

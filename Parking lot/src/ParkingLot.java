import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Level> levels;
    private static ParkingLot instance;


    public ParkingLot() {
        levels = new ArrayList<>();
    }


    public void addLevel(Level level) {
        levels.add(level);
    }

    public static synchronized ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public synchronized boolean park(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.unpark(vehicle)) {
                return true;
            }
        }

        return false;
    }

    public void getAvailabilty() {
        for(Level level: levels) {
            level.getAvailabiliy();
        }
    }
}

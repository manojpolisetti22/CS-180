import java.util.ArrayList;

/**
 * Created by manojpolisetti on 22/10/15.
 */
public class VehicleManagement {
    private int bus;
    private int plane;
    private ArrayList<Vehicle> v = new ArrayList<>();

    public VehicleManagement(int bus, int plane) {
        this.bus = bus;
        this.plane = plane;
    }

    public boolean createRoute(Route route, int capacity) {
        if (getAvailableBus() > 0) {
            for (int i = 0; i < v.size(); i++) {
                if (route.equals(v.get(i).getRoute())) {
                    return false;
                }
            }
            Bus bus = new Bus(route, capacity);
            v.add(bus);
            return true;
        }
        return false;

    }

    public boolean addPassengerToVehicle(Passenger person) {

        if (person != null) {
            for (int i = 0; i < v.size(); i++) {
                int capacity = v.get(i).getCapacity();
                if (v.get(i).getRoute().equals(person.getRoute())) {
                    if (v.get(i) instanceof Bus) {
                        if (getAvailablePlane() > 0) {

                            v.get(i).addPassenger(person, true);
                            if (v.get(i).getCount() >= (2 * capacity)) {
                                if (v.get(i) instanceof Bus) {
                                    if (getAvailablePlane() > 0) {
                                        v.set(i, v.get(i).upgrade(3 * capacity));
                                        return true;
                                    }
                                }

                            }
                            return true;
                        } else {
                            return v.get(i).addPassenger(person, false);
                        }
                    } else return v.get(i).addPassenger(person);

                }
            }
            person.cancel();
            return false;
        }
        return false;
    }


    public Vehicle[] getVehicles() {
        Vehicle[] tmp = new Vehicle[v.size()];
        for (int i = 0; i < v.size(); i++) {
            tmp[i] = v.get(i);
        }
        return tmp;
    }

    public int getCount() {
        return v.size();
    }

    public int lookupVehicle(Route route) {
        int x = -1;
        for (int i = 0; i < v.size(); i++) {
            if (route.equals(v.get(i).getRoute())) {
                x = i;
                break;
            }
        }
        return x;
    }

    public int getAvailableBus() {
        int count = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) instanceof Bus) {
                count++;
            }
        }
        return this.bus - count;
    }

    public int getAvailablePlane() {
        int cot = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) instanceof Airplane) {
                cot++;
            }
        }
        return this.plane - cot;
    }

}

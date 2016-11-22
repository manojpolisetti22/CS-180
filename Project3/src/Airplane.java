import java.util.ArrayList;

/**
 * Created by manojpolisetti on 18/10/15.
 */
public class Airplane implements Vehicle {

    private Route route;
    private int capacity;
    private ArrayList<Passenger> p = new ArrayList<Passenger>();

    public Airplane(Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Route getRoute() {

        return this.route;
    }

    public int getCount() {
        return p.size();
    }

    public Passenger[] getPassengers() {
        Passenger[] sample = new Passenger[getCount()];
        for (int i = 0; i < getCount(); i++) {
            sample[i] = p.get(i);
        }
        return sample;
    }

    public boolean addPassenger(Passenger person, boolean waitingList) {
        if (person != null) {
            return addPassenger(person);
        }
        return false;
    }

    public boolean addPassenger(Passenger person) {
        if (person != null) {
            if (person.getRoute().equals(getRoute())) {
                if (getCapacity() - p.size() > 0) {
                    p.add(person);
                    person.confirm();
                    return true;
                }
                person.cancel();
                return false;
            } else {
                person.cancel();
                return false;
            }
        }
        return false;
    }

    public Vehicle upgrade(int capacity) {

        return null;
    }

}

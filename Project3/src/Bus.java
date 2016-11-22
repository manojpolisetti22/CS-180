import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by manojpolisetti on 12/10/15.
 */
public class Bus implements Vehicle {
    private Route route;
    private int capacity;
    private ArrayList<Passenger> p = new ArrayList<>();

    public Bus(Route route) {
        this.route = route;
        this.capacity = 2;
    }

    public Bus(Route route, int capacity) {
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
        /*int len = p.length;
        int nil = 0;
        for(int i = 0; i < len; i ++) {
            if(p[i] == null) {
                nil = i;
                break;
            }
        }
        */

        return p.size(); // or p.size();


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
            if (waitingList) {
                if (person.getRoute().equals(getRoute())) {
                    p.add(person);

                    if (getCapacity() - p.size() < 0) {
                        return true;
                    } else {
                        person.confirm();
                        return true;
                    }
                }
                person.cancel();
                return false;
            } else {
                if (person.getRoute().equals(getRoute())) {

                    if (getCapacity() - p.size() > 0) {
                        p.add(person);
                        person.confirm();
                        return true;
                    }
                    person.cancel();
                    return false;
                }
            }
            person.cancel();
            return false;
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
                p.add(person);
                return true;
            } else {
                person.cancel();
            }
            person.cancel();
            return false;
        }

        return false;
    }

    public Vehicle upgrade(int capacity) {
        Airplane a = new Airplane(this.getRoute(), capacity);
        for (int i = 0; i < p.size(); i++) {
            a.addPassenger(p.get(i));
        }
        return a;
    }
}

/**
 * Created by manojpolisetti on 16/10/15.
 */
public class Car {
    private int fuel;
    private int distance;

    public Car(int fuel) {
        this.fuel = fuel;
        this.distance = 0;
    }

    public void drive(int distance) throws InsufficientFuelException {


        if (fuel * 20 < distance) {
            throw new InsufficientFuelException("Fuel too low!");
        }
        else {
            this.fuel = (this.fuel * 20 - distance) / 20;
            this.distance += distance;
        }
    }
}

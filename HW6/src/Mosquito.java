/**
 * Created by manojpolisetti on 08/10/15.
 */
public class Mosquito implements Animal {
    public int numberOfLegs() {
        return 6;
    }
    public boolean canFly() {
        return true;
    }
    public String makeNoise() {
        return "Buzz!";
    }
}

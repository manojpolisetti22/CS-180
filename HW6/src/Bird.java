/**
 * Created by manojpolisetti on 08/10/15.
 */
public class Bird implements Animal {
    public int numberOfLegs() {
        return 2;
    }
    public boolean canFly() {
        return true;
    }
    public String makeNoise() {
        return "Caw!";
    }
}

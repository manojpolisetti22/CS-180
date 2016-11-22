/**
 * Created by manojpolisetti on 08/10/15.
 */
public class Dog implements Animal {
    public int numberOfLegs() {
        return 4;
    }
    public boolean canFly() {
        return false;
    }
    public String makeNoise() {
        return "Bark!";
    }
}

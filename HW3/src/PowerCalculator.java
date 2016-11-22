/**
 * Created by manojpolisetti on 11/09/15.
 */
public class PowerCalculator {
    public int power(int num, int exponent) {
        int i;
        int result = 1;
        for (i = 0; i < exponent; i++) {
            result = result * num;
        }
        return result;
    }
    public static void main(String[] args) {
        PowerCalculator p = new PowerCalculator();
        System.out.println(p.power(2, 2)); //prints "4"
        System.out.println(p.power(1, 10)); //prints "1"
        System.out.println(p.power(5, 3)); //prints "125"
    }
}

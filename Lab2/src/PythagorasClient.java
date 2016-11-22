/**
 * Created by manojpolisetti on 02/09/15.
 */
import java.util.Scanner;
public class PythagorasClient {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter side 1");
        int s1 = scan.nextInt();
        System.out.println("Enter side 2");
        int s2 = scan.nextInt();
        double result = p.getHypotenuse(s1, s2);
        System.out.println("The side 1 is = " + s1);
        System.out.println("The side 2 is = " + s2);
        System.out.println("The Hypotenuse is = " + result);
    }
}

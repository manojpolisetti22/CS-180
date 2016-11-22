/** CS 180 Home work 1 (Week 2)
 * The program adds 1 to the inputted number
 * Manoj Polisetti ; mpoliset@purdue.edu
 * Created by manojpolisetti on 30/08/15.
 */
import java.util.Scanner;
public class Adder {

    public int addOne(int num) {
        int num2 = num + 1;
        return num2;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        Adder add = new Adder();
        int num2 = add.addOne(num1);
    }
}

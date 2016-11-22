/** CS 180 Home Work 1 (week 2)
 * The program returns the sum, difference and product of two inputted numbers like a calculator
 * Manoj Polisetti; mpoliset@purdue,edu
 * Created by manojpolisetti on 30/08/15.
 */
import java.util.Scanner;
public class Calculator {
    public int add(int x, int y) {
        int sum = x + y;
        return sum;
    }
    public int sub(int num1, int num2) {
        int diff = num1 - num2;
        return diff;
    }
    public int mul(int num1, int num2) {
        int prod = num1 * num2;
        return prod;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator add = new Calculator();
        Calculator sub = new Calculator();
        Calculator mul = new Calculator();
        System.out.println("Enter two numbers");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(add.add(num1, num2));
        System.out.println(sub.sub(num1, num2));
        System.out.println(mul.mul(num1, num2));

    }
}

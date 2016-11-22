/**
 * Created by manojpolisetti on 22/09/15.
 */
import java.util.Scanner;
public class MathToolsClient {
    public static void main(String[] args) {
        String dec;
        do {
            MathTools mt = new MathTools();
            Scanner in = new Scanner(System.in);
            System.out.println("Select a number from the menu choices:");
            System.out.println("1 - Absolute Value");
            System.out.println("2 - Power");
            System.out.println("3 - Nth Root");
            System.out.println("4 - Scientific Notation");
            int menuResult = in.nextInt();
            if (menuResult > 3 || menuResult < 0) {
                System.out.println("Invalid Option");
                System.out.println("Return to main menu? (YES/NO)");
                String choic = in.nextLine();
                if (choic.equalsIgnoreCase("yes")) {
                    System.out.println("Enter again");
                    menuResult = in.nextInt();
                }

            }
            if (menuResult == 1) {
                System.out.println("******ABSOLUTE VALUE****");
                System.out.println("Enter the no.");
                double abVal = in.nextDouble();
                System.out.println("The Absolute Value is : " + mt.absoluteValue(abVal));

            }
            if (menuResult == 2) {
                System.out.println("*********POWER****");
                System.out.println("Enter the base!");
                double base = in.nextDouble();
                System.out.println("Enter the exponent");
                int exponent = in.nextInt();
                System.out.println("" + base + " ^ " + exponent + "= " + mt.power(base, exponent));

            }
            if (menuResult == 3) {
                System.out.println("**********Nth ROOT**********");
                System.out.println("Enter the Value");
                double value = in.nextDouble();
                System.out.println("Enter the root");
                int root = in.nextInt();
                System.out.println("" + value + " ^ " + root + "= " + mt.nthRoot(value, root));
            }

            if (menuResult == 4) {
                System.out.println("Enter the no.");
                double num = in.nextDouble();
                System.out.println("Your number in scientific notation is =" + mt.scientificNotation(num));
            }

            System.out.println("Do you want to return to the Main menu?(YES/NO");

            dec = in.next();


        } while(dec.equalsIgnoreCase("yes"));
    }

}

/*
import java.util.Scanner;

public class MathToolsClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MathTools mt = new MathTools();
        System.out.println("Select a number from the menu choices:");
        System.out.println("1 - Absolute Value");
        System.out.println("2 - Power");
        System.out.println("3 - Nth Root");
        System.out.println("4 - Scientific Notation");
        String repeat = "";
        int input = scan.nextInt();
        do {
            switch (input) {
                case 1:
                    System.out.println("**********ABSOULUTE VALUE!**********");
                    System.out.println("Enter the no. you want the absolute value of!");
                    int ab = scan.nextInt();
                    double abs = mt.absoluteValue(ab);
                    System.out.println("The Absolute value of your no." + ab + "is = "+ abs);
                    System.out.println("Return to the Menu? (yes/no)");
                    repeat = scan.nextLine();
                    break;
                case 2:
                    System.out.println("**********POWER**********");
                    System.out.println("Enter the no.");
                    double base = scan.nextDouble();
                    int exponent = scan.nextInt();
                    double result = mt.power(base, exponent);
                    System.out.println("The ");
                    System.out.println("Return to the Menu? (yes/no)");
                    repeat = scan.nextLine();
                    break;
                case 3:
                    System.out.println("Return to the Menu? (yes/no)");
                    repeat = scan.nextLine();
                    break;
                case 4:
                    System.out.println("Return to the Menu? (yes/no)");
                    repeat = scan.nextLine();
                    break;
                default:
                    System.out.println("Invalid Option");
                    System.out.println("Return to the Menu? (yes/no)");
                    repeat = scan.nextLine();
                    break;
            }
        }
        while (repeat.equalsIgnoreCase("yes"));

    }
}
*/
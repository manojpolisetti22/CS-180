/**
 * CCreated by meghnaatluri on 14/09/15.
 */
import java.util.Scanner;

public class FAFSAClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Have you been accepted into a degree or certificate program?");
        String first = scan.nextLine();
        boolean isAcceptedStudent;
        if (first.equalsIgnoreCase("yes")) {
            isAcceptedStudent = true;
        } else {
            isAcceptedStudent = false;
        }

        System.out.println("Are you registered for the selective service");
        String second = scan.nextLine();
        boolean isSSregistered;
        if (second.equalsIgnoreCase("yes")) {
            isSSregistered = true;
        } else {
            isSSregistered = false;
        }

        System.out.println("Do you have a social security number?");
        String third = scan.nextLine();
        boolean hasSSN;
        if (third.equalsIgnoreCase("yes")) {
            hasSSN = true;
        } else {
            hasSSN = false;
        }

        System.out.println("Do you have valid residency status?");
        String fourth= scan.nextLine();
        boolean hasValidResidency;
        if (fourth.equalsIgnoreCase("yes")) {
            hasValidResidency = true;
        } else {
            hasValidResidency = false;
        }

        System.out.println("How old are you?");
        int age ;
        age = scan.nextInt();

        System.out.println("How many credit hours do you plan on taking?");
        int creditHours;
        creditHours = scan.nextInt();

        System.out.println("What is your total yearly income?");
        double studentIncome ;
           studentIncome = scan.nextDouble();

        System.out.println("What is your parent's total yearly income?");
        double parentIncome ;
         parentIncome = scan.nextDouble();

        System.out.println("Are you a dependent?");
        String fifth= scan.nextLine();
        boolean isDependent;
        if(fifth.equalsIgnoreCase("yes")) {
            isDependent = true;
        } else {
            isDependent = false;
        }

        System.out.println("Are you an undergraduate or graduate?");
        String classStanding ;
          classStanding = scan.nextLine();





        FAFSA f = new FAFSA(isAcceptedStudent, isSSregistered, hasSSN, hasValidResidency, isDependent, age,
                creditHours, studentIncome, parentIncome, classStanding);
        System.out.println("Estimated total federal aid award: $" + f.calcFederalAidAmount());

    }


}


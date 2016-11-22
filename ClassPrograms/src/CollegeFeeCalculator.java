/**CS 180 Session13
 * The program calculates the fees accors=ding to student input using GUI
 * @Manoj Polisetti, mpoliset@purdue.edu
 * Created by mpoliset on 8/11/15.
 */
import javax.swing.JOptionPane;

public class CollegeFeeCalculator {

    public static void main(String[] args) {
        int again = 1;
        do {
            JOptionPane.showMessageDialog(null, "Welcome to CollegeFeeCalculator!", "CollegeFeeCalculator", JOptionPane.INFORMATION_MESSAGE);

            String name = JOptionPane.showInputDialog(null, " Please Enter your name, then Press OK", "Name", JOptionPane
                    .QUESTION_MESSAGE); // ASKS FOR THE NAME

            String selections[] = {"Full Time", "Part Time"}; // TAKES INPUT OF FULL TIME OR PART TIME USING OPTION
            // DIALOG
            String enroll = String.valueOf(JOptionPane.showOptionDialog(null,
                    "Please select your enrollment:",
                    "Enrollment",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, /* icon */
                    selections,
                    selections[0]));
            System.out.println(enroll);

            String cred = JOptionPane.showInputDialog(null, "Please enter the no. of credit hours, then press OK",
                    "Credit Hours", JOptionPane.QUESTION_MESSAGE);
            int credits = Integer.parseInt(cred); // INPUT OF THE NO. OF CREDITS

            if (credits >= 8 && enroll.equalsIgnoreCase("Part Time") || credits < 8 && enroll.equalsIgnoreCase("Full Time")) {
                String incorrectCreds = JOptionPane.showInputDialog(null, "Please enter valid credit hours for the current " +
                                "enrollment",
                        "Incorrect Credits", JOptionPane.ERROR_MESSAGE);
                int creds = Integer.parseInt(incorrectCreds); // EXCEPTION WHEN CREDITS DON'T MATCH
            }

            String residency[] = {"In-State", "Out of State", "International"};// CHECKS RESIDENCY
            String resResult = String.valueOf(JOptionPane.showInputDialog(null,
                    "Enter residency",
                    "Residency",
                    JOptionPane.DEFAULT_OPTION,
                    null,
                    residency,
                    residency[0]));
            System.out.println(resResult);

            String housingChoice[] = {"Off Campus", "On Campus"}; // CHECKS IF STAYING ON CAMPUS OR OFF CAMPUS
            String housingChoiceResult = String.valueOf(JOptionPane.showInputDialog(null,
                    "Choose Residence Hall",
                    "Residence Hall",
                    JOptionPane.DEFAULT_OPTION,
                    null,
                    housingChoice,
                    housingChoice[0]));


            String housingResult = ""; // RES HALL CONFIRMATION
            if (housingChoiceResult.equalsIgnoreCase("On Campus")) {
                String housing[] = {"Earhart", "Hillenbrand", "Owen", "Windsor"};
                housingResult = String.valueOf(JOptionPane.showInputDialog(null,
                        "Choose Residence Hall",
                        "Residence Hall",
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        housing,
                        housing[0]));
            }


            //Calculation of TUITION Fees
            int tuitionFee = 0;
            if (enroll.equalsIgnoreCase("0")) {

                if (resResult.equalsIgnoreCase("In-State")) {
                    tuitionFee += 4996;
                } else if (resResult.equalsIgnoreCase("Out of State")) {
                    tuitionFee += 9401 + 4996;
                } else if (resResult.equalsIgnoreCase("International")) {
                    tuitionFee += 1000 + 9401 + 4996;
                }
            } else if (enroll.equalsIgnoreCase("1")) {
                if (resResult.equalsIgnoreCase("In-State")) {
                    tuitionFee = (350 * credits);
                } else if (resResult.equalsIgnoreCase("Out of State")) {
                    tuitionFee = (600 + 350) * credits;
                } else if (resResult.equalsIgnoreCase("International")) {
                    tuitionFee = credits * (70 + 600 + 350);
                }
            }

            // Calculation of RES HALL Fees
            int housingExpense = 0;
            if (housingChoiceResult.equalsIgnoreCase("Off Campus")) {
                housingExpense = 0;
            } else if (housingChoiceResult.equalsIgnoreCase("On Campus")) {
                if (housingResult.equalsIgnoreCase("Earhart")) {
                    housingExpense = 4745;
                } else if (housingResult.equalsIgnoreCase("Hillenbrand")) {
                    housingExpense = 5307;
                } else if (housingResult.equalsIgnoreCase("Owen")) {
                    housingExpense = 4130;
                } else if (housingResult.equalsIgnoreCase("Windsor")) {
                    housingExpense = 4150;
                }
            }


            int totalFee = tuitionFee + housingExpense; // Total fee

            JOptionPane.showMessageDialog(null,name + "'s tuition fee is = " + totalFee, "Total fees", JOptionPane
                    .INFORMATION_MESSAGE);

            again = JOptionPane.showConfirmDialog(null, "Do you want to check again?", "ReCalculation"
                    , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null); // Checks if the person wants
                    // to check again
        }
        while (again == 0);

    }
}

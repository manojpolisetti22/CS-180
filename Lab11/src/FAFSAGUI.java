/**
 * Created by mpoliset on 11/4/15.
 */
import javax.swing.JOptionPane;
public class FAFSAGUI {
    public static void main(String[] args) {
        int x = 1;
        do {
            boolean isAcceptedStudent = true;
            boolean isSSregisered = true;
            boolean hasSSN = true;
            boolean hasValidResidency = true;
            boolean isDependant = true;
            JOptionPane.showMessageDialog(null, "Welcome to the FAFSA", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            int isAcceptedStudent1 = JOptionPane.showConfirmDialog(null, "Are you in a program?",
                    "Program " +
                            "acceptance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.NO_OPTION == isAcceptedStudent1) {
                isAcceptedStudent = false;
            }
            int isSSRegisered1 = JOptionPane.showConfirmDialog(null, "Are you registered for the selective service?",
                    "Selective service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.NO_OPTION == isSSRegisered1) {
                isSSregisered = false;
            }
            int hasSSN1 = JOptionPane.showConfirmDialog(null, "Do you have a Social Security Number?",
                    "Social Security Number", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.NO_OPTION == hasSSN1) {
                hasSSN = false;
            }
            int hasValidResidency1 = JOptionPane.showConfirmDialog(null, "Do you have a Valid Residency Status?",
                    "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.NO_OPTION == hasValidResidency1) {
                hasValidResidency = false;
            }

            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Age?", "AGE", JOptionPane
                    .QUESTION_MESSAGE));
            while (age < 1) {
                JOptionPane.showMessageDialog(null, "Age cannot be negative", "Error: Age", JOptionPane.ERROR_MESSAGE);
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Age?", "AGE", JOptionPane
                        .QUESTION_MESSAGE));
            }

            int creditHours = Integer.parseInt(JOptionPane.showInputDialog(null, "How many credits are you taking?",
                    "Credit Hours", JOptionPane.QUESTION_MESSAGE));

            while (creditHours < 1 || creditHours > 24) {
                JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24 inclusive", "Error: Credit " +
                                "hours",
                        JOptionPane
                                .ERROR_MESSAGE);

                creditHours = Integer.parseInt(JOptionPane.showInputDialog(null, "How many credits are you taking?",
                        "Credit Hours", JOptionPane.QUESTION_MESSAGE));

            }

            double studentIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Yearly Income",
                    "student" +
                    " Income", JOptionPane.QUESTION_MESSAGE));
            while (studentIncome < 0) {
                JOptionPane.showMessageDialog(null, "Income cannot be negative", "Error: Income", JOptionPane
                        .ERROR_MESSAGE);
                studentIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Yearly Income", "student" +
                        " Income", JOptionPane.QUESTION_MESSAGE));
            }

            double parentIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your parents yearly Income?",
                    "Parent Income", JOptionPane.QUESTION_MESSAGE));
            while (parentIncome < 0) {
                JOptionPane.showMessageDialog(null, "Parent Income cannot be negative", "Error:Parent Income", JOptionPane
                        .ERROR_MESSAGE);
                parentIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your parents yearly Income?",
                        "Parent Income", JOptionPane.QUESTION_MESSAGE));
            }

            int isIndependant1 = JOptionPane.showConfirmDialog(null, "Are you a Dependant?", "Dependancy", JOptionPane
                    .YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (JOptionPane.NO_OPTION == isIndependant1) {
                isDependant = false;
            }

            String[] selection = new String[]{"Freshmen", "Sophomore", "Junior", "Senior", "graduate"};

            String classStanding = String.valueOf(JOptionPane.showInputDialog(null, "What is your Class Standing",
                    "Class " +
                            "Standing",
                    JOptionPane.PLAIN_MESSAGE, null, selection, selection[0]));

            if(!classStanding.equalsIgnoreCase("Graduate")) {
                classStanding = "undergraduate";
            }
            FAFSA fa = new FAFSA(isAcceptedStudent, isSSregisered, hasSSN, hasValidResidency, isDependant, age,
                    creditHours,
                    studentIncome, parentIncome, classStanding);


            fa.calcEFC();
                JOptionPane.showMessageDialog(null, "Loans = " + fa.calcStaffordLoan() + "\nGrants = " + fa.calcFederalGrant
                        () + "\nWork Study = " + fa.calcWorkStudy() + "\n-----------" + "\nTotal = " + fa
                        .calcFederalAidAmount(), "FAFSA Results", JOptionPane.INFORMATION_MESSAGE);
            x = JOptionPane.showConfirmDialog(null, "Would you like to complete another application?",
                    "Continue?", JOptionPane.YES_NO_OPTION);
        }
        while(x == 0);
    }
}

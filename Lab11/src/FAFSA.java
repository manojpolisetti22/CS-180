/**
 * Created by mpoliset on 11/4/15.
 */
public class FAFSA {
    boolean isAcceptedStudent;
    boolean isSSregistered;
    boolean hasSSN;
    boolean hasValidResidency;
    int age;
    double studentIncome;
    double parentIncome;
    String classStanding;
    int creditHours;
    boolean isDependant;

    public FAFSA(boolean isAcceptedStudent, boolean isSSregistered, boolean hasSSN,
                 boolean hasValidResidency, boolean isDependant, int age,
                 int creditHours, double studentIncome, double parentIncome,
                 String classStanding) {
        this.isAcceptedStudent = isAcceptedStudent;
        this.isSSregistered = isSSregistered;
        this.hasSSN = hasSSN;
        this.hasValidResidency = hasValidResidency;
        this.age = age;
        this.studentIncome = studentIncome;
        this.parentIncome = parentIncome;
        this.classStanding = classStanding;
        this.creditHours = creditHours;
        this.isDependant = isDependant;
    }

    /**
     * Determines if the student is eligible for federal financial aid. To be
     * eligible, the student must be an accepted student to a higher education
     * program (isAcceptedStudent), must be registered with the selective service
     * (isSSregistered) if they are between  the ages of 18-25 inclusive, must
     * have a social security number (hasSSN), and must have valid residency
     * status (hasValidResidency).
     *
     * @return True if the student is aid eligible and false otherwise
     */
    public boolean isFederalAidEligible() {
        boolean isEligible = false;
        if (isAcceptedStudent == true && hasSSN == true && hasValidResidency == true) {
            if (age >= 18 && age <= 25) {
                if (isSSregistered == true) {
                    isEligible = true;
                }
                else if (isSSregistered == false) {
                    isEligible = false;
                }
            }
            else {
                isEligible = true;
            }
        }
        return isEligible;
    }

    /**
     * Calculates the students expected family contribution. If the student is
     * a dependent, then their EFC is calculated by the sum of the students
     * income and their parent's income, else if it just the student's income.
     *
     * @return The students expected family contribution
     */
    public double calcEFC() {
        double EFC = 0.0;
        if (isDependant == true) {
            EFC = studentIncome + parentIncome;
        }
        else if (isDependant == false) {
            EFC = studentIncome;
        }
        return EFC;
    }

    /**
     * Calculates the student's federal grant award. The student's EFC must be
     * less than or equal to 50000 and they must be an undergraduate. The award
     * amount is based on their class standing and credit hours. Refer to the
     * tables in the breakdown section.
     *
     * @return The student's calculated federal grant award amount
     */
    public double calcFederalGrant() {

        if (classStanding == null) {
            return 0;
        }
        if (calcEFC() <= 50000) {
            if (classStanding.equalsIgnoreCase("undergraduate")) {
                if (creditHours < 9) {
                    return 2500;
                }
                else if (creditHours >= 9) {
                    return 5775;
                }
            }
            else if (classStanding.equalsIgnoreCase("graduate")) {
                return 0;
            }
        }
        else if (calcEFC() > 50000) {
            return 0;
        }
        return 0;
    }
    /**
     * Calculates the student's total Stafford loan award. The Stafford loan is
     * only available for students registered for 9 or more credit hours. The amount
     * of the award is calculated by the student's dependency status and their
     * class standing. Refer to the tables in the breakdown section.
     *
     * @return The student's calculated Stafford loan award amount
     */
    public double calcStaffordLoan() {
        if (classStanding == null) {
            return 0;
        }
        if ( creditHours >= 9) {
            if (isDependant == true) {
                if (classStanding.equalsIgnoreCase("undergraduate")) {
                    return 5000;
                }
                else if (classStanding.equalsIgnoreCase("graduate")) {
                    return 10000;
                }
            }
            else if (isDependant == false) {
                if (classStanding.equalsIgnoreCase("undergraduate")) {
                    return 10000;
                }
                else if (classStanding.equalsIgnoreCase("graduate")) {
                    return 20000;
                }
            }
        }
        return 0;
    }

    /**
     * Calculates the student's work study award. The work study award is
     * based on the student's EFC. Refer to the table in the breakdown section.
     *
     * @return The student's calculated federal grant award amount
     */
    public double calcWorkStudy() {
        if (calcEFC() >= 0 && calcEFC() <= 30000) {
            return 1500;
        }
        else if (calcEFC() > 30000 && calcEFC() <= 40000) {
            return 1000;
        }
        else if (calcEFC() > 40000 && calcEFC() <= 50000) {
            return 500;
        }
        else if ( calcEFC() > 50000) {
            return 0;
        }
        return 0;
    }

    /**
     * Calculates the student's total combined federal aid award. The total
     * aid award is calculated as the sum of Stafford loan award, federal grant
     * award, and work study award. You should make a call to the method
     * isFederalAidEligible() to see if the student is eligible to receive
     * federal aid. If they are NOT eligible, you can return 0. If the are, you
     * will return their total aid award.
     *
     * @return The student's total aid award amount
     */
    public double calcFederalAidAmount() {
        double totalAid= 0.0;
        if (isFederalAidEligible()) {
            totalAid = calcWorkStudy() + calcFederalGrant() + calcStaffordLoan();
        }
        else if ( !isFederalAidEligible()) {
            return 0;
        }
        return totalAid;
    }



}

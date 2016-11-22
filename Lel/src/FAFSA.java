/**
 * Created by meghnaatluri on 14/09/15.
 */
public class FAFSA {
    boolean isAcceptedStudent;
    boolean isSSregistered;
    boolean hasSSN;
    boolean hasValidResidency;
    int age;
    double studentIncome;
    double parentIncome;
    int creditHours;
    boolean isDependent;
    String classStanding;

    public FAFSA(boolean isAcceptedStudent, boolean isSSregistered, boolean hasSSN, boolean hasValidResidency, boolean isDependent,
                 int age ,int creditHours,double studentIncome, double parentIncome, String classStanding)

    {
        this.isAcceptedStudent = isAcceptedStudent;
        this.isSSregistered = isSSregistered;
        this.hasSSN = hasSSN;
        this.hasValidResidency = hasValidResidency;
        this.age = age;
        this.studentIncome = studentIncome;
        this.parentIncome = parentIncome;
        this.creditHours = creditHours;
        this.isDependent = isDependent;
        this.classStanding = classStanding;

    }

    public boolean isFederalAidEligible() {
        if (isAcceptedStudent && isSSregistered && hasSSN && hasValidResidency) {
            if (age >= 18 && age <= 25) {
                return true;
            }
            else if (age <=18 && age >=25)
            {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }

    public double calcEFC() {
        if (isDependent) {
            return (studentIncome + parentIncome);
        } else {
            return (studentIncome);
        }

    }

    public double calcFederalGrant() {
        double EFC = calcEFC();
        if (EFC <= 50000) {
            if (classStanding.equalsIgnoreCase("undergraduate")) {
                if (creditHours >= 9) {
                    return 2500;
                } else {
                    return 0;
                }
            }
            if (classStanding.equalsIgnoreCase("graduate")) {
                if (creditHours >= 9) {
                    return 5775;
                } else {
                    return 0;
                }
            }
        } else  {
            return 0;
        }
        return EFC;


    }

    public double calcStaffordLoan() {
        if (classStanding == null)
            return 0;
        else if (creditHours >= 9 && classStanding.equalsIgnoreCase("undergraduate") && isDependent == false)
            return 10000;
        else if (creditHours >= 9 && classStanding.equalsIgnoreCase("undergraduate") && isDependent == true)
            return 5000;
        else if (creditHours >= 9 && classStanding.equalsIgnoreCase("graduate") && isDependent == false)
            return 20000;
        else if (creditHours >= 9 && classStanding.equalsIgnoreCase("graduate") && isDependent == true)
            return 10000;

        return 0;

    }

    public double calcWorkStudy() {
        double EFC = calcEFC();
        if (EFC >= 0 && EFC <= 30000)
            return 1500;
        if (EFC >= 30000.01 && EFC <= 40000)
            return 1000;
        if (EFC >= 40000.01 && EFC <= 50000)
            return 500;
        if (EFC > 50000.01)
            return 0;

        return EFC;

    }

    public double calcFederalAidAmount() {
        double FederalAidAmount = calcStaffordLoan() + calcFederalGrant() + calcWorkStudy();
        if (isFederalAidEligible() == true) {
            return FederalAidAmount;

        } if (isFederalAidEligible() == false) {
                return 0;
            }
        return 0;

        }

    }







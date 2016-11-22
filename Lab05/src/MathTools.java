/**
 * Created by manojpolisetti on 22/09/15.
 */
public class MathTools {
    public static double absoluteValue(double n) {
        if (n >= 0) {
            return n;
        }
        else {
            return (-1) * (n);
        }
    }
    public static double power (double base, int exponent) {
        double result = 1;
        if (exponent == 0) {
            return 0;
        }
        double exponent1 = absoluteValue(exponent);
        for (int i = 0; i < exponent1; i++) {
            result *= base;
        }
        if (exponent <= 0) {
            result = 1/(result);
        }
        return result;
    }
    public static double nthRoot( double value, int root) {
        double change = 0.0;
        double guess = 0.0;
        if ( value < 0.0) {
            return 0.0;
        }
        if ( root < 0.0) {
            return 0.0;
        }
        do {
            if (root < 0) {
                value = 1 / value;
            }
            guess = ((root - 1) * value + (value / (power(value, root - 1)))) / (root);
            change = absoluteValue((guess - value));
            if (change > 0.000000001) {
                value = guess;
            }
        }
        while (change > 0.000000001);

    return guess;
    }

    public static String scientificNotation(double n) {
        int exponent = 0;
        String result = "";
        if( n > 0 && n < 10){
            double coefficient = ((int)(n * 1000000)) / 1000000.0;
            result = "" + coefficient + " x 10 ^ 0";
        }

        if( n < 1){
            n = absoluteValue(n);
            for(int i = 0; n < 10; i++) {

                n = n * 10;
                exponent += 1;

            }
            double coefficient = ((int)(n * 100000)) / 100000.0;
            result = (coefficient/10) + " x 10 ^ " + "-" + (exponent-1);
            return result;
        }


        if( n >= 10){
            for(int i = 1; n >= 10; i++){
                if(n >= 10){
                    n = n/10;
                    exponent += 1;
                }
            }
            double coefficient = ((int)(n * 1000000)) / 1000000.0;
            result = "" + coefficient + " x 10 ^ " + exponent;
            return result;


        }
        if(n == 0){
            return "0";
        }
        return result;
    }
}

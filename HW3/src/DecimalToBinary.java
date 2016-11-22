/**
 * Created by manojpolisetti on 11/09/15.
 */
public class DecimalToBinary {
    public String decimalToBinary(int decimal) {
        String binary = "";
        String binary01 = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal >= 2) {
            binary = binary + (decimal % 2);
            decimal = decimal / 2;
        }
        binary = binary + "1";
        for (int i = binary.length() - 1; i >= 0; i--) {
            binary01 = binary01 + binary.charAt(i);
        }
        return binary01;
    }

    public static void main(String[] args) {
        DecimalToBinary obj = new DecimalToBinary();
        System.out.println(obj.decimalToBinary(10));
        System.out.println(obj.decimalToBinary(0));
    }
}

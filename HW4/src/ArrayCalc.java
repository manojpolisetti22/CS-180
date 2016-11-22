/**
 * Created by manojpolisetti on 19/09/15.
 */
public class ArrayCalc {
    String arrayCalc(int[] array) {
        if (array == null) {
            return "";
        }
        int max = array[0];
        int min = array[0];
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            if ( max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
            total = total + array[i];
        }
        int average = total / (array.length);
        return "high: " + max + ", low: " + min + ", average: " + average;
    }
    public static void main(String[] args) {
        ArrayCalc a = new ArrayCalc();
        System.out.println(a.arrayCalc(new int[]{1, 2, 3})); //prints "high: 3, low: 1, average: 2"
        System.out.println(a.arrayCalc(new int[]{0})); //prints "high: 0, low: 0, average: 0"
        System.out.println(a.arrayCalc(null)); //prints ""
    }
}

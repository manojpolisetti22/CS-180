/**
 * Created by manojpolisetti on 17/12/15.
 */
public class Test12 {
    public static void main(String[] xyz) {
        double[] a = {2.734, 4.2, 6.33};
        double[] b = a;
        int[] c = new int[3];
// for loop

        System.out.println(a[0] % 2); // Line A
        System.out.printf("%.2f %d\n", b[1], c[1]); // Line B
        System.out.printf("%.2f %.2f", b[1], c[1]); // Line C
    }

}

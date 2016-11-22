import java.util.Arrays;

/**
 * Created by manojpolisetti on 30/10/15.
 */
public class Test {
    public static void main(String[] args) {
        String s = "1,44,22,2";
        int[] a = new int[2];
        a[0] = 1;
        a[1] = 3;
        String[] parts = s.split(",");
        int[] n1 = new int[parts.length];
        for(int n = 0; n < parts.length; n++) {
            n1[n] = Integer.parseInt(parts[n]);
        }
        System.out.println(Arrays.toString(n1));
    }
}

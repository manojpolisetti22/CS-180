/**
 * Created by manojpolisetti on 14/11/15.
 */
public class Test {
    public static void main(String[] args) {
        String s = "POST-MESSAGE\t1868\tWelcome on the CS180 Chat\r\n";
        String[] a = s.split("\t");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println(a.length);

    }
}

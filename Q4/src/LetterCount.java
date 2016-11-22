import java.util.Arrays;

/**
 * Created by manojpolisetti on 05/10/15.
 */
public class LetterCount {
    public static int letterCountDistinct(String s) {
        int len = s.length();
        s.toLowerCase();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count ++;
            }
        }
        int count1 = count / 2;
        return (len - count1);
    }
}

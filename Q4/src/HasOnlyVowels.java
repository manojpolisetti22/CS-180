/**
 * Created by manojpolisetti on 05/10/15.
 */
public class HasOnlyVowels {
    public static boolean hasOnlyVowels(String s) {
        int len = s.length();
        int count = 0;
        s = s.toLowerCase();
        for(int i = 0; i < len; i ++) {
            if (s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                count ++;
            }
            else {
                count = 0;
            }
        }
        if (count == len) {
            return true;
        }
        return false;
    }
}



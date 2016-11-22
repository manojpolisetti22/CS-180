/**
 * Created by manojpolisetti on 06/09/15.
 */
public class LargestEven {
    public int largestEven(int x, int y, int z) {
        int grt = 0;
        char count = '0';
        if (x % 2 == 0 && y % 2 == 0 && z % 2 == 0) {
            count = 'a';
        } else if (x % 2 == 0 && y % 2 == 0 && z % 2 != 0) {
            count = 'b';
        } else if (x % 2 == 0 && y % 2 != 0 && z % 2 == 0) {
            count = 'c';
        } else if (x % 2 != 0 && y % 2 == 0 && z % 2 == 0) {
            count = 'd';
        } else if (x % 2 == 0) {
            grt = x;

        } else if (y % 2 == 0) {
            grt = y;
        } else if (z % 2 == 0) {
            grt = z;
        }

        if (count == 'a') {
            if (x > y) {
                grt = x;
            } else {
                grt = y;
            }
            if (grt > z) {
                grt = grt;
            } else {
                grt = z;
            }
            return grt;
        } else if (count == 'b') {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        } else if (count == 'c') {
            if (x > z) {
                return x;
            } else {
                return z;
            }
        } else if (count == 'd') {
            if (y > z) {
                return y;
            } else {
                return z;
            }
        }
        return grt;
    }

    public static void main(String[] args) {
        LargestEven le = new LargestEven();
        System.out.println(le.largestEven(1, 3, 5));
        System.out.println(le.largestEven(2, 4, 9));
        System.out.println(le.largestEven(2, 1001, 1003));
    }
}

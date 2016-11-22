import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by manojpolisetti on 04/12/15.
 */
public class ResizableArray {

    int[] array;
    int size;

    public ResizableArray() {
        this.array = new int[4];
        this.size = 0;
    }

    public void add(int value) {

        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[size] = value;
        size ++;

    }

    public int getSize() {
        return this.size;
    }

    public int getArraySize() {
        return this.array.length;
    }

    public String toString() {
        String s = "";
        if (size == 0) {
            return s;
        }
        for (int i = 0; i < size; i++) {
            s += array[i] + ",";
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResizableArray ra = new ResizableArray();
        int x = sc.nextInt();
        ra.add(x);
        System.out.println(ra.toString());
    }
}

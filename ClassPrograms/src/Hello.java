/**
 * Created by manojpolisetti on 23/03/16.
 */
public class Hello {

    public static void main(String[] args) {
        int i = 0, j = 0;
        int count = 0;
        int n = 5;
        int arr[] = {5, 4, 3, 2, 1 };
        for (; i < n; ++i) {
            while (j < n && arr[i] < arr[j]) {
                j++;
                count++;
            }
    }
        System.out.println(j);
    }
}

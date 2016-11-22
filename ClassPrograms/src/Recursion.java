import java.io.File;

/**
 * Created by manojpolisetti on 28/04/16.
 */
public class Recursion {
    public static int filecount(File f) {
        if(f.isDirectory()) {
            File[] arr = f.listFiles();
            int count = 0;
            if(arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    if (!arr[i].isDirectory() && arr[i].isFile()) {
                        count++;
                    } else if (arr[i].isDirectory()) {
                        int temp = filecount(arr[i]);
                        count += temp;
                    }
                }
            }
            return count;
        }
        else {
            return 1;
        }
    }
}
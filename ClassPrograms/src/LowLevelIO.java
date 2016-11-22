/**
 * Created by manojpolisetti on 26/10/15.
 */
import java.io.*;

public class LowLevelIO {
    public static void main(String[] args) throws IOException {
        File f = new File("lowlevel");

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(42);
        fos.close();

        FileInputStream fis = new FileInputStream(f);
        int i = fis.read();
        System.out.printf("Read %d\n", i);
        fis.close();
    }
}

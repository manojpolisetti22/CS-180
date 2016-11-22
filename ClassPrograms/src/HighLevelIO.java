/**
 * Created by manojpolisetti on 26/10/15.
 */
import java.io.*;

public class HighLevelIO {
    public static void main(String[] args) throws IOException {
        File f = new File("highlevel");

        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(1000);
        dos.close();

        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        int i = dis.readInt();
        System.out.printf("Read %d\n", i);
        dis.close();
    }
}

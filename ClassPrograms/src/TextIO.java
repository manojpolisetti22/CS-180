/**
 * Created by manojpolisetti on 26/10/15.
 */
import java.io.*;

public class TextIO {

    public static void main(String[] args) throws IOException {
        File f = new File("textio.txt");

        // open FileOutputStream in append mode (true)
        FileOutputStream fos = new FileOutputStream(f, true);

        // use PrintWriter--similar to PrintStream (like System.out)...
        PrintWriter pw = new PrintWriter(fos);
        pw.println("our old friend");
        pw.close();
        // read what we just wrote...
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String s = bfr.readLine();
            if (s == null)
                break;
            System.out.println(s);
        }
        bfr.close();
    }
}


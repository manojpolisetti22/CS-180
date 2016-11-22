import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by manojpolisetti on 13/11/15.
 */
public class FileSum {
    public static double sumFile(String filename) {
        double sum = 0;
        FileReader fr = null;
        Scanner sc = null;
        if (filename == null) {
            return 0;
        }
        try {
            fr = new FileReader(filename);
            sc = new Scanner(fr);
            ArrayList<String> s = new ArrayList<>();
            while (sc.hasNext()) {
                String a = sc.next();
                s.add(a);
                sc.nextLine();
            }
            for (int i = 0; i < s.size(); i++) {
                String[] b = s.get(i).split(" ");
                int len = b.length;
                for (int j = 0; j < len; j++) {
                    try {
                        double d = Double.parseDouble(b[j]);
                        sum += d;
                    }
                    catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 0;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumFile("example.txt"));
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by justin on 4/20/16.
 */
public class FileParser {
    public void writeToFile(String filename) {
        double total = 0;
        File f = new File(filename);
        Scanner scanner = null;
        int count = 0;
        try {
            scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    if (scanner.hasNextDouble()) {
                        total = total + scanner.nextDouble();
                    }
                    System.out.println("Row" + count + ": " + total);
                }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
    public static void main(String[] args){
        FileParser m = new FileParser();
        m.writeToFile("result.txt"); // the contents of matrix.txt are in the example above
    }
}

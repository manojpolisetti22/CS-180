/**
 * Created by manojpolisetti on 27/10/15.
 */

import java.io.*;
import java.util.Arrays;

public class Matrix extends Thread {
    public boolean isReshapable(int length, int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        if (length == 0 && col == 0 && row == 0) {
            return true;
        }
        if (length == 0 && row != 0 || col != 0) {
            return false;
        }
        if (length % (row * col) == 0) {
            return true;
        }
        return false;
    }

    public void writeMatrix(String filename, int[][] matrix) {
        try {
            FileOutputStream fos = new FileOutputStream(filename, true);
            PrintWriter pw = new PrintWriter(fos);

            for(int i = 0; i < matrix[0].length; i++) {
                for(int j = 0; j < matrix.length; j++) {
                    pw.print(matrix[i][j] + ",");
                }
                pw.println();
            }
            pw.close();
        }

        catch (FileNotFoundException f) {

        }

    }

    public int[] readVector(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bfr = new BufferedReader(fr);
            String s = bfr.readLine();
            String[] parts = s.split(",");
            int[] n1 = new int[parts.length];
            for (int n = 0; n < parts.length; n++) {
                n1[n] = Integer.parseInt(parts[n]);
            }
            bfr.close();
            return n1;
        } catch (FileNotFoundException f) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public int[][] reshape(int[] vector, int row, int col) {
        int[][] matrix = new int[row][col];
        int count = 0;
        if (vector == null) {
            return null;
        }
        if (vector.length == (row * col)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = vector[count];
                    count++;
                }
            }
        } else {
            return null;
        }
        return matrix;
    }
    public static void main(String[] args) {

        Matrix m = new Matrix();
        int[] vector = new int[]{};

        System.out.println(Arrays.deepToString(m.reshape(vector, 2, 6)));
        System.out.println(Arrays.deepToString(m.reshape(vector, 3, 4)));
    }
}

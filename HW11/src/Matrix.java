/**
 * Created by manojpolisetti on 06/11/15.
 */

import java.io.*;

public class Matrix {
    int[][] reshape(int[] vector, int row, int col) {
        if (vector == null)
            return null;
        int[][] result = new int[row][col];
        if (vector.length != (row) * (col)) {
            return null;
        } else {
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //++count - count+1
                    //count++ - count = count +1
                    result[i][j] = vector[count];
                    count++;

                }
            }
            return result;
        }
    }

    public int[] readVector(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            String k = bfr.readLine();
            String[] div = k.split(",");
            int[] q = new int[div.length];
            for (int i = 0; i < div.length; i++) {
                q[i] = Integer.parseInt(div[i]);
            }
            bfr.close();
            return q;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void writeMatrix(String filename, int[][] matrix) {
        try {
            File f = new File(filename);
            PrintWriter fos = new PrintWriter(f);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    fos.print(matrix[i][j]);
                    if (j < matrix[i].length - 1) {
                        fos.print(",");
                    }
                }
                fos.print("\n");
            }

            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        /*Matrix m = new Matrix();
        int[] vector = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.deepToString(m.reshape(vector, 2, 6)));
        //prints "[[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12]]"
        System.out.println(Arrays.deepToString(m.reshape(vector, 3, 4)));
        //prints "[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]"
*/
        Matrix m = new Matrix();
        m.writeMatrix("txt.txt", new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

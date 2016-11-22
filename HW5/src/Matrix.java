/**
 * Created by manojpolisetti on 01/10/15.
 */
import java.util.Arrays;
public class Matrix {
    public boolean isReshapable(int length, int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        if (length == 0 && col == 0 && row == 0) {
            return true;
        }
        if (length == 0 && (row != 0 || col != 0)) {
            return false;
        }
        if (length % (row * col) == 0) {
            return true;
        }
        return false;
    }

    public int[][] reshape(int[] vector, int row, int col) {
        int[][] matrix = new int[row][col];
        int count = 0;
        if (vector == null) {
            return  null;
        }
        if (vector.length == (row * col)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = vector[count];
                    count++;
                }
            }
        }
        else {
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

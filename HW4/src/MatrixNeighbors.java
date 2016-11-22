/**
 * Created by manojpolisetti on 21/09/15.
 */
public class MatrixNeighbors {
    int rows;
    int columns;
    int[][] matrix;
    MatrixNeighbors(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }
    public String neighbors(int row, int column) {
        String result = "";
        if ((row > rows - 1) || (column > columns - 1)) {
            return "cell does not exist";
        }
        int r = row - 1;
        int c = column - 1;
        int r1 = row + 1;
        int c1 = column + 1;
        if (r >= 0) {
            result += r + "," + column + ";";
            if (c1 <= columns - 1) {
                result += r + "," + c1 + ";";
            }
        }
        if ( c1 <= columns - 1) {
            result += row + "," + c1 + ";";
        }
        if (r1 <= rows - 1) {
            if (c1 <= columns - 1) {
                result += r1 + "," + c1 + ";";
            }
            result += r1 + "," + column + ";";
            if (c >= 0) {
                result += r1 + "," + c + ";";
            }
        }
        if ( c >= 0) {
            result += row + "," + c + ";";
        }
        if (r >= 0) {
            if (c >= 0) {
                result += r + "," + c + ";";
            }
        }
        return result;
    }
    public static void main (String[] args) {
        MatrixNeighbors m = new MatrixNeighbors(3, 3);
        System.out.println(m.neighbors(0, 0)); //prints "0,1;1,1;1,0;"
        System.out.println(m.neighbors(2, 2)); //prints "1,2;2,1;1,1;"
        System.out.println(m.neighbors(1, 1)); //prints "0,1;0,2;1,2;2,2;2,1;2,0;1,0;0,0;"
        System.out.println(m.neighbors(3, 0)); //prints "cell does not exist"
    }

}

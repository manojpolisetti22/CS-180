/**
 * Created by manojpolisetti on 30/09/15.
 */
public class Matrix {
    public boolean isSquare(int[][] matrix){
        return matrix.length == matrix[0].length;
    }

    public boolean isSymmetric(int[][] matrix) {

        boolean check = false;

        if(!isSquare(matrix)){
            return false;
        }

        for (int x = 0; x < matrix.length; x++) {//enter i & j
            for (int y = 0; y < matrix[0].length; y++) { // enter i & j
                if (matrix[x][y] == matrix[y][x]) {
                    check = true;
                } else {
                    check = false;
                    break;
                }

            }
            if (check == false) {
                break;
            }
        }
        return check;
    }



    public boolean isDiagonal(int[][] matrix) {
        boolean check = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }

                }
            }

        }
        return check;
    }

    public boolean isIdentity(int[][] matrix) {
        boolean check = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
                if (i == j) {
                    if (matrix[i][j] != 1) {
                        return false;
                    }
                }
            }
        }
        return check;
    }

    public boolean isUpperTriangular(int[][] matrix) {

        if(!isSquare(matrix)){
            return false;
        }

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < (matrix[0].length - x); y++) {
                if (x > y && matrix[x][y] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTriDiagonal(int[][] matrix) {

        if(!isSquare(matrix)) { //Here
            return false;
        }
        int length = matrix.length;
        for (int x = 2; x < length; x++) {
            for (int y = 0; y <= (x - 2); y++) {
                if (x != y && x != y + 1 && x != y - 1 && matrix[x][y] != 0) {
                    return false;
                }
            }
        }return true;
    }
}


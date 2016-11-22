import java.util.*;

public class Connect4 {

    public static final char NONE = ' ';
    public static final char RED = 'O';
    public static final char YELLOW = 'X';

    char[][] board;

    /**
     * Initializes the instance variables.
     */
    public Connect4() {
        board = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = NONE;
            }
        }
    }

    /**
     * Returns a copy of the current board
     *
     * @return a char matrix
     */
    public char[][] getBoard() {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    /**
     * Put a piece of the given color in the given column
     * The function returns the row where the piece have been
     * put. If the column is full it return -1.
     *
     * @param column a column of the board
     * @param color  RED or YELLOW
     */
    public int putPiece(int column, char color) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == NONE) {
                board[i][column] = color;
                return i;
            }
        }
        return -1;
    }

    /**
     * Print the screen in the standard output
     */
    public void printScreen() {
        // Make the header of the board
        System.out.printf("\n ");
        for (int i = 0; i < board[0].length; ++i)
            System.out.printf("   %d", i);
        System.out.println();

        System.out.printf("  ");
        for (int i = 0; i < board[0].length; ++i)
            System.out.printf("----");
        System.out.println("-");

        // Print the board contents
        for (int i = 0; i < board.length; ++i) {
            System.out.printf("%c ", 'A' + i);
            for (int k = 0; k < board[0].length; ++k)
                System.out.printf("| %c ", board[i][k]);
            System.out.println("|");

            // print the line between each row
            System.out.printf("  ");
            for (int k = 0; k < board[0].length; ++k)
                System.out.printf("----");
            System.out.println("-");
        }
    }

    /**
     * Check if an alignment has been made using the given tile
     *
     * @param row
     * @param column
     * @return the color if there is an alignment, NONE otherwise.
     */
    public char checkAlignment(int row, int column) {
        char color = board[row][column];
        int count = 1;
/*
            // -----> Horizontal to Right!
            for (int i = 1; i < 4; i++) {
                if (column + i >= 0) {
                    if (count == 4) {
                        return color;
                    } else if (board[row][column] == board[row][column + 1]) {
                        count = count + 1;
                    }

                }
            }

            // <----- Horizontal to Left!
            for (int i = 1; i < 4; i++) {
                if (column - i >= 0) {
                    if (count == 4) {
                        return color;
                    }
                    if (board[row][column - i] == color) {
                        count++;
                    }
                }
            }
  */
        for (int i = 0; i < 7; i++) { // COMPLETE HORIZONTAL
            if (board[row][i] == color) {
                count++;
            } else {
                count = 1;
            }
            if (count == 5) {
                return color;
            }
        }

        for (int j = 0; j < 6; j++) { // VERTICAL
            if (board[j][column] == color) {
                count++;
            } else {
                count = 1;
            }
            if (count == 5) {
                return color;
            }
        }

        count = 1;

        for (int i = 1; i < 4; i++) { //Diag Bot Right
            if (row + i < 6 && column + i < 7) {
                if (board[row + i][column + i] == board[row][column]) {
                    count++;
                    if (count == 4) {
                        return board[row][column];
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 4; i++) { // Diag Top Left
            if (row - i >= 0 && column - i >= 0) {
                if (board[row - i][column - i] == board[row][column]) {
                    count++;
                    if (count == 4) {
                        return board[row][column];
                    }
                } else {
                    break;
                }
            }
        }

        count = 1;


        for (int i = 1; i < 4; i++) {
            if (row - i >= 0 && column + i < 7) {
                if (board[row - i][column + i] == board[row][column]) {
                    count++;
                    if (count == 4) {
                        return board[row][column];
                    }
                } else {
                    break;
                }
            }
        }


        for (int i = 1; i < 4; i++) { // Diag Bot Left
            if (row + i < 6 && column - i >= 0) {
                if (board[row + i][column - i] == board[row][column]) {
                    count++;
                    if (count == 4) {
                        return board[row][column];
                    }
                } else {
                    break;
                }
            }
        }


        return NONE;
    }

    /**
     * Launch the game for one game.
     */
    public void play() {
        char currentPlayer = RED;

        // Begin playing the game
        Scanner in = new Scanner(System.in);
        int col = -1;
        int row = -1;

        do {
            currentPlayer = currentPlayer == RED ? YELLOW : RED;
            this.printScreen();
            System.out.printf("Current player: '%c'\n", currentPlayer);

            // read and validate the input
            col = -1;
            row = -1;

            do {
                System.out.printf("Choose a column: ");
                String line = in.nextLine();


                if (line == null || line.length() != 1) {
                    // Invalid input, reask for one.
                    continue;
                }

                col = line.charAt(0) - '0';
                row = this.putPiece(col, currentPlayer);

            } while (row < 0);

        } while (this.checkAlignment(row, col) == NONE);

        this.printScreen();
        System.out.printf("\n!!! Winner is Player '%c' !!!\n", currentPlayer);
        in.close();

    }
}
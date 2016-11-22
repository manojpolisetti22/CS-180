import java.util.Scanner;

public class RiverCrossingPuzzle {

    /**
     * Constants
     */
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    /**
     * Which bank is the boat on, 0 for left, 1 for right
     */
    private int boatSide;

    /**
     * Number of actions taken
     */
    private int totalMoves;

    /**
     * Cannibals on the left side.
     */
    private int cannibalsLeft;

    /**
     * Cannibals on the right side.
     */
    private int cannibalsRight;

    /**
     * Missionaries on the left side.
     */
    private int missionariesLeft;

    /**
     * Missionaries on the right side.
     */
    private int missionariesRight;

    /**
     * Create a game in initial state.
     */
    public RiverCrossingPuzzle() {
        cannibalsLeft = 3;
        missionariesLeft = 3;
        boatSide = 0;
        totalMoves = 0;
        cannibalsRight = 0;
        missionariesRight = 0;
    }

    /**
     * Reset the game with the given parameters
     */
    public void reset(int cannibalsLeft, int cannibalsRight, int missionariesLeft, int missionariesRight,
            int boatSide) {
        this.cannibalsLeft = cannibalsLeft;
        this.cannibalsRight = cannibalsRight;
        this.missionariesLeft = missionariesLeft;
        this.missionariesRight = missionariesRight;
        this.boatSide = boatSide;
        this.totalMoves = 0;
    }

    /**
     *
     * @return number of missionaries on the left (starting) bank
     */
    public int numMissionariesOnLeftBank() {
        return missionariesLeft;
    }

    /**
     *
     * @return number of missionaries on the right (ending) bank
     */
    public int numMissionariesOnRightBank() {
        return missionariesRight;
    }

    /**
     *
     * @return number of cannibals on the left (starting) bank
     */
    public int numCannibalsOnLeftBank() {
        return cannibalsLeft;
    }

    /**
     *
     * @return number of cannibals on the right (ending) bank
     */
    public int numCannibalsOnRightBank() {
        return cannibalsRight;
    }

    /**
     *
     * @return true if boat is on left (starting) bank
     */
    public boolean boatOnLeftBank() {
        return boatSide == LEFT;
    }

    /**
     *
     * @return true if boat is on right (ending) bank
     */
    public boolean boatOnRightBank() {
        return boatSide == RIGHT;
    }

    /**
     * check status of game
     *
     * @return -1 if puzzle failed, 0 if puzzle not yet solved, 1 if puzzle
     *         solved
     */
    public int status() {
        if (missionariesRight == 3 && cannibalsRight == 3) {
            return 1;
        }
        else if (missionariesRight < cannibalsRight && missionariesRight != 0 || missionariesLeft < cannibalsLeft
                && missionariesLeft != 0) {
            return -1;
        }
        return 0;
    }

    /**
     * Generates a move string.
     *
     * @param1 The number of cannibals in the move.
     * @param2 The number of missionaries in the move.
     * @return The move string to be returned.
     */
    public String moveGenerator(int cannibals, int missionaries) {

        if (cannibals == 1 && missionaries == 1)
            return String.format("(3) 1 cannibal and 1 missionary cross");
        if (cannibals <= 2 && cannibals > 0 && missionaries == 0)
            return String.format("(%d) %d cannibal(s) cross", cannibals, cannibals);
        if (missionaries <= 2 && missionaries > 0 && cannibals == 0)
            return String.format("(%d) %d missionary(s) cross", 3 + missionaries, missionaries);

        return "Invalid Move";
    }

    /**
     * Print all the available moves to the users.
     */
    public void availableMoves() {
        if ((boatSide == 0 && cannibalsLeft >= 1) || ( boatSide == 1 && cannibalsRight >= 1)) {
            System.out.println(moveGenerator(1, 0));
        } // Change everything to above shit!!!
        if ((boatSide == 0 && cannibalsLeft >= 2) || (boatSide == 1 && cannibalsRight >= 2)) {
            System.out.println(moveGenerator(2, 0));
        }
        if (((boatSide == 0 && cannibalsLeft >= 1 && missionariesLeft >= 1) || ( boatSide == 1 && cannibalsRight >= 1
                && missionariesRight >= 1))) {
            System.out.println(moveGenerator(1, 1));
        }
        if ((boatSide == 0 && missionariesLeft >= 1) || ( boatSide == 1 && missionariesRight >= 1)) {
            System.out.println(moveGenerator(0, 1));
        }
        if ((boatSide == 0 && missionariesLeft >= 2) || (boatSide == 1 && missionariesRight >= 2)) {
            System.out.println(moveGenerator(0, 2));
        }
    }
    /**
     * Move Cannibals from the side where is the boat to the other side.
     *
     * @param count The number of cannibals to be moved.
     */
    public void moveCannibals(int count) {
        if (this.boatSide == 0) {
            this.cannibalsLeft -= count;
            this.cannibalsRight += count;
        }
        if (this.boatSide == 1) {
            this.cannibalsRight -= count;
            this.cannibalsLeft += count;
        }
    }

    /**
     * Move Missionaries from the side where is the boat to the other side.
     *
     * @param count The number of missionaries to be moved.
     */
    public void moveMissionaries(int count) {
        if (this.boatSide == 0) {
            this.missionariesLeft -= count;
            this.missionariesRight += count;
        }
        if (this.boatSide == 1) {
            this.missionariesRight -= count;
            this.missionariesLeft += count;
        }
    }

    /**
     * Check is the given move is valid in the current situation.
     */
    public boolean isValidMove(int move) {
        if (move == 1 && ((boatSide == 0 && cannibalsLeft >= 1) || ( boatSide == 1 && cannibalsRight >= 1))) {
            return true;
        }
        if (move == 2 && ((boatSide == 0 && cannibalsLeft >= 2) || (boatSide == 1 && cannibalsRight >= 2))) {
            return true;
        }
        if (move == 3 && (((boatSide == 0 && cannibalsLeft >= 1 && missionariesLeft >= 1) ||
                ( boatSide == 1 && cannibalsRight >= 1 && missionariesRight >= 1)))) {
            return true;
        }
        if (move == 4 && ((boatSide == 0 && missionariesLeft >= 1) || ( boatSide == 1 && missionariesRight >= 1))) {
            return true;
        }
        if (move == 5 && ((boatSide == 0 && missionariesLeft >= 2) || (boatSide == 1 && missionariesRight >= 2))) {
            return true;
        }
        return false;
    }

    /**
     * Make the move that the user has requested.
     */
    public boolean makeMove(int move) {
        if (isValidMove(move)) {
            totalMoves ++;
            if (move == 1) {
                moveCannibals(1);
            }
            if (move == 2) {
                moveCannibals(2);
            }
            if (move == 3) {
                moveCannibals(1);
                moveMissionaries(1);
            }
            if (move == 4) {
                moveMissionaries(1);
            }
            if (move == 5) {
                moveMissionaries(2);
            }
            if (boatSide == 0) {
                boatSide = 1;
            }
            else {
                boatSide = 0;
            }
            return true;
        }

        return false;
    }

    /******************************************************************
     * Auxiliary functions used for display
     ******************************************************************/

    /**
     * Missionaries and Cannibal Strings for printing on left bank.
     */
    public String printLeftSide() {
        String result = "";
        int i = 0;
        for (i = 0; i < cannibalsLeft; i++)
            result = result + "C";

        while (i < 3) {
            result = result + " ";
            i++;
        }

        result = result + " ";

        for (i = 0; i < missionariesLeft; i++)
            result = result + "M";

        while (i < 3) {
            result = result + " ";
            i++;
        }
        return result;
    }

    /**
     * Missionaries and Cannibal Strings for printing on right bank.
     */
    public String printRightSide() {
        String result = "";
        int i = 0;
        for (i = 0; i < cannibalsRight; i++)
            result = result + "C";

        while (i < 3) {
            result = result + " ";
            i++;
        }

        result = result + " ";

        for (i = 0; i < missionariesRight; i++)
            result = result + "M";

        while (i < 3) {
            result = result + " ";
            i++;
        }
        return result;
    }

    /**
     * Prints the gameboard.
     */
    public void printBoard() {
        System.out.println("-----------------------------------------");
        System.out.println("          River Crossing Puzzle          ");
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("|Left Bank |                |Right Bank|");
        if (boatSide == LEFT) {
            System.out.print(" " + printLeftSide() + "  B");
            System.out.println("                 " + printRightSide());
        } else {
            System.out.print(" " + printLeftSide());
            System.out.println("                 " + printRightSide() + "  B");
        }
        System.out.println("Number of moves: " + totalMoves);
        System.out.println();
    }

    /**
     * Facilitates gameplay.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (status() == 0) {
            printBoard();
            System.out.println("Available Moves:");
            availableMoves();
            System.out.println("\nEnter a move:");
            int move = scanner.nextInt();
            makeMove(move);
        }

        printBoard();
        if (status() == -1) {
            System.out.println("Cannibals ate a missionary!");
        } else if (status() == 1) {
            System.out.println("You WIN!");
        }
    }
}
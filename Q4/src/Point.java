import com.sun.javafx.scene.paint.GradientUtils;

/**
 * Question 4 
 *
 *      Note 1: The PointTest.java file within this module has compile time errors.
 * 		This is because the Point class is incomplete. If you complete the Point
 * 		class correctly, all the compile time errors within PointTest will
 * 		automatically get fixed.
 *
 * 		- The class Point defined below can be used to manipulate an (x,y)
 * 		pair in programs involving the Cartesian coordinate system. 
 *
 * 		- Within the Point class, create one constructor that allows the user
 * 		to specify values for x and y and a default constructor that takes 
 * 		no arguments and sets both x and y to 0. Create accessors and mutators 
 * 		for x and y. The accessor and mutator for x should be named getX and 
 * 		setX, respectively. Similarly for y.
 *
 * 		- Create a method with the header public double distance(Point p) that 
 * 		uses the distance formula to find the distance between the current 
 * 		Point object and the Point object p passed in as an argument.
 *
 * 		Note 2: distance between two points (x1, y1) and (x2, y2) is given by
 * 		the formula:
 * 			square root of [(x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)]
 *
 */
public class Point {
    private int x; // do not edit this statement
    private int y; // do not edit this statement
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

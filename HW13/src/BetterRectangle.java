import java.awt.*;

/**
 * Created by manojpolisetti on 19/11/15.
 */
public class BetterRectangle extends Rectangle {
    public BetterRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public double getArea() {
        return width * height;
    }

}

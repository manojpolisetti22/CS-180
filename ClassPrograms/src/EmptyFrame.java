/**
 * Created by manojpolisetti on 04/11/15.
 */
import javax.swing.JFrame;

public class EmptyFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Empty Frame");
        jf.setSize(640, 480);
        jf.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
}

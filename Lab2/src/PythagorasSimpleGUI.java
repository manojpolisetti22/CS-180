/**
 * Created by manojpolisetti on 02/09/15.
 */
import javax.swing.JOptionPane;
public class PythagorasSimpleGUI {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras();
        String input1 = JOptionPane.showInputDialog("Enter the length of side 'a'");
        String input2 = JOptionPane.showInputDialog("Enter the length of side 'b'");
        int side1 = Integer.parseInt(input1);
        int side2 = Integer.parseInt(input2);
        double hypotenuse = p.getHypotenuse(side1, side2);
        JOptionPane.showMessageDialog(null, "The hypotenuse is: " + hypotenuse);

    }
}

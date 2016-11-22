/** CS180 Lab 03
 * The program tests StringManipulator.java
 * @author Manoj Polisetti. mpoliset@purdue.edu
 * Created by mpoliset on 9/6/15.
 */
import static org.junit.Assert.*;
import org.junit.*;

public class StringManipulatorTest {
    private StringManipulator sm;
    @Before
    public void setUp() throws Exception {
        sm = new StringManipulator();
    }
    @Test(timeout = 100)
    public void testMakeUserNameBasic() {
        String ret = sm.makeUserName("Nathanael Monaghan");
        String message = "makeUserName(): check if username follows the basic Unix style structure";
        assertEquals(message, "nmonaghan", ret);
    }
    /*@Test(timeout = 100)
    public void testMakeUserNameLower() {
        String ret = sm.makeUserName("Riya Tom");
        String message = "makeUserName(): check if username follows the basic Unix style structure";
        assertEquals(message, "rtom", ret);
    }
    */
    @Test(timeout = 100)
    public void testMakeEmail() {
        String ret = sm.makeEmail("Riya Tom","purdue.edu");
        String message = "makeUserName(): check if username follows the basic Unix style structure";
        assertEquals(message, "rtom@purdue.edu", ret);

    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicole on 10/30/2015.
 */
public class SessionCookieTest {
    SessionCookie cookie;
    @Before
    public void setUp() throws Exception {
        cookie = new SessionCookie(1111);
    }

    @Test(timeout = 100)
    public void testhasTimedOutWhenItHasnt() {
        cookie = new SessionCookie(1111);
        boolean expected = false;
        boolean actual = cookie.hasTimedOut();
        String message = "Check hasTimedOut() when it shouldn't have timed out";
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 2000)
    public void testhasTimedOutWhenItHas() {
        cookie = new SessionCookie(1111);
        boolean expected = true;
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        boolean actual = cookie.hasTimedOut();
        String message = "Check hasTimedOut() when it should've timed out";
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 2000)
    public void testupdateTimeOfActivity() {
        boolean expected = false;
        cookie = new SessionCookie(1111);
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        cookie.updateTimeOfActivity();
        boolean actual = cookie.hasTimedOut();
        String message = "Check updateTimeOfActivity, problem may also be with hasTimedOut";
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 100)
    public void testgetID() {
        long expected = 1111;
        long actual = cookie.getID();
        String message = "Check getID()";
        assertEquals(message, expected,actual);
    }
}
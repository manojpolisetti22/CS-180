/**
 * @author (Vinson Luo) <(vluo@purdue.edu)>, (Manoj Polisetti) <(mpoliset@purdue.edu)>
 *
 * @lab (Vinson, BR8), (Manoj, BR8)
 *
 * @version (17 November, 2015)
 *
 */

public class SessionCookie {
    private long timeActivity;
    private long id;
    public static int timeoutLength = 300;


    public boolean hasTimedOut() {
        if ((System.currentTimeMillis() - this.timeActivity) > timeoutLength * 1000) {
            return true;
        }
        return false;
    }

    public void updateTimeOfActivity() {
        this.timeActivity = System.currentTimeMillis();
    }

    public long getID() {
        return id;
    }

    public SessionCookie(long id) {
        this.id = id;
        this.timeActivity = System.currentTimeMillis();
    }
}

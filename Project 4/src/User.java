/**
 * @author (Vinson Luo) <(vluo@purdue.edu)>, (Manoj Polisetti) <(mpoliset@purdue.edu)>
 *
 * @lab (Vinson, BR8), (Manoj, BR8)
 *
 * @version (3 November, 2015)
 *
 */
public class User {
    private String username;
    private String password;
    private SessionCookie cookie;

    public User(String username, String password, SessionCookie cookie) {
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }

    public String getName() {
        return username;
    }
    public boolean checkPassword(String password) {
        return String.valueOf(this.password).equals(String.valueOf(password));
    }

    public SessionCookie getCookie() {
        return cookie;
    }

    public void setCookie(SessionCookie cookie) {
        this.cookie = cookie;
    }
}

/**
 * Created by manojpolisetti on 12/10/15.
 */
public class Route {
    private String from;
    private String to;

    public Route(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String toString() {

        return String.format("Route: From %s to %s \n", this.from, this.to);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;

        return (this.from.equals(other.from) && this.to.equals(other.to));
    }
}

/**
 * Created by manojpolisetti on 18/11/15.
 */
public class CircularBuffer {
    int size;
    String[] buffer;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new String[size];
    }


}

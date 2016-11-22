/**
 * Created by manojpolisetti on 19/10/15.
 */
public class AudioProduct extends Product {
    String productName;
    int totalSongs;

    public AudioProduct(String productName, int totalSongs) {
        super(productName);
        this.totalSongs = totalSongs;
    }

    public int getTotalSongs() {
        return totalSongs;
    }

}

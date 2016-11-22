/**
 * Created by manojpolisetti on 19/10/15.
 */
public class CD extends AudioProduct {
    String productName;
    int totalSongs;
    double price;

    public CD(String productName, int totalSongs, double price) {
        super(productName, totalSongs);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    
}

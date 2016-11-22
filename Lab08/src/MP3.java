/**
 * Created by manojpolisetti on 13/10/15.
 */
import java.util.UUID;
public class MP3 implements Sellable, Downloadable {
    String productName;
    double price = 0.99;

    public String generateDownloadCode() {
        String s =UUID.randomUUID().toString();
        return s;
    }

    public MP3(String productName) {
        this.productName = productName;
    }


    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

/**
 * Created by manojpolisetti on 13/10/15.
 */
import java.util.UUID;
public class MP4 implements Sellable, Downloadable {
    String productName;
    double price = 4.99;
    VideoType type;

    public VideoType getType() {
        return type;
    }
    public MP4(String productName, VideoType type) {
        this.productName = productName;
        this.type = type;
    }

    public String generateDownloadCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        if(type == VideoType.TVSERIES) {
            price = 19.99;
        }
        return price;
    }

}

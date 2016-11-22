/**
 * Created by manojpolisetti on 13/10/15.
 */
public class DVD implements Sellable {
    String productName;
    VideoType type;
    double price;

    public DVD(String productName, VideoType type, double price) {
        this.productName = productName;
        this.type = type;
        this.price = price;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public VideoType getType() {
        return type;
    }
}

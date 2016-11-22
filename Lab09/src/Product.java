/**
 * Created by manojpolisetti on 19/10/15.
 */
public class Product {
    private String productName;
    double price;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

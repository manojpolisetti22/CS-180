/**
 * Created by manojpolisetti on 19/10/15.
 */
public class VideoProduct extends Product {
    String productName;
    VideoType type;

    public VideoProduct(String productName, VideoType type) {
        super(productName);
        this.type = type;
    }

    public VideoType getType() {
        return type;
    }

}

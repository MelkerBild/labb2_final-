import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public interface Drawable {
    Point2D getPoint();

    BufferedImage getImage();
}

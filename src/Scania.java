import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Truck {
    private static BufferedImage scaniaImage;
    static {
        try {
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Scania() {
        super(2, 200, 0, Color.YELLOW, "Superyellowbigtruck", new Point2D.Double(0, 100), new Point(1, 0), 0, scaniaImage);
    }

    public void changeAngle(int new_angle) {
        if (new_angle>70 || new_angle <0){
            throw new RuntimeException("Angle can only be between 0 and 70");
        }
        else if (getCurrentSpeed() == 0){
            this.angle = new_angle;
        }
        else {
            throw new RuntimeException("Cant change angle while driving");
        }
    }



}

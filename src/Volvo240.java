import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25; // Skapa getter metod istället för att ha denna public?

    private static BufferedImage volvoImage;
    static {
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240", new Point2D.Double(0, 300), new Point(1, 0), volvoImage);
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Car{
    public boolean turboOn;
    private static BufferedImage saabImage;
    static {
        try {
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95", new Point2D.Double(0, 0), new Point(1, 0), saabImage);
	    turboOn = false;
        stopEngine();
    }
    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }



    }
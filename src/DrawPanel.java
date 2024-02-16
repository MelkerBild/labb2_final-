import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;

    BufferedImage saabImage;

    BufferedImage scaniaImage;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

     // TODO: Make this general for all cars
    void paintit(Car car, int x, int y){
        car.setPos(new Point2D.Double(x, y));
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
//        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
//        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
//        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
//    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, (int) CarController.volvo.getpoint().getX(), (int) CarController.volvo.getpoint().getY(), null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, (int) CarController.saab.getpoint().getX(), (int) CarController.saab.getpoint().getY(), null);
        g.drawImage(scaniaImage, (int) CarController.scania.getpoint().getX(), (int) CarController.scania.getpoint().getY(), null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
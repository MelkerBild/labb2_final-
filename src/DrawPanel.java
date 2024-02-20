import java.awt.*;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Model.volvo.getImage(), (int) Model.volvo.getPoint().getX(), (int) Model.volvo.getPoint().getY(), null); // see javadoc for more info on the parameters
        g.drawImage(Model.saab.getImage(), (int) Model.saab.getPoint().getX(), (int) Model.saab.getPoint().getY(), null);
        g.drawImage(Model.scania.getImage(), (int) Model.scania.getPoint().getX(), (int) Model.scania.getPoint().getY(), null);
        g.drawImage(Model.workshop.getImage(), (int) Model.workshop.getPoint().getX(), (int) Model.workshop.getPoint().getY(), null);
    }
}
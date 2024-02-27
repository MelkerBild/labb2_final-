package TheView;

import java.awt.*;
import javax.swing.*;

import TheModel.Car;
import TheModel.Model;

// This panel represents the animated part of the view with the car images.

public class View extends JPanel{
    // Initializes the panel and reads the images
    public View(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : Model.cars){
            g.drawImage(car.getImage(), (int) car.getPoint().getX(), (int) car.getPoint().getY(), null);
        }
        g.drawImage(Model.workshop.getImage(), (int) Model.workshop.getPoint().getX(), (int) Model.workshop.getPoint().getY(), null);
    }
}

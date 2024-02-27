package TheModel;

import TheView.WidgetManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Random;

public class CarButtons {
    public JButton add = new JButton("AddCar");
    public JButton remove = new JButton("RemoveCar");
    public CarButtons(WidgetManager widget, Model model){
        initComponents(widget, model);
    }
    private void initComponents(WidgetManager a, Model model) {
        a.controlPanel.add(add, 6);
        a.controlPanel.add(remove, 7);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saab95 a_saab = new Saab95();
                int maxX = WidgetManager.X;
                int maxY = WidgetManager.Y-240;
                Random randomizer = new Random();
                int randomX = randomizer.nextInt(maxX);
                int randomY = randomizer.nextInt(maxY);
                a_saab.setPos(new Point2D.Double(randomX, randomY));
                model.cars.add(a_saab);
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.cars.removeFirst();
            }
        });


    }
}

package TheControl;

import TheModel.B;
import TheModel.Model;
import TheView.WidgetManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller{
    int gasAmount = 0;
    int brakeAmount = 10;

    public Controller(WidgetManager widget, Model model){
        initComponents(widget, model);
    }
    private void initComponents(WidgetManager a, Model model) {

        a.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        a.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.gas(gasAmount);
        }
    });

    // Add this inside the initComponents method after the ActionListener for the gasButton
        a.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Call the brake method of CarController passing the current brake amount
            model.brake(brakeAmount); // You need to define brakeAmount
        }
    });

        a.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.stop();
        }
    });

        a.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.start();
        }
    });


        a.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.turboOn();
        }
    });

       a.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.turboOff();
        }
    });

        a.liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.liftBed();
        }
    });

       a.lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.lowerBed();
        }
    });
}
}

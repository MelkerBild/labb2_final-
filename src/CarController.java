import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    static Volvo240 volvo = new Volvo240();
    static Saab95 saab = new Saab95();
    static Scania scania = new Scania();

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
              for (int i = 0; i < cars.size(); i++){
                  Car car = cars.get(i);
                  car.move();
                  int x = (int) Math.round(car.getpoint().getX());
                  int y = (int) Math.round(car.getpoint().getY());
                  if (checkwalls(x) && checkworkshop(car, x, y)){
                    car.stopEngine();
                    cars.remove(car);
                }
                  else if (!checkwalls(x)) {
                    car.turnLeft();
                    car.turnLeft();
                }
                  frame.drawPanel.paintit(car, x, y);
                  frame.drawPanel.repaint();
            }
        }
    }
    boolean checkwalls(int x){
        if (x < CarView.X - frame.drawPanel.volvoImage.getWidth() && x >= 0){
            return true;
        }
        return false;
    }
    boolean checkworkshop(Car car, int x, int y){
        if (x >= frame.drawPanel.volvoWorkshopPoint.x && y >= frame.drawPanel.volvoWorkshopPoint.y && y < frame.drawPanel.volvoWorkshopPoint.y + frame.drawPanel.volvoWorkshopImage.getHeight() && car instanceof Volvo240){
            return true;
        }
        return false;
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void stop(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }
    void start(){
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void turboOn(){
        for (Car car : cars)
        {if (car instanceof Saab95 ){
             ((Saab95) car).setTurboOn();
        }
        }
    }
    void turboOff(){
        for (Car car : cars)
        {if (car instanceof Saab95 ){
            ((Saab95) car).setTurboOff();
        }
        }
    }
    void liftBed(){
        for (Car car : cars)
        {if (car instanceof Scania ){
            ((Scania) car).changeAngle(69);
        }
        }
    }
    void lowerBed(){
        for (Car car : cars)
        {if (car instanceof Scania ){
            ((Scania) car).changeAngle(0);
        }
        }
    }
}

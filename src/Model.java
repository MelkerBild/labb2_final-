import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    Observer observer;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    static Workshop<Volvo240> workshop = new Workshop(1);
    static Volvo240 volvo = new Volvo240();
    static Saab95 saab = new Saab95();
    static Scania scania = new Scania();
    Model(){
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++){
                Car car = cars.get(i);
                car.move();
                int x = (int) Math.round(car.getPoint().getX());
                int y = (int) Math.round(car.getPoint().getY());
                if (checkwalls(x, car) && checkworkshop(car, x, y)){
                    car.stopEngine();
                    cars.remove(car);
                }
                else if (!checkwalls(x, car)) {
                    car.turnLeft();
                    car.turnLeft();
                }
                observer.actOnStatusChange();
            }
        }
    }
    boolean checkwalls(int x, Car car){
        if (x < CarView.X - car.getImage().getWidth() && x >= 0){
            return true;
        }
        return false;
    }
    //frame.drawPanel.volvoImage.getWidth()
    boolean checkworkshop(Car car, int x, int y){
        if (x >= 300 && y >= 300 && y < 300 + 300 && car instanceof Volvo240){
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
    public void setObserver(Observer obj){
        observer = obj;
    }

    public Timer getTimer(){
        return this.timer;
    }

}

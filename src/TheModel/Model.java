package TheModel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    Observer observer;
    // A list of cars, modify if needed
    public static ArrayList<Car> cars = new ArrayList<>();
    public static Workshop<Volvo240> workshop = new Workshop(1);
    //static Volvo240 volvo = new Volvo240();
    //static Saab95 saab = new Saab95();
    //static Scania scania = new Scania();
    public Model(){
        new CarFactory(cars);
        //cars.add(volvo);
        //cars.add(saab);
        //cars.add(scania);
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
            }
            observer.actOnStatusChange();

        }
    }
    boolean checkwalls(int x, Car car){
        if (x < 800 - car.getImage().getWidth() && x >= 0){
            return true;
        }
        return false;
    }
    boolean checkworkshop(Car car, int x, int y){
        if (x >= workshop.getPoint().getX() && y >= workshop.getImage().getHeight() && y < workshop.getPoint().getY() + workshop.getImage().getHeight() && car instanceof Volvo240){
            return true;
        }
        return false;
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    public void stop(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }
    public void start(){
        for (Car car : cars) {
            car.startEngine();
        }
    }
    public void turboOn(){
        for (Car car : cars)
        {if (car instanceof Turbo){
            ((Turbo) car).setTurboOn();
        }
        }
    }
    public void turboOff(){
        for (Car car : cars)
        {if (car instanceof Turbo){
            ((Turbo) car).setTurboOn();
        }
        }
    }
    public void liftBed(){
        for (Car car : cars)
        {if (car instanceof Scania){
            ((Scania) car).changeAngle(69);
        }
        }
    }
    public void lowerBed(){
        for (Car car : cars)
        {if (car instanceof Scania){
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

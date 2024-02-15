import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Transport extends Truck implements Loading{
    private CargoSpace cs;
    private positionHelper poshelp;
    public Transport() {
        super(2, 200, 0, Color.YELLOW, "Superyellowbigtruck", new Point2D.Double(0, 0), new Point(1, 0), 0);
        cs = new CargoSpace(1);
        poshelp = new positionHelper();
    }
    public void changeAngle(int new_angle) {
        if (new_angle != 90 && new_angle != 0){
            throw new RuntimeException("Angle can only be up or down");
        }
        else if (getCurrentSpeed() == 0){
            this.angle = new_angle;
        }
        else {
            throw new RuntimeException("Cant change angle while driving");
        }
    }
    public void loadCargo(Car car) {
        if (getCurrentSpeed() != 0) {
            throw new RuntimeException("Cant load while driving");
        }
        else if (cs.cargo.size() == cs.maxsize) {
            throw new RuntimeException("Transport full");
        }
        else if (poshelp.avståndsFormeln(car.getpoint(), this.getpoint()) > 8) {
            throw new RuntimeException("Cargo not at transport");

        }
        else if (getAngle() != 0) {
            throw new RuntimeException("Cant load without ramp down");
        }
        else if (car instanceof Truck){
            throw new RuntimeException("Cannot load trucks asshole");
        }
        else {
            cs.cargo.push(car);
            car.setPos(this.getpoint());
        }
    }
    public Car offLoadCargo(){
        Car a_car;
        if (getCurrentSpeed() != 0){
            throw new RuntimeException("Cant offload while driving");
        }
        else if (this.getAngle() != 0){
            throw new RuntimeException("Cant offload without ramp down");
        }
        else {
            a_car = (Car) cs.cargo.pop();
            Point2D point1 = new Point2D.Double(this.getpoint().getX()-2, this.getpoint().getY()-2);
            a_car.setPos(point1);
        }
        return a_car;
    }
}

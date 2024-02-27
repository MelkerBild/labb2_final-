package TheModel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Transport extends Truck implements Loading {
    private CargoSpace cs;
    private positionHelper poshelp;

//    private static BufferedImage image;
//    static {
//        try {
//            image = ImageIO.read(View.DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public Transport() {
        super(2, 200, 0, Color.YELLOW, "Superyellowbigtruck", new Point2D.Double(0, 0), new Point(1, 0), 0, "pics/VolvoBrand.jpg");
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
            throw new RuntimeException("Model.Transport full");
        }
        else if (poshelp.avståndsFormeln(car.getPoint(), this.getPoint()) > 8) {
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
            car.setPos(this.getPoint());
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
            Point2D point1 = new Point2D.Double(this.getPoint().getX()-2, this.getPoint().getY()-2);
            a_car.setPos(point1);
        }
        return a_car;
    }
}

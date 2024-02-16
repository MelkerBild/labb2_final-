import java.awt.geom.Point2D;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Workshop <T extends Car> implements Loading{
    private CargoSpace cs;
    private positionHelper poshelp;
    private Point2D point;

    public Workshop(int maxsize) {
        cs = new CargoSpace(1);
        poshelp = new positionHelper();
        point = new Point2D.Double(0, 0);
    }
    public void loadCargo(Car car) {
        if (cs.cargo.size() >= cs.maxsize) {
            throw new RuntimeException("Workshop is full");
        }
        else if (poshelp.avståndsFormeln(car.getpoint(), this.getpoint()) > 8) {
            throw new RuntimeException("Cargo not at workshop");}
        else {
            cs.cargo.push(car);
        }
    }
    public Point2D getpoint() {
        return this.point;
    }
    public T offLoadCargo() {
        T a_car = (T) cs.cargo.pop();
        return a_car;
    }
    public Stack getCargo(){
        return cs.cargo;
    }
}
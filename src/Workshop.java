import java.awt.geom.Point2D;
import java.util.Stack;


public class Workshop <T extends Car> implements Loading{
    public CargoSpace cs;

    private LocationHelper locationHelper;

    private Point2D point;

    public Workshop(int maxsize) {
        cs = new CargoSpace(maxsize);
        locationHelper = new LocationHelper();
        point = new Point2D.Double(0, 0);
    }

    public Point2D getPoint(){
        return this.point;
    }

    @Override
    public void loadCargo(Car car) {
        if (cs.cargo.size() >= cs.maxsize) {
            throw new RuntimeException("Workshop is full");
        } else if (locationHelper.avståndsFormeln(car.getpoint(), this.getPoint()) > 8) {
            throw new RuntimeException("Cargo not at transport");}
        else {
            cs.cargo.push(car);
        }
    }

    @Override
    public T offLoadCargo() {
        T a_car = (T) cs.cargo.pop();
        return a_car;
    }
}

    
import java.awt.geom.Point2D;

public interface Loading <T extends Car>{

    void loadCargo(T car);

    public Car offLoadCargo();
    public Point2D getPoint();
}

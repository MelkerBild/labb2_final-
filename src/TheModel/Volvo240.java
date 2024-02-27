package TheModel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;
    public Volvo240(){
        super(4, 100, 0, Color.black, "Model.Volvo240", new Point2D.Double(0, 300), new Point(1, 0), "src/pics/Volvo240.jpg");
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

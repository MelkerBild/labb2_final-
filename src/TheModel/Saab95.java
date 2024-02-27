package TheModel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car {
    public boolean turboOn;

    public Saab95(){
        super(2, 125, 0, Color.red, "Model.Saab95", new Point2D.Double(0, 0), new Point(1, 0), "src/pics/Saab95.jpg");
	    turboOn = false;
        stopEngine();
    }
    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }



    }
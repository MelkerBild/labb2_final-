import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class Truck extends Car{
    public int angle;
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point2D point, Point direction, int angle, BufferedImage image){
        super(nrDoors, enginePower, currentSpeed, color, modelName, point, direction, image);
        this.angle = angle;
    }
    public int getAngle(){
        return angle;
    }
    @Override
    public void startEngine() {
        if (getAngle() == 0) {
            this.currentSpeed = 1;
        } else {
            throw new RuntimeException("Cant start if flaks angle not 0");
        }
    }
    public abstract void changeAngle(int angle);
    @Override
    public double speedFactor() {
        return 1;
    }
    @Override
    public void incrementSpeed(double amount){
        if (this.angle == 0) {
            super.incrementSpeed(amount);
        }
        else {
            throw new RuntimeException("Can't gas while angle not 0");
        }
    }
}

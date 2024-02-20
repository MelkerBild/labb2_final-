import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;

public class Workshop <T extends Car> implements Loading, Drawable{
    private CargoSpace cs;
    private positionHelper poshelp;
    private Point2D point;
    private static BufferedImage volvoWorkshopImagen;
    static {
        try {
            volvoWorkshopImagen = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Workshop(int maxsize) {
        cs = new CargoSpace(1);
        poshelp = new positionHelper();
        point = new Point2D.Double(300, 300);

    }
    public void loadCargo(Car car) {
        if (cs.cargo.size() >= cs.maxsize) {
            throw new RuntimeException("Workshop is full");
        }
        else if (poshelp.avståndsFormeln(car.getPoint(), this.getPoint()) > 8) {
            throw new RuntimeException("Cargo not at workshop");}
        else {
            cs.cargo.push(car);
        }
    }
    public Point2D getPoint() {
        return this.point;
    }
    public T offLoadCargo() {
        T a_car = (T) cs.cargo.pop();
        return a_car;
    }
    public Stack getCargo(){
        return cs.cargo;
    }

    public BufferedImage getImage(){
        return volvoWorkshopImagen;
    }
}
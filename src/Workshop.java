import java.awt.geom.Point2D;
import java.util.Stack;

import static java.lang.Math.sqrt;


public class Workshop <T extends Car>{
    private Stack<T> cargo;
    private final int maxsize;


    public Workshop(int maxsize) {
        this.cargo = new Stack<>();
        this.maxsize = maxsize;

    }


    public void loadCargo(T car) {
        if (this.cargo.size() >= this.maxsize) {
            throw new RuntimeException("Workshop is full");
        } else {
            this.cargo.push(car);
        }
    }

    public T offLoadCargo() {
        T a_car = this.cargo.pop();
        return a_car;
    }

    public Stack getCargo(){
        return this.cargo;

    }


}
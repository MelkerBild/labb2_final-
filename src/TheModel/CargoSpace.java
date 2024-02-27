package TheModel;

import java.util.Stack;

public class CargoSpace <T extends Car> {
    public Stack<T> cargo;
    public int maxsize;

    public CargoSpace(int maxsize){
        this.cargo = new Stack<>();
        this.maxsize = maxsize;
    }

    public Stack getCargo(){
        return this.cargo;
    }
}

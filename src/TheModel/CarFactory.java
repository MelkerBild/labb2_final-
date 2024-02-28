package TheModel;

import java.util.ArrayList;

public class CarFactory {
    static Volvo240 volvo = new Volvo240();
    static Saab95 saab = new Saab95();
    static Scania scania = new Scania();
    CarFactory(ArrayList<Car> array){
        array.add(volvo);
        array.add(saab);
        array.add(scania);
    }
}

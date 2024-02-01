import java.util.Stack;


public class Workshop <T extends Car> implements Loading{
    public CargoSpace cs;

    public Workshop(int maxsize) {
        cs = new CargoSpace(maxsize);
    }

    @Override
    public void loadCargo(Car car) {
        if (cs.cargo.size() >= cs.maxsize) {
            throw new RuntimeException("Workshop is full");
        } else {
            cs.cargo.push(car);
        }
    }

    @Override
    public T offLoadCargo() {
        T a_car = (T) cs.cargo.pop();
        return a_car;
    }
}
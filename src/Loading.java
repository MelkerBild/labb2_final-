public interface Loading <T extends Car>{

    void loadCargo(T car);

    public Car offLoadCargo();
}

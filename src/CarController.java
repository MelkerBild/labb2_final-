/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

import java.util.ArrayList;

public class CarController {
    public static void main(String[] args) {
        Model model = new Model();
        CarView frame = new CarView("CarSim 1.0", model);
        model.setObserver(frame);
        model.getTimer().start();
    }
}

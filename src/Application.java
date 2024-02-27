/*
* This class represents the Control.Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

import TheControl.Controller;
import TheModel.CarButtons;
import TheModel.Model;
import TheView.WidgetManager;

public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        WidgetManager widgets = new WidgetManager("CarSim 1.0");
        new Controller(widgets, model);
        new CarButtons(widgets, model);
        model.setObserver(widgets);
        model.getTimer().start();
    }
}

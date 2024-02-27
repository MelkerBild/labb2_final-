import TheModel.Saab95;
import TheModel.Volvo240;
import TheModel.Workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WorkshopTest {

    private Workshop<Saab95> wSaab;
    private Workshop wAll;
    private Workshop<Volvo240> wVolvo;
    private Saab95 saab;
    private Volvo240 volvo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        wAll = new Workshop(1);
        wVolvo = new Workshop<Volvo240>(10);
        wSaab = new Workshop<Saab95>(10);

        saab = new Saab95();
        volvo = new Volvo240();
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @org.junit.jupiter.api.Test
    void enterWorkshop1() {

        wAll.loadCargo(saab);

        Exception z = assertThrows(RuntimeException.class, ()->  wAll.loadCargo(volvo));
        assertEquals(z.getMessage(), "Model.Workshop is full");

    }

    @org.junit.jupiter.api.Test
    void enterWorkshop2() {


        wAll.loadCargo(saab);

        assert wAll.cs.getCargo().pop() == saab;

    }


    @org.junit.jupiter.api.Test
    void exitWorkshop() {

        wAll.loadCargo(saab);

        assert wAll.offLoadCargo() == saab;

    }}
/*
    @org.junit.jupiter.api.Test
    void volvoWtest(){

        wVolvo.loadCargo(saab);

    }

}*/
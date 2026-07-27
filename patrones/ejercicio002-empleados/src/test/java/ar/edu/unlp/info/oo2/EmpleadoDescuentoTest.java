package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoDescuentoTest {
    @Test 
    void descuentoEs13PorCientoDelBasicoMas5PorCientoDelAdicional(){
        EmpleadoPasante e = new EmpleadoPasante(1);
        assertEquals(2700, e.getDescuento(), 0.01);
    }  
}
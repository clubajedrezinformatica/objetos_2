package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoPasanteTest {
    @Test 
    void sinExamenesRendidosAdicionalEsCero(){
        EmpleadoPasante e = new EmpleadoPasante(0);
        assertEquals(20000, e.getBasico());
        assertEquals(0, e.getAdicional());
        assertEquals(17400, e.sueldo(), 0.01);
    }

    @Test 
    void unExamenActivaElBono(){
        EmpleadoPasante e = new EmpleadoPasante(1);
        assertEquals(2000, e.getAdicional());
        assertEquals(19300, e.sueldo(), 0.01);
    }

    @Test 
    void variosExamenesMultiplicanElBono(){
        EmpleadoPasante e = new EmpleadoPasante(3);
        assertEquals(6000, e.getAdicional());
        assertEquals(23100, e.sueldo(), 0.01);
    }
}
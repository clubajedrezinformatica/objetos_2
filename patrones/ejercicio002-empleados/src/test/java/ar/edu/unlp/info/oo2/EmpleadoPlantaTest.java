package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoPlantaTest {
    @Test 
    void pisoSinNada(){
        EmpleadoPlanta e = new EmpleadoPlanta(false, 0, 0);
        assertEquals(50000, e.getBasico());
        assertEquals(0, e.getAdicional());
        assertEquals(43500, e.sueldo(), 0.01);
    }
    
    @Test
    void casadoAgregaBonoFijo(){
        EmpleadoPlanta e = new EmpleadoPlanta(true, 0, 0);
        assertEquals(5000, e.getAdicional());
        assertEquals(48250, e.sueldo(), 0.01);
    }

    @Test 
    void hijosMultiplicanAdicional(){
        EmpleadoPlanta e = new EmpleadoPlanta(false, 2, 0);
        assertEquals(4000, e.getAdicional());
        assertEquals(47300, e.sueldo(), 0.01);
    }

    @Test 
    void casoCombinadoSinInterferenciaEntreTerminos(){
        EmpleadoPlanta e = new EmpleadoPlanta(true, 2, 3);
        assertEquals(15000, e.getAdicional());
        assertEquals(57750, e.sueldo(), 0.01);
    }
}
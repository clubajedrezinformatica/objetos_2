package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTemporarioTest {
    @Test 
    void pisoSinHorasSinCasadosSinHijos(){
        EmpleadoTemporario e = new EmpleadoTemporario(0, false, 0);
        assertEquals(20000, e.getBasico());
        assertEquals(0, e.getAdicional());
    }

    @Test 
    void horasTrabajadasMulplicanElBasico(){
        EmpleadoTemporario e = new EmpleadoTemporario(10, false, 0);
        assertEquals(23000, e.getBasico());
        assertEquals(20010, e.sueldo(), 0.01);
    }
    
    @Test 
    void casadoAgregaBonoFijo(){
        EmpleadoTemporario e = new EmpleadoTemporario(0, true, 0);
        assertEquals(5000, e.getAdicional());
        assertEquals(22150, e.sueldo(), 0.01);
        
    }

    @Test 
    void hijosMultiplicanElAdicional(){
        EmpleadoTemporario e = new EmpleadoTemporario(0, false, 2);
        assertEquals(4000, e.getAdicional());
        assertEquals(21200, e.sueldo(), 0.01);
    }

    @Test 
    void casoCombinadoSinInterferenciaEntreTerminos(){
        EmpleadoTemporario e = new EmpleadoTemporario(10, true, 1);
        assertEquals(23000, e.getBasico());
        assertEquals(7000, e.getAdicional());
        assertEquals(26660, e.sueldo(), 0.01);

    }
}

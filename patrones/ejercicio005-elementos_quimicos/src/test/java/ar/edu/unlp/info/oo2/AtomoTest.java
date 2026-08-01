package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtomoTest {

    @Test 
    void formulaDevuelveElSimbolo() {
        Atomo hidrogeno = new Atomo("H", 1, 1, false); 
        assertEquals("H", hidrogeno.formula());
    }

    @Test 
    void pesoMolecularDevuelveElPropioPeso(){
        Atomo oxigeno = new Atomo("O", 16, -2, false);
        assertEquals(16, oxigeno.pesoMolecular());
    }

    @Test 
    void cargaAtomicaDevuelveLaPropiaCarga(){
        Atomo calcio = new Atomo("Ca", 40, 2, true);
        assertEquals(2, calcio.carga());
    }

    @Test 
    void unAtomoSiempreEsValido(){
        assertTrue(new Atomo("Na", 23, 1, true).esValida());
    }

    @Test 
    void esMetalDevuelveLoConfigurado(){
        assertTrue(new Atomo("Na", 23, 1, true).esMetal());
        assertFalse(new Atomo("H", 1, 1, false).esMetal());
    }
    
}

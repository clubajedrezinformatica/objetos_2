package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test de unidad para el juego Piedra, Papel o Tijera
 */
public class JuegoTest { 
    
    Opcion piedra, papel, tijera;
    
    @BeforeEach
    void setUp() throws Exception {
        // Inicializamos nuestras opciones siguiendo el modelo de la cátedra
        piedra = new Piedra();
        papel = new Papel();
        tijera = new Tijera();
    }
    
    @Test
    public void testBatallas() {
        // Testeamos todas las combinaciones posibles
        assertEquals("Gana Papel", piedra.jugarContra(papel));
        assertEquals("Gana Piedra", tijera.jugarContra(piedra));
        assertEquals("Gana Tijera", papel.jugarContra(tijera));
        
        // Testeamos empates
        assertEquals("Empate", piedra.jugarContra(new Piedra()));
        assertEquals("Empate", papel.jugarContra(new Papel()));
    }
}
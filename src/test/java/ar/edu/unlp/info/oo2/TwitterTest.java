package ar.edu.unlp.info.oo2; // Debe coincidir con tu carpeta

import static org.junit.jupiter.api.Assertions.*; // Para los asserts
import org.junit.jupiter.api.BeforeEach; // Para configurar datos antes de cada test
import org.junit.jupiter.api.Test; // La anotación de test

public class TwitterTest {
    
    private Twitter sistema;

    @BeforeEach
    void setUp() {
        // Inicializamos el sistema antes de cada test
        sistema = new Twitter();
    }

    @Test
    void testAgregarUsuarioUnico() {
        // Escenario: Agregamos un usuario por primera vez
        Usuario u1 = sistema.agregarUsuario("mauro_lp");
        assertNotNull(u1);
        assertEquals("mauro_lp", u1.getScreenName());
        
        // Escenario: Intentamos agregar el mismo nombre
        Usuario u2 = sistema.agregarUsuario("mauro_lp");
        assertNull(u2, "No debería permitir duplicados");
    }
}
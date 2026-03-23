package ar.edu.unlp.info.oo2; // Debe coincidir con tu carpeta

import static org.junit.jupiter.api.Assertions.*; // Para los asserts
import org.junit.jupiter.api.BeforeEach; // Para configurar datos antes de cada test
import org.junit.jupiter.api.Test; // La anotación de test

public class TwitterTest {
    
    private Twitter sistema;

    @BeforeEach
    void setUp() {
        sistema = new Twitter();
    }

    @Test
    void testAgregarUsuarioUnico() {
        Usuario u1 = sistema.agregarUsuario("mauro_lp");
        assertNotNull(u1);
        assertEquals("mauro_lp", u1.getScreenName());
        
        Usuario u2 = sistema.agregarUsuario("mauro_lp");
        assertNull(u2, "No debería permitir duplicados");
    }

    @Test 
    void testPostearTweetValido(){
        Usuario u1 = sistema.agregarUsuario("user1");
        Tweet t = u1.postearTweet("Tweet válido");
        assertNotNull(t);
        assertEquals("Tweet válido", t.getTexto());
    }

    @Test
    void testPostearTweetInvalido() {
        Usuario u1 = sistema.agregarUsuario("user1");
        
        // Caso 1: Texto vacío (falla el mínimo de 1 carác.)
        assertThrows(IllegalArgumentException.class, () -> u1.postearTweet(""));
        
        // Caso 2: Texto demasiado largo (> 280)
        String textoLargo = "a".repeat(281);
        assertThrows(IllegalArgumentException.class, () -> u1.postearTweet(textoLargo));
    }

    @Test
    void testRetweetPolimorfico() {
        Usuario u1 = sistema.agregarUsuario("autor");
        Tweet original = u1.postearTweet("Contenido original");
        
        Usuario u2 = sistema.agregarUsuario("replicador");
        Tweet retweet = u2.postearRetweet(original);
        
        // El retweet debe devolver el texto del original por delegación
        assertEquals("Contenido original", retweet.getTexto());
    }

    @Test
    void testEliminarUsuario() {
        sistema.agregarUsuario("user_a_borrar");
        sistema.eliminarUsuario("user_a_borrar");
        
        // Al borrarlo, el screenName debería quedar disponible nuevamente
        assertNotNull(sistema.agregarUsuario("user_a_borrar"), 
            "El usuario no fue eliminado correctamente del sistema");
    }
}
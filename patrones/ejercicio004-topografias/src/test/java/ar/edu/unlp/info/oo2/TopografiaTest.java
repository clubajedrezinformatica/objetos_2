package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TopografiaTest {
    private Mixta topografiaEjemplo;
    private Agua agua;
    private Tierra tierra;

    @BeforeEach
    public void setUp() {
        agua = new Agua();
        tierra = new Tierra();
        topografiaEjemplo = new Mixta(
            new Agua(),
            new Tierra(),
            new Tierra(),
            new Agua()
        );
    }

    @Test 
    public void proporcionDeAguaUno(){
        assertEquals(1, agua.proporcionAgua(), 0.0001);
    }

    @Test 
    public void proporcionDeAguaCero(){
        assertEquals(0, tierra.proporcionAgua(), 0.0001);
    }

    @Test 
    public void proporcionesComplementarias(){
        assertEquals(1-agua.proporcionAgua(), agua.proporcionTierra(), 0.0001);
        assertEquals(1-tierra.proporcionAgua(), tierra.proporcionTierra(), 0.0001);
    }

    @Test 
    public void proporcionDeAguaMixta(){
        assertEquals(0.5, topografiaEjemplo.proporcionAgua(), 0.0001);
    }

    @Test 
    public void proporcionAguaConAnidacion(){
        Mixta otraMixta = new Mixta(new Agua(), new Tierra(), new Tierra(), new Tierra());
        Mixta mixta = new Mixta(new Agua(), new Agua(), otraMixta, new Tierra());
        assertEquals(0.5625, mixta.proporcionAgua(), 0.0001);
    }

    @Test 
    public void aguasSonIguales(){
        assertEquals(agua, new Agua());
    }

    @Test 
    public void tierraYAguaNoSonIguales(){
        assertNotEquals(tierra, agua);
    }

    @Test 
    public void mixtasConMismosComponentesSonIguales(){
        Mixta m1 = new Mixta(new Agua(), new Tierra(), new Tierra(), new Agua());
        Mixta m2 = new Mixta(new Agua(), new Tierra(), new Tierra(), new Agua());
        assertEquals(m1, m2);
    }

    @Test 
    public void mixtasConDiferentesComponentesNoSonIguales(){
        Mixta m1 = new Mixta(new Agua(), new Tierra(), new Tierra(), new Agua());
        Mixta m2 = new Mixta(new Agua(), new Tierra(), new Tierra(), new Tierra());
        assertNotEquals(m1, m2);
    }
}
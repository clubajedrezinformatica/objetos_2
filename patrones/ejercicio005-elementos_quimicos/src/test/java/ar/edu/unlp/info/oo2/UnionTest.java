package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnionTest {
    private final Atomo h1 = new Atomo("H", 1, 1, false);
    private final Atomo h2 = new Atomo("H", 1, 1, false);
    private final Atomo o = new Atomo("O", 16, -2, false);
    private final Atomo sodio = new Atomo("Na", 16, 1, true); 
    private final Atomo cloro = new Atomo("Cl", 35, -1, false);
    private final Atomo calcio = new Atomo("Ca", 40, 2, true);

    @Test 
    void formulaAgrupaElementosRepetido(){
        Union agua = new Union(h1, h2, o);
        assertEquals("H2O", agua.formula());
    }

    @Test
    void formulaSinRepeticion(){
        assertEquals("NaCl", new Union(sodio, cloro).formula());
    }

    @Test 
    void pesoMolecularSumaLosElementos(){
        assertEquals(18, new Union(h1, h2, o).pesoMolecular());
    }

    @Test 
    void cargaSumaLosElementos(){
        assertEquals(0, new Union(sodio, cloro).carga());
    }

    @Test 
    void metalMasNoMetalEsValido(){
        assertTrue(new Union(sodio, cloro).esValida());
    }

    @Test 
    void noMetalMasNoMetalNoEsValido(){
        assertTrue(new Union(h1, h2, o).esValida());
    }

    @Test 
    void metalMasMetalNoEsValido(){
        assertFalse(new Union(sodio, calcio).esValida());
    }

    @Test 
    void validezEsRecursivaSobreUnionesAnidadas(){
        Union interna = new Union(sodio, calcio);
        Union externa = new Union(interna, o);
        assertFalse(externa.esValida());
    }

    @Test 
    void esMetalDeUnionAnidadaAfectaValidezEnNivelSuperior(){
        Union hidroxido = new Union(o, h1); 
        Union externa = new Union(hidroxido, calcio);
        assertTrue(externa.esValida());
    }

    @Test 
    void agregarElementoModificaLaUnion(){
        Union union = new Union(sodio);
        union.agregarElemento(cloro);
        assertEquals("NaCl", union.formula());
    }

    @Test 
    void eliminarElementoModificaLaUnion(){
        Union union = new Union(sodio, cloro);
        union.eliminarElemento(cloro);
        assertEquals("Na", union.formula());
    }

    @Test 
    void unAtomoNoAdmiteAgregarElementos(){
        assertThrows(UnsupportedOperationException.class, () -> h1.agregarElemento(o));
    }
    
}

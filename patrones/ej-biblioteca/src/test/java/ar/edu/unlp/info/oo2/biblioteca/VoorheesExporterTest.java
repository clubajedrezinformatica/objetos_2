package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class VoorheesExporterTest {

    private static final String NL = System.lineSeparator();
    private final VoorheesExporter exporter = new VoorheesExporter();

    @Test
    void exportaListaVaciaComoArrayVacio() {
        assertEquals("[]", exporter.exportar(List.of()));
    }

    @Test
    void exportaUnSocio() {
        Socio arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        String esperado = "[" + NL
            + "\t{" + NL
            + "\t\t\"nombre\": \"Arya Stark\"," + NL
            + "\t\t\"email\": \"needle@stark.com\"," + NL
            + "\t\t\"legajo\": \"5234-5\"" + NL
            + "\t}" + NL
            + "]";
        assertEquals(esperado, exporter.exportar(List.of(arya)));
    }

    @Test
    void exportaMultiplesSociosSeparadosPorComa() {
        Socio arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        Socio tyrion = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
        String resultado = exporter.exportar(List.of(arya, tyrion));

        assertTrue(resultado.startsWith("[" + NL));
        assertTrue(resultado.endsWith(NL + "]"));
        assertTrue(resultado.contains("\"nombre\": \"Arya Stark\""));
        assertTrue(resultado.contains("\"nombre\": \"Tyron Lannister\""));
        // Verifica la coma+separador exactos entre el primer bloque y el segundo
        assertTrue(resultado.contains("\t}," + NL + "\t{"));
    }
}

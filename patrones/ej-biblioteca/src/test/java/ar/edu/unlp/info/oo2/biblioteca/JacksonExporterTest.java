package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List; 

class JacksonExporterTest {

    private final JacksonExporter exporter = new JacksonExporter();

    @Test
    void exportaListaVaciaComoArrayVacio() {
        assertEquals("[]", exporter.exportar(List.of()));
    }

    @Test
    void exportaUnSocioConLosTresCampos() {
        Socio arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        String resultado = exporter.exportar(List.of(arya));

        assertTrue(resultado.contains("\"nombre\":\"Arya Stark\""));
        assertTrue(resultado.contains("\"email\":\"needle@stark.com\""));
        assertTrue(resultado.contains("\"legajo\":\"5234-5\""));
    }
}
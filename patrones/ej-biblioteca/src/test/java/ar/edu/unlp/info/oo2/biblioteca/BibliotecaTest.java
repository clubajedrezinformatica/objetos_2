package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List; 
import java.util.ArrayList;

class BibliotecaTest {

    @Test
    void bibliotecaUsaVoorheesExporterPorDefecto() {
        Biblioteca biblioteca = new Biblioteca();
        assertTrue(biblioteca.getExporter() instanceof VoorheesExporter);
    }

    @Test
    void exportarSociosDevuelveLoQueRetornaElExporterInyectado() {
        Exporter stub = socios -> "JSON_FALSO";
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setExporter(stub);
        biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));

        assertEquals("JSON_FALSO", biblioteca.exportarSocios());
    }

    @Test
    void exportarSociosLePasaAlExporterLaListaCorrectaDeSocios() {
        List<Socio> capturados = new ArrayList<>();
        Exporter spy = socios -> { capturados.addAll(socios); return ""; };

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setExporter(spy);
        Socio arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        biblioteca.agregarSocio(arya);

        biblioteca.exportarSocios();

        assertEquals(List.of(arya), capturados);
    }
}
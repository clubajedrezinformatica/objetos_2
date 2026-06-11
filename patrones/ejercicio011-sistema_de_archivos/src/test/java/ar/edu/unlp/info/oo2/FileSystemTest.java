package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

public class FileSystemTest {
    private Directorio raiz, nodo;
    private Archivo archivo1, archivo2, archivo3;

    @BeforeEach
    public void setUp() {
        raiz = new Directorio("raiz", LocalDateTime.of(2025, 1, 1, 0, 0)); 
        nodo = new Directorio("nodo", LocalDateTime.of(2025, 6, 1, 0, 0)); 

        archivo1 = new Archivo("prueba.txt", LocalDateTime.of(2025, 3, 15, 10, 0), 28);
        archivo2 = new Archivo("otraPrueba.md", LocalDateTime.of(2026, 1, 10, 14, 30), 50);
        archivo3 = new Archivo("prueba.txt", LocalDateTime.of(2025, 5, 1, 12, 0), 15);

        raiz.agregar(archivo1);
        raiz.agregar(nodo);
        nodo.agregar(archivo2);
        nodo.agregar(archivo3);
    }

    @Test 
    void tamanoTotalOcupado() {
        assertEquals(157, raiz.tamanoTotalOcupado());
    }
    @Test 
    void archivoMasNuevo() {
        assertEquals(archivo2, raiz.archivoMasNuevo());
    }
    @Test 
    void archivoMasGrande() {
        assertEquals(archivo2, raiz.archivoMasGrande());
    }
    @Test 
    void buscar() {
        FileSystem a = raiz.buscar("prueba.txt");
        assertEquals(archivo1.getNombre(), a.getNombre());
    }
    @Test 
    void buscarConNombreInexistenteDevuelveNull() {
        FileSystem a = raiz.buscar("inexistente.txt");
        assertNull(a);
    }
    @Test 
    void buscarTodosConMultiplesMatchesDevuelveTodos(){
        List<FileSystem> encontrados = raiz.buscarTodos("prueba.txt");
        assertEquals(2, encontrados.size());
    }
    @Test 
    void buscarTodosDevuelveLosElementosCorrectos(){
        List<FileSystem> encontrados = raiz.buscarTodos("prueba.txt");
        assertTrue(encontrados.contains(archivo1));
        assertTrue(encontrados.contains(archivo3));
    }
    @Test 
    void buscarTodosConNombreInexistenteDevuelveListaVacia(){
        List<FileSystem> encontrados = raiz.buscarTodos("inexistente.txt");
        assertTrue(encontrados.isEmpty());
    }
    @Test
    void listadoDeContenido() {
        String esperado = "/raiz\n/raiz/prueba.txt\n/raiz/nodo\n/raiz/nodo/otraPrueba.md\n/raiz/nodo/prueba.txt";
        assertEquals(esperado, raiz.listadoDeContenido());
    }
}
package ar.edu.unlp.info.oo2;

import java.util.List;
import java.time.LocalDateTime;

public abstract class FileSystem {
    private String nombre; 
    private LocalDateTime fechaDeCreacion;
    
    public FileSystem(String nombre, LocalDateTime fechaDeCreacion) {
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public LocalDateTime getFechaDeCreacion() {
        return this.fechaDeCreacion;
    }

    public abstract int tamanoTotalOcupado();
    public abstract Archivo archivoMasNuevo();
    public abstract Archivo archivoMasGrande();
    public abstract FileSystem buscar(String nombre);
    public abstract List<FileSystem> buscarTodos(String nombre); 
    protected abstract String listadoDeContenido(String pathPadre);
    public String listadoDeContenido() {
        return this.listadoDeContenido("");
    }   
}
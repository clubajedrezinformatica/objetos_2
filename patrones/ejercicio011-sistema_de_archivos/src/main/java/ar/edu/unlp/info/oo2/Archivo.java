package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Archivo extends FileSystem {
    private int tamano;

    public Archivo(String nombre, LocalDateTime fechaDeCreacion, int tamano) {
        super(nombre, fechaDeCreacion);
        this.tamano = tamano;
    }

    @Override
    public int tamanoTotalOcupado() {
        return this.tamano;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public FileSystem buscar(String nombre) {
        if (this.getNombre().equals(nombre)) {
            return this;
        }
        return null;
    }

    @Override
    public List<FileSystem> buscarTodos(String nombre) {
        List<FileSystem> resultado = new ArrayList<>();
        if (this.getNombre().equals(nombre)) {
            resultado.add(this);
        }
        return resultado;
    }
    
    @Override
    protected String listadoDeContenido(String pathPadre) {
        return pathPadre + "/" + this.getNombre();
    }
}
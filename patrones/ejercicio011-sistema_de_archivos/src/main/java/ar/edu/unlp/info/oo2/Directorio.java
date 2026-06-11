package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Directorio extends FileSystem {
    private List<FileSystem> contenido;

    public Directorio(String nombre, LocalDateTime fechaDeCreacion) {
        super(nombre, fechaDeCreacion);
        this.contenido = new ArrayList<FileSystem>();
    }

    public void agregar(FileSystem fs) {
        this.contenido.add(fs);
    }

    @Override
    public int tamanoTotalOcupado() {
        return 32 + this.contenido.stream() 
            .mapToInt(fs -> fs.tamanoTotalOcupado())
            .sum();
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this.contenido.stream() 
            .map(fs -> fs.archivoMasNuevo())
            .max((fs1, fs2) -> fs1.getFechaDeCreacion().compareTo(fs2.getFechaDeCreacion()))
            .orElse(null);
    }

    @Override
    public Archivo archivoMasGrande() {
        return this.contenido.stream()  
            .map(fs -> fs.archivoMasGrande()) 
            .max((fs1, fs2) -> Integer.compare(fs1.tamanoTotalOcupado(), fs2.tamanoTotalOcupado()))
            .orElse(null);
    }

    @Override
    public FileSystem buscar(String nombre) {
        if (this.getNombre().equals(nombre)) {
            return this;
        }
        return this.contenido.stream()
            .map(fs -> fs.buscar(nombre))
            .filter(fs -> fs != null)
            .findFirst()
            .orElse(null);
    }

    @Override 
    public List<FileSystem> buscarTodos(String nombre){
        List<FileSystem> resultado = new ArrayList<>();
        if(this.getNombre().equals(nombre)) {
            resultado.add(this); 
        }
        List<FileSystem> matchDeHijos = this.contenido.stream() 
            .flatMap(fs -> fs.buscarTodos(nombre).stream())
            .collect(Collectors.toList());
        resultado.addAll(matchDeHijos);
        return resultado;
    }

    @Override 
    protected String listadoDeContenido(String pathPadre) {
        String miPath = pathPadre + "/" + this.getNombre();
        String lineasDeHijos = this.contenido.stream() 
            .map(fs -> fs.listadoDeContenido(miPath))
            .collect(Collectors.joining("\n"));
        if (lineasDeHijos.isEmpty()) {
            return miPath;
        }
        return miPath + "\n" + lineasDeHijos;
    }

}
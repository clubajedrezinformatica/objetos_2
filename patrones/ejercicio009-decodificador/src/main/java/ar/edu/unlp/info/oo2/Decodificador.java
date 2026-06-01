package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Decodificador {
    private List<Pelicula> grilla;
    private Set<Pelicula> reproducidas;
    private EstrategiaSugerencia estrategia;

    public Decodificador(EstrategiaSugerencia estrategia) {
        this.grilla = new ArrayList<>();
        this.reproducidas = new HashSet<>();
        this.estrategia = estrategia;
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.grilla.add(pelicula);
    }

    public void reproducirPelicula(Pelicula pelicula) {
        if (this.grilla.contains(pelicula)) {
            this.reproducidas.add(pelicula);
        }
    }

    public void setEstrategia(EstrategiaSugerencia estrategia) {
        this.estrategia = estrategia;
    }

    public List<Pelicula> sugerir() {
        return this.estrategia.sugerir(this);
    }

    public List<Pelicula> getGrilla() {
        return this.grilla;
    }

    public Set<Pelicula> getReproducidas() {
        return this.reproducidas;
    }
    
}

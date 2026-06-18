package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;

public class Catalogo {
    private List<Componente> componentes;
    
    public Catalogo(){
        this.componentes = new ArrayList<>();
        componentes.add(new Componente("Procesador", "Procesador Básico", 30000, 65));
        componentes.add(new Componente("Procesador", "Procesador Intermedio", 60000, 95));
        componentes.add(new Componente("Procesador", "Procesador Gamer", 150000, 125));
        componentes.add(new Componente("Pad", "Pad Térmico", 2000, 0));
        componentes.add(new Componente("Cooler", "Cooler", 8000, 5));
        componentes.add(new Componente("Memoria", "Memoria RAM 8GB", 15000, 5  ));
        componentes.add(new Componente("Memoria", "Memoria RAM 16GB", 28000, 8));
        componentes.add(new Componente("Memoria", "Memoria RAM 32GB", 50000, 12));
        componentes.add(new Componente("Disco", "HDD 500GB", 12000, 10));
        componentes.add(new Componente("Disco", "SSD 500GB", 25000, 5));
        componentes.add(new Componente("Disco", "SSD 1TB", 45000, 7));
        componentes.add(new Componente("Tarjeta", "", 0, 0));
        componentes.add(new Componente("Tarjeta", "GTX 1650", 80000, 75));
        componentes.add(new Componente("Tarjeta", "RTX 4090", 1200000, 450));
        componentes.add(new Componente("Gabinete", "Gabinete Estándar", 25000, 0));
        componentes.add(new Componente("Gabinete", "Gabinete Intermedio + Fuente 800w", 60000, 0));
        componentes.add(new Componente("Gabinete", "Gabinete Gamer", 80000, 0));
        componentes.add(new Componente("Fuente", "Fuente 450 w", 25000, 0));
        componentes.add(new Componente("Fuente", "Fuente 600 w", 35000, 0));
        componentes.add(new Componente("Fuente", "Fuente 850 w", 50000, 0));
        componentes.add(new Componente("Fuente", "Fuente 924 w", 60000, 0));
        componentes.add(new Componente("Fuente", "Fuente 1000 w", 70000, 0));
        componentes.add(new Componente("Fuente", "Fuente 1200 w", 95000, 0));
    }

    public Componente getComponente(String descripcion){
        return this.componentes.stream()
            .filter(c -> c.getDescripcion().equals(descripcion))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Componente no encontrado"));
    }

    public int tamano(){
        return this.componentes.size();
    }
}

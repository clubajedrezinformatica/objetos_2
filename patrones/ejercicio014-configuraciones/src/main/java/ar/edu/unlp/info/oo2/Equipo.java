package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;

public class Equipo {
    private List<Componente> componentes;
    private static final double IVA = 0.21;

    public Equipo() {
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(Componente componente) {
        this.componentes.add(componente);
    }

    public double calcularConsumoTotal(){
        return this.componentes.stream()
            .mapToDouble(c -> c.getConsumo())
            .sum();
    }

    public double calcularPrecioTotal(){
        double subtotal = this.componentes.stream()
            .mapToDouble(c -> c.getPrecio())
            .sum();
        return subtotal * (1 + IVA); 
    }

    public int tamano(){
        return this.componentes.size();
    }
}

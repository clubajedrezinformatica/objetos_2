package ar.edu.unlp.info.oo2;

import java.time.LocalDate;

public class Empresa {
    private Catalogo catalogo;

    public Empresa(){
        this.catalogo = new Catalogo();
    }

    public Presupuesto crearPresupuesto(Configuracion configuracion, String solicitante) {
        Equipo equipo = configuracion.armarEquipo();
        return new Presupuesto(solicitante, LocalDate.now(), equipo);
    }

    public Catalogo getCatalogo(){
        return this.catalogo;
    }
    
}

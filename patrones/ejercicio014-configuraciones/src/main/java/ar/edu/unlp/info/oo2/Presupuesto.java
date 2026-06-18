package ar.edu.unlp.info.oo2;

import java.time.LocalDate;

public class Presupuesto {
    private String solicitante;
    private LocalDate fecha;
    private Equipo equipo;

    public Presupuesto(String solicitante, LocalDate fecha, Equipo equipo){
        this.solicitante = solicitante;
        this.fecha = fecha;
        this.equipo = equipo;
    }

    public String getSolicitante(){
        return this.solicitante;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public Equipo getEquipo(){
        return this.equipo;
    }

    public double calcularConsumo(){
        return this.equipo.calcularConsumoTotal();
    }

    public double calcularPrecio(){
        return this.equipo.calcularPrecioTotal();
    }
    
}

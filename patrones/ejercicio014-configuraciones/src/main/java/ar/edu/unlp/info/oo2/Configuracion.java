package ar.edu.unlp.info.oo2;

public abstract class Configuracion {
    protected Catalogo catalogo;

    public Configuracion(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Equipo armarEquipo() {
        Equipo equipo = new Equipo();
        equipo.agregarComponente(this.crearProcesador());
        equipo.agregarComponente(this.crearMemoria());
        equipo.agregarComponente(this.crearDisco());
        equipo.agregarComponente(this.crearTarjeta());
        equipo.agregarComponente(this.crearGabinete(equipo.calcularConsumoTotal()));
        return equipo;
    }

    protected abstract Componente crearProcesador();
    protected abstract Componente crearMemoria();
    protected abstract Componente crearDisco();
    protected abstract Componente crearTarjeta();
    protected abstract Componente crearGabinete(double consumoParcial);
}

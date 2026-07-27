package ar.edu.unlp.info.oo2;

public class EmpleadoPlanta extends Empleado {
    private final boolean casado; 
    private final int hijos; 
    private final int aniosAntiguedad; 

    public EmpleadoPlanta(boolean casado, int hijos, int aniosAntiguedad){
        this.casado = casado;
        this.hijos = hijos;
        this.aniosAntiguedad = aniosAntiguedad;
    }

    @Override 
    protected double getBasico(){
        return 50000; 
    }

    @Override 
    protected double getAdicional(){
        return (casado ? 5000 : 0) + hijos * 2000 + aniosAntiguedad * 2000;
    }
}

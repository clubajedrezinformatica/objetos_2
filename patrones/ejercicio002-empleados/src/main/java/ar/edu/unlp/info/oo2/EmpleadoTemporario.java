package ar.edu.unlp.info.oo2;

public class EmpleadoTemporario extends Empleado {
    private final double horasTrabajadas;
    private final boolean casado;
    private final int hijos;

    public EmpleadoTemporario(double horasTrabajadas, boolean casado, int hijos){
        this.horasTrabajadas = horasTrabajadas;
        this.casado = casado;
        this.hijos = hijos;
    }

    @Override 
    protected double getBasico(){
        return 20000 + horasTrabajadas * 300;
    }

    @Override
    protected double getAdicional(){
        return (casado ? 5000 : 0) + hijos * 2000;
    }
}

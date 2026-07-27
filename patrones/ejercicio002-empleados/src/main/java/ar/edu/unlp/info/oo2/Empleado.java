package ar.edu.unlp.info.oo2;

public abstract class Empleado {
    public final double sueldo(){
        return  getBasico() + getAdicional() - getDescuento();
    }

    protected abstract double getBasico();

    protected abstract double getAdicional();

    protected double getDescuento(){
        return 0.13 * getBasico() + 0.05 * getAdicional();
    }
    
}

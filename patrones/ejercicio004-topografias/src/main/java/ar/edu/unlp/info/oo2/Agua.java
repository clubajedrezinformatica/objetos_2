package ar.edu.unlp.info.oo2;

public class Agua extends Topografia {
    @Override
    public double proporcionAgua() {
        return 1;
    }

    @Override 
    public boolean equals(Object o) {
        return o instanceof Agua;
    }

    @Override
    public int hashCode() {
        return 1;  
    }
}
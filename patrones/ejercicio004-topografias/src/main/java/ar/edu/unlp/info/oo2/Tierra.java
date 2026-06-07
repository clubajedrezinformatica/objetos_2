package ar.edu.unlp.info.oo2;

public class Tierra extends Topografia {
    @Override
    public double proporcionAgua() {
        return 0;
    }

    @Override 
    public boolean equals(Object o) {
        return o instanceof Tierra;
    }

    @Override
    public int hashCode() {
        return 0;  
    }
}
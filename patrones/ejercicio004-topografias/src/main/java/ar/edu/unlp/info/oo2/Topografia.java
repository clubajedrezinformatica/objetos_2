package ar.edu.unlp.info.oo2;
public abstract class Topografia {
    public abstract double proporcionAgua();
    public double proporcionTierra() {
        return 1 - this.proporcionAgua();
    }
}
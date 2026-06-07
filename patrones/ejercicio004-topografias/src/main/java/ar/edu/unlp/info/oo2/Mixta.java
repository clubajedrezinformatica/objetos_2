package ar.edu.unlp.info.oo2;
import java.util.List;

public class Mixta extends Topografia {
    private List<Topografia> celdas;

    public Mixta(Topografia t1, Topografia t2, Topografia t3, Topografia t4) {
        if(t1 == null || t2 == null || t3 == null || t4 == null) {
            throw new IllegalArgumentException("Las topografias deben estar compuestas por 4 celdas");
        }
        this.celdas = List.of(t1, t2, t3, t4);
    }

    @Override
    public double proporcionAgua() {
        return celdas.stream().mapToDouble(c -> c.proporcionAgua()).sum() / 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mixta)) return false;
        Mixta otra = (Mixta) o;
        return this.celdas.equals(otra.celdas);
    }

    @Override
    public int hashCode() {        
        return this.celdas.hashCode();
    }
}
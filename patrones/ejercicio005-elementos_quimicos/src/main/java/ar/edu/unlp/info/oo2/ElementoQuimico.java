package ar.edu.unlp.info.oo2;

public abstract class ElementoQuimico {

    public abstract String formula();
    public abstract int pesoMolecular();
    public abstract int carga();
    public abstract boolean esValida(); 
    public abstract boolean esMetal();

    public void agregarElemento(ElementoQuimico elemento) {
        throw new UnsupportedOperationException("Un átomo no admite sub-elementos");
    }

    public void eliminarElemento(ElementoQuimico elemento) {
        throw new UnsupportedOperationException("Un átomo no admite sub-elementos");
    }

}

package ar.edu.unlp.info.oo2;

public class Atomo extends ElementoQuimico {
    private final String simbolo;
    private final int pesoAtomico;
    private final int cargaElectrica;
    private final boolean esMetal;

    public Atomo(String simbolo, int pesoAtomico, int cargaElectrica, boolean esMetal) {
        this.simbolo = simbolo;
        this.pesoAtomico = pesoAtomico;
        this.cargaElectrica = cargaElectrica;
        this.esMetal = esMetal; 
    }

    @Override 
    public String formula(){
        return this.simbolo;
    }
    @Override 
    public int pesoMolecular(){
        return this.pesoAtomico;
    }
    @Override
    public int carga(){
        return this.cargaElectrica;
    }
    @Override
    public boolean esValida(){
        return true;
    }
    @Override
    public boolean esMetal(){
        return this.esMetal;
    }
}
    
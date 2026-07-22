package ar.edu.unlp.info.oo2;

public class Papel implements Opcion {
    @Override
    public String jugarContra(Opcion otra) {
        return otra.contraPapel(); // Le digo a la otra: "Atención, soy Papel"
    }

    @Override
    public String contraPiedra() { return "Gana Papel"; }
    @Override
    public String contraPapel() { return "Empate"; }
    @Override
    public String contraTijera() { return "Gana Tijera"; }
}
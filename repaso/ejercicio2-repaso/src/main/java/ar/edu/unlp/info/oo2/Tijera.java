package ar.edu.unlp.info.oo2;

public class Tijera implements Opcion {
    @Override
    public String jugarContra(Opcion otra) {
        return otra.contraTijera(); // Le digo a la otra: "Atención, soy Tijera"
    }

    @Override
    public String contraPiedra() { return "Gana Piedra"; }
    @Override
    public String contraPapel() { return "Gana Tijera"; }
    @Override
    public String contraTijera() { return "Empate"; }
}
package ar.edu.unlp.info.oo2;

public class Piedra implements Opcion {
    @Override
    public String jugarContra(Opcion otra) {
        return otra.contraPiedra(); // Le digo a la otra: "Atención, soy Piedra"
    }

    @Override
    public String contraPiedra() { return "Empate"; }
    @Override
    public String contraPapel() { return "Gana Papel"; } // Papel envuelve Piedra
    @Override
    public String contraTijera() { return "Gana Piedra"; } // Piedra rompe Tijera
}
package ar.edu.unlp.info.oo2;

public interface Opcion {
    String jugarContra(Opcion otra);

    String contraPiedra();
    String contraPapel();
    String contraTijera();
}

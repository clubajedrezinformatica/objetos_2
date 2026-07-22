package ar.edu.unlp.info.oo2;

public class TweetOriginal extends Tweet {
    private String texto; 

    public TweetOriginal(String texto){
        if (texto == null || texto.length() < 1 || texto.length() > 280){
            throw new IllegalArgumentException("Invalid text length");
        }
        this.texto = texto; 
    }

    @Override 
    public String getTexto(){
        return this.texto;
    }
}

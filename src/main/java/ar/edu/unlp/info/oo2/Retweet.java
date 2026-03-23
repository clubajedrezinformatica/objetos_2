package ar.edu.unlp.info.oo2;

public class Retweet extends Tweet{
    private Tweet origen;

    public Retweet(Tweet origen){
        this.origen = origen;
    }

    @Override 
    public String getTexto(){
        return origen.getTexto();
    }
    
}

package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<Tweet> tweets; 

    public Usuario(String screenName){
        this.screenName = screenName;
        this.tweets = new ArrayList<>();
    }

    public Tweet postearTweet(String texto){
        Tweet nuevo = new TweetOriginal(texto);
        this.tweets.add(nuevo);
        return nuevo;
    }
    
    public Tweet postearRetweet(Tweet origen){
        Tweet nuevo = new Retweet(origen);
        this.tweets.add(nuevo);
        return nuevo;
    }

    public void eliminarMisTweets() {
        this.tweets.clear(); 
    }

    public String getScreenName(){
        return this.screenName;
    }

}

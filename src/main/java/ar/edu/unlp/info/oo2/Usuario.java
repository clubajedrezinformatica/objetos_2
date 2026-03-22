package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<Object> tweets; 

    public Usuario(String screenName){
        this.screenName = screenName;
        this.tweets = new ArrayList<>();
    }

    public String getScreenName(){
        return this.screenName;
    }

}

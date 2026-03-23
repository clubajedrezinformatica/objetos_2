package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario agregarUsuario(String screenName) {
        for (Usuario u : usuarios) {
            if (u.getScreenName().equals(screenName)) {
                return null; 
            }
        }
        
        Usuario nuevo = new Usuario(screenName); 
        this.usuarios.add(nuevo);
        return nuevo;
    }

    public void eliminarUsuario(String screenName){
        Usuario aEliminar = this.usuarios.stream()
            .filter(u -> u.getScreenName().equals(screenName))
            .findFirst()
            .orElse(null);
        if (aEliminar != null) {
            aEliminar.eliminarMisTweets();
            this.usuarios.remove(aEliminar);
        }
    }
}

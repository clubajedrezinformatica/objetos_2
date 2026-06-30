package ar.edu.unlp.info.oo2;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class MediaPlayer {
    private List<Media> media;

    public MediaPlayer(){
        media = new ArrayList<>();
    }

    public void agregar(Media m){
        this.media.add(m);
    }

    public int tamano(){
        return this.media.size();
    }

    public String play(Media m){
        return m.play();
    }

    public List<String> playAll() {
        return media.stream()
            .map(m -> m.play())
            .collect(Collectors.toList());
    }
}

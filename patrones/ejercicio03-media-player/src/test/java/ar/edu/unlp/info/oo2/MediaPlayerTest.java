package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MediaPlayerTest {
    private MediaPlayer player; 
    private Audio audio; 
    private VideoFile videoFile; 
    private VideoStreamMedia videoStreamAdapter; 

    @BeforeEach 
    public void setUp(){
        player = new MediaPlayer();
        audio = new Audio();
        videoFile = new VideoFile();
        videoStreamAdapter = new VideoStreamMedia(new VideoStream());
    }

    @Test 
    public void agregarUnMedioAumentaTamanio(){
        player.agregar(audio);
        assertEquals(1, player.tamano());
    }

    @Test 
    public void agregarVariosMediosDeDistintoTipo(){
        player.agregar(audio);
        player.agregar(videoFile);
        player.agregar(videoStreamAdapter);
        assertEquals(3, player.tamano());
    }

    @Test 
    public void playerReproduceMediosPolimorficamente(){
        player.agregar(videoStreamAdapter);
        player.agregar(videoFile);
        player.agregar(audio);
        List <String> resultados = player.playAll();
        assertEquals(3, resultados.size());
        assertEquals("Reproduciendo en streaming...", resultados.get(0));
        assertEquals("Reproduciendo video...", resultados.get(1));
        assertEquals("Reproduciendo audio...", resultados.get(2));
    }

    @Test 
    public void videoStreamMediaImplementaMedia(){
        assertTrue(videoStreamAdapter instanceof Media);
    }

    @Test 
    public void adapterDelegaAlAdaptee(){
        Media medio = videoStreamAdapter;
        assertEquals("Reproduciendo en streaming...", medio.play());
    }
















    
}

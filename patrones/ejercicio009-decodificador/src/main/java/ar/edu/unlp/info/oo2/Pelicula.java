package ar.edu.unlp.info.oo2;
import java.util.List;
import java.util.ArrayList; 
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Pelicula {

	private String titulo;
	private int estreno;
	private double puntaje;
	private List<Pelicula> similares; 

	public Pelicula(String titulo, int estreno, double puntaje) {
		this.titulo = titulo;
		this.estreno = estreno;
		this.puntaje = puntaje;
		this.similares = new ArrayList<Pelicula>();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getEstreno() {
		return estreno;
	}
	
	public double getPuntaje() {
		return puntaje;
	}

	public List<Pelicula> getSimilares() {
		return similares;
	}

	public void agregarSimilar(Pelicula otra){
		if(!this.similares.contains(otra)){
			this.similares.add(otra);
			otra.agregarSimilar(this);
		}
	}

}

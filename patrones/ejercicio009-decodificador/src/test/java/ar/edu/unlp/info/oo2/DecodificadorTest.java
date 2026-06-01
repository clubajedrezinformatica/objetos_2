package ar.edu.unlp.info.oo2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class DecodificadorTest { 
	private Decodificador d;
	private Pelicula thor, ca, im, dunkirk, rocky, rambo;

	@BeforeEach 
	public void setUp() {
		d = new Decodificador(new EstrategiaNovedad());
		thor = new Pelicula("Thor", 2007, 7.9);
		ca = new Pelicula("Capitán América", 2016, 7.8);
		im = new Pelicula("Iron Man", 2010, 7.9);
		dunkirk = new Pelicula("Dunkirk", 2017, 7.9);
		rocky = new Pelicula("Rocky", 1976, 8.1);
		rambo = new Pelicula("Rambo", 1979, 7.8);
		
		thor.agregarSimilar(ca);
		thor.agregarSimilar(im);
		ca.agregarSimilar(im);
		rocky.agregarSimilar(rambo);

		d.agregarPelicula(thor);
		d.agregarPelicula(ca);
		d.agregarPelicula(im);
		d.agregarPelicula(dunkirk);
		d.agregarPelicula(rocky);
		d.agregarPelicula(rambo);

		d.reproducirPelicula(thor);
		d.reproducirPelicula(rocky);
	}

	@Test
	public void sugerirPorNovedad() {
		d.setEstrategia(new EstrategiaNovedad());
		List <Pelicula> sugerencias = d.sugerir();
		assertEquals(List.of(dunkirk, ca, im), sugerencias);
	}

	@Test 
	public void sugerirPorPuntaje() {
		d.setEstrategia(new EstrategiaPuntaje());
		List <Pelicula> sugerencias = d.sugerir();
		assertEquals(List.of(dunkirk, im, ca), sugerencias);
	}

	@Test 
	public void sugerirPorSimilaridad() {
		d.setEstrategia(new EstrategiaSimilaridad());
		List <Pelicula> sugerencias = d.sugerir();
		assertEquals(List.of(ca, im, rambo), sugerencias);
	}

	@Test 
	public void cambioDeEstrategiaEnRuntima(){
		d.setEstrategia(new EstrategiaSimilaridad());
		List <Pelicula> sugerencias = d.sugerir();
		assertEquals(List.of(ca, im, rambo), sugerencias);
		d.setEstrategia(new EstrategiaPuntaje());
		sugerencias = d.sugerir();
		assertEquals(List.of(dunkirk, im, ca), sugerencias);
	}
}



package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class ToDoItemTest {
	
	private ToDoItem todo;
	
	@BeforeEach
	void setUp() throws Exception {
		todo = new ToDoItem("Estudiar State Pattern");
	}

	@Test 
	void testCreacionEnEstadoPending() {
		assertTrue(todo.getEstado() instanceof Pending);
	}

	@Test
	void testStartTransicionaAInProgress() {
		todo.start();
		assertTrue(todo.getEstado() instanceof InProgress);
	}

	@Test
	void testTogglePauseTransicionInProgressAPaused() {
		assertEquals("El objeto ToDoItem no se encuentra InProgress ni en Paused", 
				assertThrows(RuntimeException.class, () -> todo.togglePause()).getMessage());
		todo.start();
		assertTrue(todo.getEstado() instanceof InProgress);
		todo.togglePause();
		assertTrue(todo.getEstado() instanceof Paused);
	}

	@Test 
	void testTogglePauseTransicionPausedAInProgress() {
		todo.start();
		todo.togglePause();
		assertTrue(todo.getEstado() instanceof Paused);
		todo.togglePause();
		assertTrue(todo.getEstado() instanceof InProgress);
	}
	
	@Test
	void testFinishDesdeInProgress() {
		todo.start();
		todo.finish();
		assertTrue(todo.getEstado() instanceof Finished);
	}

	@Test
	void testTogglePauseDesdePendingLanzaExcepcion() {
		assertThrows(RuntimeException.class, () -> todo.togglePause());
	}

	@Test 
	void testWorkedTimeDesdePendingLanzaExcepcion() {
		assertThrows(RuntimeException.class, () -> todo.workedTime());
	}

	@Test 
	void testTogglePauseDesdeFinishedLanzaExcepcion() {
		todo.start();
		todo.finish();
		assertThrows(RuntimeException.class, () -> todo.togglePause());
	}

	@Test 
	public void testAddCommentEnActivoAgregaComentario() {
		todo.start();
		todo.addComment("revisar requerimientos");
		assertEquals(1, todo.getComments().size());
		assertEquals("revisar requerimientos", todo.getComments().get(0));
	}

	@Test 
	public void testAddCommentNoAgregaEnFinished(){
		todo.start();
		todo.finish();
		todo.addComment("este comentario no debería ser tenido en cuenta");
		assertEquals(0, todo.getComments().size());
	}
    
}

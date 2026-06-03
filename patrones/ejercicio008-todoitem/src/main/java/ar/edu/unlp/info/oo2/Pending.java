package ar.edu.unlp.info.oo2;
import java.time.Duration;
import java.time.LocalDateTime;


public class Pending implements Estado  {
    public void start(ToDoItem t) { 
        t.setStartTime(LocalDateTime.now());
        t.setEstado(new InProgress());
    }

    public void togglePause(ToDoItem t) { 
        throw new RuntimeException("El objeto ToDoItem no se encuentra InProgress ni en Paused");
    }

    public void finish(ToDoItem t) { 
    }

    public Duration workedTime(ToDoItem t) {
        throw new RuntimeException("El objeto ToDoItem no se encuentra iniciado todavía");
    }

    public void addComment(ToDoItem t, String comment) {
        t.appendComment(comment);
    }
    
}

package ar.edu.unlp.info.oo2;
import java.time.Duration;

public class Finished implements Estado {
    public void start(ToDoItem t){
    }

    public void togglePause(ToDoItem t) { 
        throw new RuntimeException("El objeto ToDoItem se encuentra finalizado");
    }

    public void finish(ToDoItem t) { 
    }

    public Duration workedTime(ToDoItem t) {
        return Duration.between(t.getStartTime(), t.getEndTime());
    }

    public void addComment(ToDoItem t, String comment) {
    }
    
}

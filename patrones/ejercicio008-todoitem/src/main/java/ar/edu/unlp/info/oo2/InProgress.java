package ar.edu.unlp.info.oo2;
import java.time.Duration;
import java.time.LocalDateTime;

public class InProgress implements Estado {
    public void start(ToDoItem t){
    }
    
    public void togglePause(ToDoItem t) { 
        t.setEstado(new Paused());
    }

    public void finish(ToDoItem t) { 
        t.setEndTime(LocalDateTime.now());
        t.setEstado(new Finished());
    }

    public Duration workedTime(ToDoItem t) {
        return Duration.between(t.getStartTime(), LocalDateTime.now());
    }

    public void addComment(ToDoItem t, String comment) {
        t.appendComment(comment);
    }
}

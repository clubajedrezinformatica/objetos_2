package ar.edu.unlp.info.oo2;
import java.time.Duration;

public interface Estado {
    void start(ToDoItem t);
    void togglePause(ToDoItem t);
    void finish(ToDoItem t);
    Duration workedTime(ToDoItem t);
    void addComment(ToDoItem t, String comment);
}
package ar.edu.unlp.info.oo2;
import java.util.List;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDateTime;


public class ToDoItem {
    private String name; 
    private List<String> comments;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Estado estado; 

    public ToDoItem(String name) {
        this.name = name;
        this.comments = new ArrayList<>();
        this.estado = new Pending();
    }

    public void start() {
        this.estado.start(this);
    }

    public void togglePause() {
        this.estado.togglePause(this);
    }

    public void finish() {
        this.estado.finish(this);
    }

    public Duration workedTime() {
        return this.estado.workedTime(this);
    }

    public void addComment(String comment) {
        this.estado.addComment(this, comment);
    }
    
    void appendComment(String comment){
        this.comments.add(comment);
    }

    void setEstado(Estado estado) {
        this.estado = estado;
    }

    void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime; 
    }

    public String getName() {
        return this.name;
    }

    LocalDateTime getStartTime() {
        return this.startTime;
    }

    LocalDateTime getEndTime() {
        return this.endTime;
    }

    Estado getEstado() {
        return this.estado;
    }

    List<String> getComments() {
        return this.comments;
    }
    
}
package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class CommentEvent {
    private ObjectId idCommentEvent;
    private ObjectId idEvent;
    private LocalDate date;
    private String message;
    private ObjectId idPerson;
    private String name;


    public CommentEvent() {
    }

    public CommentEvent(ObjectId idEvent, LocalDate date, String message) {
        this.idEvent = idEvent;
        this.date = date;
        this.message = message;
    }

    public Object getIdCommentEvent() {
        return idCommentEvent;
    }

    public void setIdCommentEvent(ObjectId idCommentEvent) {
        this.idCommentEvent = idCommentEvent;
    }

    public ObjectId getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(ObjectId idEvent) {
        this.idEvent = idEvent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(ObjectId idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "CommentEvent{" +
                "idCommentEvent=" + idCommentEvent +
                ", idEvent=" + idEvent +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", idPerson=" + idPerson +
                '}';
    }
}

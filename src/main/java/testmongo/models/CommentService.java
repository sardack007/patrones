package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class CommentService {
    private ObjectId idCommentService;
    private ObjectId idService;
    private LocalDate date;
    private String message;
    private ObjectId idPerson;
    private String name;

    public CommentService() {
    }

    public CommentService(ObjectId idService, LocalDate date, String message) {
        this.idService = idService;
        this.date = date;
        this.message = message;
    }

    public Object getIdCommentService() {
        return idCommentService;
    }

    public void setIdCommentService(ObjectId idCommentService) {
        this.idCommentService = idCommentService;
    }

    public ObjectId getIdService() {
        return idService;
    }

    public void setIdService(ObjectId idService) {
        this.idService = idService;
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
        return "CommentService{" +
                "idCommentService=" + idCommentService +
                ", idService=" + idService +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", idPerson=" + idPerson +
                '}';
    }
}

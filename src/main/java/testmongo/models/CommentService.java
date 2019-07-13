package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class CommentService {
    private Object idCommentService;
    private ObjectId idService;
    private LocalDate date;
    private String message;

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

    public void setIdCommentService(Object idCommentService) {
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
}
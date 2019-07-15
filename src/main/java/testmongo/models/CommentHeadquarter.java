package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class CommentHeadquarter {
    private ObjectId idCommentHeadquarter;
    private ObjectId idHeadquarter;
    private ObjectId idPerson;
    private String name;
    private LocalDate date;
    private String message;



    public ObjectId getIdCommentHeadquarter() {
        return idCommentHeadquarter;
    }

    public void setIdCommentHeadquarter(ObjectId idCommentHeadquarter) {
        this.idCommentHeadquarter = idCommentHeadquarter;
    }

    public ObjectId getIdHeadquarter() {
        return idHeadquarter;
    }

    public void setIdHeadquarter(ObjectId idHeadquarter) {
        this.idHeadquarter = idHeadquarter;
    }

    public ObjectId getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(ObjectId idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CommentHeadquarter{" +
                "idCommentHeadquarter=" + idCommentHeadquarter +
                ", idHeadquarter=" + idHeadquarter +
                ", idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}

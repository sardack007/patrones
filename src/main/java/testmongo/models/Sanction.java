package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Sanction {
    private ObjectId idSanction;
    private ObjectId idPersonAdministrator;
    private LocalDate date;
    private String reason;

    public Sanction(ObjectId idPersonAdministrator, LocalDate date, String reason) {
        this.idPersonAdministrator = idPersonAdministrator;
        this.date = date;
        this.reason = reason;
    }

    public Sanction() {
    }

    public ObjectId getIdSanction() {
        return idSanction;
    }

    public void setIdSanction(ObjectId idSanction) {
        this.idSanction = idSanction;
    }

    public ObjectId getIdPersonAdministrator() {
        return idPersonAdministrator;
    }

    public void setIdPersonAdministrator(ObjectId idPersonAdministrator) {
        this.idPersonAdministrator = idPersonAdministrator;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

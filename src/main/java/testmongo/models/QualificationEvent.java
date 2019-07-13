package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class QualificationEvent {
    private ObjectId idQualificationEvent;
    private ObjectId idEvent;
    private LocalDate date;
    private Double qualification;

    public QualificationEvent() {
    }

    public QualificationEvent(ObjectId idEvent, LocalDate date, Double qualification) {
        this.idEvent = idEvent;
        this.date = date;
        this.qualification = qualification;
    }

    public ObjectId getIdQualificationEvent() {
        return idQualificationEvent;
    }

    public void setIdQualificationEvent(ObjectId idQualificationEvent) {
        this.idQualificationEvent = idQualificationEvent;
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

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }
}

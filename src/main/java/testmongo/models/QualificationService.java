package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class QualificationService {
    private ObjectId idQualificationService;
    private ObjectId idService;
    private LocalDate date;
    private Double qualification;

    public QualificationService() {
    }

    public QualificationService(ObjectId idService, LocalDate date, Double qualification) {
        this.idService = idService;
        this.date = date;
        this.qualification = qualification;
    }

    public ObjectId getIdQualificationService() {
        return idQualificationService;
    }

    public void setIdQualificationService(ObjectId idQualificationService) {
        this.idQualificationService = idQualificationService;
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

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }
}

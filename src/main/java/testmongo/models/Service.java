package testmongo.models;

import org.bson.types.ObjectId;

public class Service {
    private ObjectId idService;
    private ObjectId idheadquarters;
    private String name;
    private Double avarageMark;

    public Service() {
    }

    public Service(ObjectId idheadquarters, String name, Double avarageMark) {
        this.idheadquarters = idheadquarters;
        this.name = name;
        this.avarageMark = avarageMark;
    }

    public ObjectId getIdService() {
        return idService;
    }

    public void setIdService(ObjectId idService) {
        this.idService = idService;
    }

    public ObjectId getIdheadquarters() {
        return idheadquarters;
    }

    public void setIdheadquarters(ObjectId idheadquarters) {
        this.idheadquarters = idheadquarters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAvarageMark() {
        return avarageMark;
    }

    public void setAvarageMark(Double avarageMark) {
        this.avarageMark = avarageMark;
    }
}

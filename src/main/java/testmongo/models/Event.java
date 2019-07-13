package testmongo.models;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Event {
    private ObjectId idEvent;
    private ObjectId idHeadquarters;
    private String name;
    private Double avarageMark;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public Event() {
    }

    public Event(ObjectId idEvent, ObjectId idHeadquarters, String name, Double avarageMark, LocalDate startDate, LocalDate endDate, String description) {
        this.idEvent = idEvent;
        this.idHeadquarters = idHeadquarters;
        this.name = name;
        this.avarageMark = avarageMark;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public ObjectId getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(ObjectId idEvent) {
        this.idEvent = idEvent;
    }

    public ObjectId getIdHeadquarters() {
        return idHeadquarters;
    }

    public void setIdHeadquarters(ObjectId idHeadquarters) {
        this.idHeadquarters = idHeadquarters;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", idHeadquarters=" + idHeadquarters +
                ", name='" + name + '\'' +
                ", avarageMark=" + avarageMark +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}

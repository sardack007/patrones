package testmongo.models;

import org.bson.types.ObjectId;

public class Headquarters {
    private ObjectId idHeadquarters;
    private String name;
    private Integer capacity;
    private String address;

    public Headquarters() {
    }

    public Headquarters(String name, Integer capacity, String address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

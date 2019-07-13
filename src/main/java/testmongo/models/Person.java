package testmongo.models;

import org.bson.types.ObjectId;

public abstract class Person {
    protected ObjectId idPerson;
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String email;

    public Person() {
    }

    public Person(ObjectId idPerson, String firstname, String lastname, String password, String email) {
        this.idPerson = idPerson;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public ObjectId getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(ObjectId idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

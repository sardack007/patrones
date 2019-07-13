package testmongo.models;


import org.bson.types.ObjectId;

public class Athlete extends Person{
    private String federation;
    private String country;
    private String discipline;
    private String facebook;
    private String twitter;
    private Integer age;
    private String genre;

    public Athlete(ObjectId idPerson, String firstname, String lastname, String password, String email, String federation, String country, String discipline, String facebook, String twitter, Integer age, String genre) {
        super(idPerson, firstname, lastname, password, email);
        this.federation = federation;
        this.country = country;
        this.discipline = discipline;
        this.facebook = facebook;
        this.twitter = twitter;
        this.age = age;
        this.genre = genre;
    }

    public Athlete(String federation, String country, String discipline, String facebook, String twitter, Integer age, String genre) {
        this.federation = federation;
        this.country = country;
        this.discipline = discipline;
        this.facebook = facebook;
        this.twitter = twitter;
        this.age = age;
        this.genre = genre;
    }

    public Athlete() {
    }

    public String getFederation() {
        return federation;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

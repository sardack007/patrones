package testmongo.models;

import org.bson.types.ObjectId;

public class User extends Person{
    private String nickname;
    private Integer age;
    private String genre;

    public User() {
    }

    public User(ObjectId idPerson, String firstname, String lastname, String password, String email, String nickname, Integer age, String genre) {
        super(idPerson, firstname, lastname, password, email);
        this.nickname = nickname;
        this.age = age;
        this.genre = genre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

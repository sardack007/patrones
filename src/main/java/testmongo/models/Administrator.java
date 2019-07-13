package testmongo.models;

import org.bson.types.ObjectId;
import testmongo.models.Person;

public class Administrator extends Person {
    private String nickname;

    public Administrator() {
    }

    public Administrator(ObjectId idPerson, String firstname, String lastname, String password, String email, String nickname) {
        super(idPerson, firstname, lastname, password, email);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

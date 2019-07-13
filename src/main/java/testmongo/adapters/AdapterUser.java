package testmongo.adapters;

import org.bson.Document;
import testmongo.models.User;

public class AdapterUser {
    public static Document userToDocument(User user){
        Document document = new Document();
        document.append("firstname",user.getFirstname())
                .append("lastname", user.getLastname())
                .append("email", user.getEmail())
                .append("password", user.getPassword())
                .append("nickname", user.getNickname())
                .append("age", user.getAge())
                .append("genre", user.getGenre());
        return document;
    }
    public static User documentToUser(Document document){
        User user = new User();
        user.setIdPerson(document.getObjectId("_id"));
        user.setFirstname(document.getString("firstname"));
        user.setLastname(document.getString("lastname"));
        user.setEmail(document.getString("email"));
        user.setPassword(document.getString("password"));
        user.setAge(document.getInteger("age"));
        user.setGenre(document.getString("genre"));
        user.setNickname(document.getString("nickname"));
        return user;
    }
}

package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Administrator;

public class AdapterAdministrator {
    public static Document administratorToDocument(Administrator administrator){
        Document document = new Document();
        document.append("firstname",administrator.getFirstname())
                .append("lastname", administrator.getLastname())
                .append("email", administrator.getEmail())
                .append("password", administrator.getPassword())
                .append("nickname", administrator.getNickname());
        return document;
    }
    public static Administrator documentToAdministrator(Document document){
        Administrator administrator = new Administrator();
        administrator.setIdPerson(document.getObjectId("_id"));
        administrator.setFirstname(document.getString("firstname"));
        administrator.setLastname(document.getString("lastname"));
        administrator.setEmail(document.getString("email"));
        administrator.setPassword(document.getString("password"));
        administrator.setNickname(document.getString("nickname"));
        return administrator;
    }
}

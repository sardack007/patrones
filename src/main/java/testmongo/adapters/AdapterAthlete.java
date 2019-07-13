package testmongo.adapters;


import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.Athlete;

public class AdapterAthlete {
    public static Document athleteToDocument(Athlete athlete){
        Document document = new Document();
        document.append("firstname",athlete.getFirstname())
                .append("lastname", athlete.getLastname())
                .append("email", athlete.getEmail())
                .append("password", athlete.getPassword())
                .append("federation", athlete.getFederation())
                .append("country", athlete.getCountry())
                .append("discipline", athlete.getDiscipline())
                .append("facebook", athlete.getFacebook())
                .append("twitter", athlete.getTwitter())
                .append("age", athlete.getAge())
                .append("genre", athlete.getGenre());
        return document;
    }
    public static Athlete documentToAthlete(Document document){
        Athlete athlete = new Athlete();
        athlete.setIdPerson(document.getObjectId("_id"));
        athlete.setFirstname(document.getString("firstname"));
        athlete.setLastname(document.getString("lastname"));
        athlete.setEmail(document.getString("email"));
        athlete.setPassword(document.getString("password"));
        athlete.setCountry(document.getString("country"));
        athlete.setDiscipline(document.getString("discipline"));
        athlete.setFacebook(document.getString("facebook"));
        athlete.setTwitter(document.getString("twitter"));
        athlete.setAge(document.getInteger("age"));
        athlete.setGenre(document.getString("genre"));
        return athlete;
    }
}

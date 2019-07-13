package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.Athlete;
import testmongo.database.DBSingleton;
import testmongo.adapters.AdapterAthlete;

import static com.mongodb.client.model.Filters.eq;

public class RepoAthlete {
    public void saveAthlete(Athlete athlete) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("athlete");
            // get the fields of the class
            Document document = AdapterAthlete.athleteToDocument(athlete);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Athlete getAthleteById(ObjectId id) {
        Athlete athlete = new Athlete();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("athlete");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build athlete
            athlete = AdapterAthlete.documentToAthlete(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return athlete;
    }
    public Athlete getAthleteByEmail(String email) {
        Athlete athlete = new Athlete();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("athlete");
            Document document = (Document) collection.find(eq("email", email)).first();
            // build athlete
            athlete = AdapterAthlete.documentToAthlete(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return athlete;
    }

    public void updateAthlete(Athlete athlete) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("athlete");
            Document document = AdapterAthlete.athleteToDocument(athlete);
            collection.updateOne(eq("_id", athlete.getIdPerson()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAthlete(Athlete athlete){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("athlete");
            collection.deleteOne(eq("_id", athlete.getIdPerson()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

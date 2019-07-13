package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.Bloquing;
import testmongo.database.DBSingleton;
import testmongo.adapters.AdapterBloquing;

import java.sql.Date;
import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;

public class RepoBloquing {
    public void saveBloquing(Bloquing bloquing) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("bloquing");
            // get the fields of the class
            Document document = AdapterBloquing.bloquingToDocument(bloquing);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bloquing getBloquingById(ObjectId id) {
        Bloquing bloquing = new Bloquing();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("bloquing");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build bloquing
            bloquing = AdapterBloquing.documentToBloquing(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bloquing;
    }
    public Bloquing getBloquingByDate(LocalDate localDate) {
        Bloquing bloquing = new Bloquing();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("bloquing");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build bloquing
            bloquing = AdapterBloquing.documentToBloquing(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bloquing;
    }

    public void updateBloquing(Bloquing bloquing) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("bloquing");
            Document document = AdapterBloquing.bloquingToDocument(bloquing);
            collection.updateOne(eq("_id", bloquing.getIdBloquing()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBloquing(Bloquing bloquing){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("bloquing");
            collection.deleteOne(eq("_id", bloquing.getIdBloquing()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

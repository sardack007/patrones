package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.Sanction;
import testmongo.adapters.AdapterSanction;

import java.sql.Date;
import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;

public class RepoSanction {
    public void saveSanction(Sanction sanction) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("sanction");
            // get the fields of the class
            Document document = AdapterSanction.sanctionToDocument(sanction);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sanction getSanctionById(ObjectId id) {
        Sanction sanction = new Sanction();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("sanction");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build sanction
            sanction = AdapterSanction.documentToSanction(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanction;
    }
    public Sanction getSanctionByDate(LocalDate localDate) {
        Sanction sanction = new Sanction();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("sanction");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build sanction
            sanction = AdapterSanction.documentToSanction(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanction;
    }

    public void updateSanction(Sanction sanction) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("sanction");
            Document document = AdapterSanction.sanctionToDocument(sanction);
            collection.updateOne(eq("_id", sanction.getIdSanction()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSanction(Sanction sanction){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("sanction");
            collection.deleteOne(eq("_id", sanction.getIdSanction()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

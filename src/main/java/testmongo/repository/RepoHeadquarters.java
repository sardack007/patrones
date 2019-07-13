package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.Headquarters;
import testmongo.adapters.AdapterHeadquarters;

import static com.mongodb.client.model.Filters.eq;

public class RepoHeadquarters {
    public void saveHeadquarters(Headquarters headquarters) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("headquarters");
            // get the fields of the class
            Document document = AdapterHeadquarters.headquartersToDocument(headquarters);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Headquarters getHeadquartersById(ObjectId id) {
        Headquarters headquarters = new Headquarters();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("headquarters");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build headquarters
            headquarters = AdapterHeadquarters.documentToHeadquarters(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headquarters;
    }
    public Headquarters getHeadquartersByName(String name) {
        Headquarters headquarters = new Headquarters();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("headquarters");
            Document document = (Document) collection.find(eq("name", name)).first();
            // build headquarters
            headquarters = AdapterHeadquarters.documentToHeadquarters(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headquarters;
    }

    public void updateHeadquarters(Headquarters headquarters) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("headquarters");
            Document document = AdapterHeadquarters.headquartersToDocument(headquarters);
            collection.updateOne(eq("_id", headquarters.getIdHeadquarters()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHeadquarters(Headquarters headquarters){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("headquarters");
            collection.deleteOne(eq("_id", headquarters.getIdHeadquarters()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

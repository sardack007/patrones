package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.Administrator;
import testmongo.database.DBSingleton;
import testmongo.adapters.AdapterAdministrator;

import static com.mongodb.client.model.Filters.eq;

public class RepoAdministrator {
    public void saveAdministrator(Administrator administrator) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("administrator");
            // get the fields of the class
            Document document = AdapterAdministrator.administratorToDocument(administrator);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Administrator getAdministratorById(ObjectId id) {
        Administrator administrator = new Administrator();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("administrator");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build administrator
            administrator = AdapterAdministrator.documentToAdministrator(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrator;
    }
    public Administrator getAdministratorByEmail(String email) {
        Administrator administrator = new Administrator();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("administrator");
            Document document = (Document) collection.find(eq("email", email)).first();
            // build administrator
            administrator = AdapterAdministrator.documentToAdministrator(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrator;
    }

    public void updateAdministrator(Administrator administrator) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("administrator");
            Document document = AdapterAdministrator.administratorToDocument(administrator);
            collection.updateOne(eq("_id", administrator.getIdPerson()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAdministrator(Administrator administrator){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("administrator");
            collection.deleteOne(eq("_id", administrator.getIdPerson()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

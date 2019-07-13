package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.User;
import testmongo.adapters.AdapterUser;

import static com.mongodb.client.model.Filters.eq;

public class RepoUser {
    public void saverUser(User user) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("user");
            // get the fields of the class
            Document document = AdapterUser.userToDocument(user);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserById(ObjectId id) {
        User user = new User();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("user");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build user
            user = AdapterUser.documentToUser(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public User getUserByEmail(String email) {
        User user = new User();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("user");
            Document document = (Document) collection.find(eq("email", email)).first();
            // build user
            user = AdapterUser.documentToUser(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("user");
            Document document = AdapterUser.userToDocument(user);
            collection.updateOne(eq("_id", user.getIdPerson()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("user");
            collection.deleteOne(eq("_id", user.getIdPerson()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

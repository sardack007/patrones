package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.Service;
import testmongo.adapters.AdapterService;

import static com.mongodb.client.model.Filters.eq;

public class RepoService {
    public void saveService(Service service) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("service");
            // get the fields of the class
            Document document = AdapterService.serviceToDocument(service);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Service getServiceById(ObjectId id) {
        Service service = new Service();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("service");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build service
            service = AdapterService.documentToService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }
    public Service getServiceByName(String name) {
        Service service = new Service();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("service");
            Document document = (Document) collection.find(eq("name", name)).first();
            // build service
            service = AdapterService.documentToService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    public void updateService(Service service) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("service");
            Document document = AdapterService.serviceToDocument(service);
            collection.updateOne(eq("_id", service.getIdService()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteService(Service service){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("service");
            collection.deleteOne(eq("_id", service.getIdService()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

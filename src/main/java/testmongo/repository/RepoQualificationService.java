package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.QualificationService;
import testmongo.adapters.AdapterQualificationService;

import java.sql.Date;
import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;

public class RepoQualificationService {
    public void saveQualificationService(QualificationService qualificationService) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("qualificationService");
            // get the fields of the class
            Document document = AdapterQualificationService.qualificationServiceToDocument(qualificationService);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QualificationService getQualificationServiceById(ObjectId id) {
        QualificationService qualificationService = new QualificationService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationService");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build qualificationService
            qualificationService = AdapterQualificationService.documentToQualificationService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationService;
    }

    public QualificationService getQualificationServiceByDate(LocalDate localDate) {
        QualificationService qualificationService = new QualificationService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationService");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build qualificationService
            qualificationService = AdapterQualificationService.documentToQualificationService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationService;
    }

    public QualificationService getQualificationServiceByService(ObjectId idService) {
        QualificationService qualificationService = new QualificationService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationService");
            Document document = (Document) collection.find(eq("idService", idService)).first();
            // build qualificationService
            qualificationService = AdapterQualificationService.documentToQualificationService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationService;
    }

    public void updateQualificationService(QualificationService qualificationService) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationService");
            Document document = AdapterQualificationService.qualificationServiceToDocument(qualificationService);
            collection.updateOne(eq("_id", qualificationService.getIdQualificationService()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteQualificationService(QualificationService qualificationService) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationService");
            collection.deleteOne(eq("_id", qualificationService.getIdQualificationService()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

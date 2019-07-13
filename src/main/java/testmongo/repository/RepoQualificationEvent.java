package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.QualificationEvent;
import testmongo.adapters.AdapterQualificationEvent;

import java.sql.Date;
import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;

public class RepoQualificationEvent {
    public void saveQualificationEvent(QualificationEvent qualificationEvent) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("qualificationEvent");
            // get the fields of the class
            Document document = AdapterQualificationEvent.qualificationEventToDocument(qualificationEvent);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QualificationEvent getQualificationEventById(ObjectId id) {
        QualificationEvent qualificationEvent = new QualificationEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationEvent");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build qualificationEvent
            qualificationEvent = AdapterQualificationEvent.documentToQualificationEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationEvent;
    }

    public QualificationEvent getQualificationEventByDate(LocalDate localDate) {
        QualificationEvent qualificationEvent = new QualificationEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationEvent");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build qualificationEvent
            qualificationEvent = AdapterQualificationEvent.documentToQualificationEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationEvent;
    }

    public QualificationEvent getQualificationEventByEvent(ObjectId idEvent) {
        QualificationEvent qualificationEvent = new QualificationEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationEvent");
            Document document = (Document) collection.find(eq("idEvent", idEvent)).first();
            // build qualificationEvent
            qualificationEvent = AdapterQualificationEvent.documentToQualificationEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qualificationEvent;
    }

    public void updateQualificationEvent(QualificationEvent qualificationEvent) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationEvent");
            Document document = AdapterQualificationEvent.qualificationEventToDocument(qualificationEvent);
            collection.updateOne(eq("_id", qualificationEvent.getIdQualificationEvent()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteQualificationEvent(QualificationEvent qualificationEvent) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("qualificationEvent");
            collection.deleteOne(eq("_id", qualificationEvent.getIdQualificationEvent()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

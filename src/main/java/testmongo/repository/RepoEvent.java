package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.Event;
import testmongo.adapters.AdapterEvent;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class RepoEvent {
    public ArrayList<Event> GetEvents(){
        Event event = new Event();
        ArrayList<Event> lista = new ArrayList<>();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("event");
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    Document d = cursor.next();

                    lista.add(AdapterEvent.documentToEvent(d));
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void saveEvent(Event event) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("event");
            // get the fields of the class
            Document document = AdapterEvent.eventToDocument(event);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Event getEventById(ObjectId id) {
        Event event = new Event();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("event");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build event
            event = AdapterEvent.documentToEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
    public Event getEventByName(String name) {
        Event event = new Event();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("event");
            Document document = (Document) collection.find(eq("name", name)).first();
            // build event
            event = AdapterEvent.documentToEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    public void updateEvent(Event event) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("event");
            Document document = AdapterEvent.eventToDocument(event);
            collection.updateOne(eq("_id", event.getIdEvent()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(Event event){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("event");
            collection.deleteOne(eq("_id", event.getIdEvent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

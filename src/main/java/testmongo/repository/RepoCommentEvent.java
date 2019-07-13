package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.CommentEvent;
import testmongo.database.DBSingleton;
import testmongo.adapters.AdapterCommentEvent;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class RepoCommentEvent {
    public void saveCommentEvent(CommentEvent commentEvent) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("commentEvent");
            // get the fields of the class
            Document document = AdapterCommentEvent.commentEventToDocument(commentEvent);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CommentEvent> getAllComments() {
        ArrayList<CommentEvent> list = new ArrayList<>();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    CommentEvent commentEvent = AdapterCommentEvent.documentToCommentEvent(cursor.next());
                    list.add(commentEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CommentEvent getCommentEventById(ObjectId id) {
        CommentEvent commentEvent = new CommentEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build commentEvent
            commentEvent = AdapterCommentEvent.documentToCommentEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentEvent;
    }

    public CommentEvent getCommentEventByDate(LocalDate localDate) {
        CommentEvent commentEvent = new CommentEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build commentEvent
            commentEvent = AdapterCommentEvent.documentToCommentEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentEvent;
    }

    public CommentEvent getCommentEventByEvent(ObjectId idEvent) {
        CommentEvent commentEvent = new CommentEvent();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            Document document = (Document) collection.find(eq("idEvent", idEvent)).first();
            // build commentEvent
            commentEvent = AdapterCommentEvent.documentToCommentEvent(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentEvent;
    }

    public void updateCommentEvent(CommentEvent commentEvent) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            Document document = AdapterCommentEvent.commentEventToDocument(commentEvent);
            collection.updateOne(eq("_id", commentEvent.getIdCommentEvent()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCommentEvent(CommentEvent commentEvent) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentEvent");
            collection.deleteOne(eq("_id", commentEvent.getIdCommentEvent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

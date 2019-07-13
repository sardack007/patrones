package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.models.CommentService;
import testmongo.database.DBSingleton;
import testmongo.adapters.AdapterCommentService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class RepoCommentService {
    public void saveCommentService(CommentService commentService) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("commentService");
            // get the fields of the class
            Document document = AdapterCommentService.commentServiceToDocument(commentService);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CommentService> getAllComments() {
        ArrayList<CommentService> list = new ArrayList<>();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    CommentService commentEvent = AdapterCommentService.documentToCommentService(cursor.next());
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

    public CommentService getCommentServiceById(ObjectId id) {
        CommentService commentService = new CommentService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            Document document = (Document) collection.find(eq("_id", id)).first();
            // build commentService
            commentService = AdapterCommentService.documentToCommentService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentService;
    }
    public CommentService getCommentServiceByDate(LocalDate localDate) {
        CommentService commentService = new CommentService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            Document document = (Document) collection.find(eq("date", Date.valueOf(localDate))).first();
            // build commentService
            commentService = AdapterCommentService.documentToCommentService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentService;
    }
    public CommentService getCommentServiceByEvent(ObjectId idService) {
        CommentService commentService = new CommentService();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            Document document = (Document) collection.find(eq("idService", idService)).first();
            // build commentService
            commentService = AdapterCommentService.documentToCommentService(document);
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentService;
    }

    public void updateCommentService(CommentService commentService) {
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            Document document = AdapterCommentService.commentServiceToDocument(commentService);
            collection.updateOne(eq("_id", commentService.getIdCommentService()), new Document("$set", document));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCommentService(CommentService commentService){
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentService");
            collection.deleteOne(eq("_id", commentService.getIdCommentService()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

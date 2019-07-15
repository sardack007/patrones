package testmongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import testmongo.adapters.AdapterCommentHeadquarter;
import testmongo.database.DBSingleton;
import testmongo.models.CommentHeadquarter;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class RepoCommentsHeadquarter {
    public void saveCommentHeadquarter (CommentHeadquarter commentHeadquarter) {
        try {
            // get connection to database
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            // get collection from database
            MongoCollection<Document> collection = database.getCollection("commentHeadquarter");
            // get the fields of the class
            Document document = AdapterCommentHeadquarter.commentHeadquarterToDocument(commentHeadquarter);
            // insert one document
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<CommentHeadquarter> getCommentHeadquartersByIdHeadquarter(ObjectId id) {
        ArrayList<CommentHeadquarter> list = new ArrayList<>();
        try {
            MongoDatabase database = DBSingleton.getInstance().getConnection();
            MongoCollection collection = database.getCollection("commentHeadquarter");
            MongoCursor<Document> cursor = collection.find(eq("idHeadquarter", id)).iterator();
            try {
                while (cursor.hasNext()) {
                    CommentHeadquarter commentHeadquarter = AdapterCommentHeadquarter.documentToCommentHeadquarter(cursor.next());
                    list.add(commentHeadquarter);
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


}

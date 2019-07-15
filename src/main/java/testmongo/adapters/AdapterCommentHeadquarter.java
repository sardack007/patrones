package testmongo.adapters;

import org.bson.Document;
import testmongo.models.CommentHeadquarter;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterCommentHeadquarter {
    public static Document commentHeadquarterToDocument(CommentHeadquarter commentHeadquarter){
        Document document = new Document();
        document.append("idHeadquarter", commentHeadquarter.getIdHeadquarter())
                .append("date", Date.valueOf(commentHeadquarter.getDate()))
                .append("message", commentHeadquarter.getMessage())
                .append("name", commentHeadquarter.getName())
                .append("idPerson", commentHeadquarter.getIdPerson());
        return document;
    }
    public static CommentHeadquarter documentToCommentHeadquarter(Document document){
        CommentHeadquarter commentHeadquarter = new CommentHeadquarter();
        commentHeadquarter.setIdCommentHeadquarter(document.getObjectId("_id"));
        commentHeadquarter.setIdHeadquarter(document.getObjectId("idHeadquarter"));
        commentHeadquarter.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        commentHeadquarter.setMessage(document.getString("message"));
        commentHeadquarter.setName(document.getString("name"));
        commentHeadquarter.setIdPerson(document.getObjectId("idPerson"));
        return commentHeadquarter;
    }
}

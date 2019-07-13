package testmongo.adapters;

import org.bson.Document;
import testmongo.models.CommentEvent;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterCommentEvent {
    public static Document commentEventToDocument(CommentEvent commentEvent){
        Document document = new Document();
        document.append("idEvent", commentEvent.getIdEvent())
                .append("date", Date.valueOf(commentEvent.getDate()))
                .append("message", commentEvent.getMessage());
        return document;
    }
    public static CommentEvent documentToCommentEvent(Document document){
        CommentEvent commentEvent = new CommentEvent();
        commentEvent.setIdCommentEvent(document.getObjectId("_id"));
        commentEvent.setIdEvent(document.getObjectId("idEvent"));
        commentEvent.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        commentEvent.setMessage(document.getString("message"));
        return commentEvent;
    }
}

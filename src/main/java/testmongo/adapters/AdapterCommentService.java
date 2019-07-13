package testmongo.adapters;

import org.bson.Document;
import testmongo.models.CommentService;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterCommentService {
    public static Document commentServiceToDocument(CommentService commentService){
        Document document = new Document();
        document.append("idService", commentService.getIdService())
                .append("date", Date.valueOf(commentService.getDate()))
                .append("message", commentService.getMessage());
        return document;
    }
    public static CommentService documentToCommentService(Document document){
        CommentService commentService = new CommentService();
        commentService.setIdCommentService(document.getObjectId("_id"));
        commentService.setIdService(document.getObjectId("idService"));
        commentService.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        commentService.setMessage(document.getString("message"));
        return commentService;
    }
}

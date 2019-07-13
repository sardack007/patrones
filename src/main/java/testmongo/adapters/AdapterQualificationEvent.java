package testmongo.adapters;

import org.bson.Document;
import testmongo.models.QualificationEvent;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterQualificationEvent {
    public static Document qualificationEventToDocument(QualificationEvent qualificationEvent){
        Document document = new Document();
        document.append("idEvent", qualificationEvent.getIdEvent())
                .append("date", Date.valueOf(qualificationEvent.getDate()))
                .append("qualification", qualificationEvent.getQualification());
        return document;
    }
    public static QualificationEvent documentToQualificationEvent(Document document){
        QualificationEvent qualificationEvent = new QualificationEvent();
        qualificationEvent.setIdQualificationEvent(document.getObjectId("_id"));
        qualificationEvent.setIdEvent(document.getObjectId("idEvent"));
        qualificationEvent.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        qualificationEvent.setQualification(document.getDouble("qualification"));
        return qualificationEvent;
    }
}

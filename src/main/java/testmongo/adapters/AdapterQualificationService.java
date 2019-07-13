package testmongo.adapters;

import org.bson.Document;
import testmongo.models.QualificationService;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterQualificationService {
    public static Document qualificationServiceToDocument(QualificationService qualificationService){
        Document document = new Document();
        document.append("idService", qualificationService.getIdService())
                .append("date", Date.valueOf(qualificationService.getDate()))
                .append("qualification", qualificationService.getQualification());
        return document;
    }
    public static QualificationService documentToQualificationService(Document document){
        QualificationService qualificationService = new QualificationService();
        qualificationService.setIdQualificationService(document.getObjectId("_id"));
        qualificationService.setIdService(document.getObjectId("idService"));
        qualificationService.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        qualificationService.setQualification(document.getDouble("qualification"));
        return qualificationService;
    }
}

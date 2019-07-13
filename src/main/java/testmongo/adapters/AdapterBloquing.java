package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Bloquing;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterBloquing {
    public static Document bloquingToDocument(Bloquing bloquing){
        Document document = new Document();
        document.append("idPersonAdministrator", bloquing.getIdPersonAdministrator())
                .append("date", Date.valueOf(bloquing.getDate()))
                .append("reason", bloquing.getReason());
        return document;
    }
    public static Bloquing documentToBloquing(Document document){
        Bloquing bloquing = new Bloquing();
        bloquing.setIdBloquing(document.getObjectId("_id"));
        bloquing.setIdPersonAdministrator(document.getObjectId("idPersonAdministrator"));
        bloquing.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        bloquing.setReason(document.getString("reason"));
        return bloquing;
    }
}

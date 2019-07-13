package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Sanction;


import java.sql.Date;
import java.time.ZoneId;

public class AdapterSanction {
    public static Document sanctionToDocument(Sanction sanction){
        Document document = new Document();
        document.append("idPersonAdministrator", sanction.getIdPersonAdministrator())
                .append("date", Date.valueOf(sanction.getDate()))
                .append("reason", sanction.getReason());
        return document;
    }
    public static Sanction documentToSanction(Document document){
        Sanction sanction = new Sanction();
        sanction.setIdSanction(document.getObjectId("_id"));
        sanction.setIdPersonAdministrator(document.getObjectId("idPersonAdministrator"));
        sanction.setDate(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        sanction.setReason(document.getString("reason"));
        return sanction;
    }
}

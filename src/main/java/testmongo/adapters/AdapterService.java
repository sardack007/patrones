package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Service;

public class AdapterService {
    public static Document serviceToDocument(Service service){
        Document document = new Document();
        document.append("idHeadquarters", service.getIdheadquarters())
                .append("name", service.getName())
                .append("avarageMark", service.getAvarageMark());
        return document;
    }
    public static Service documentToService(Document document){
        Service service = new Service();
        service.setIdService(document.getObjectId("_id"));
        service.setName(document.getString("name"));
        service.setIdheadquarters(document.getObjectId("idHeadquarters"));
        service.setAvarageMark(document.getDouble("avarageMark"));
        return service;
    }
}

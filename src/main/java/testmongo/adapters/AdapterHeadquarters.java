package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Headquarters;

public class AdapterHeadquarters {
    public static Document headquartersToDocument(Headquarters headquarters){
        Document document = new Document();
        document.append("name", headquarters.getName())
                .append("capacity", headquarters.getCapacity())
                .append("address", headquarters.getAddress());
        return document;
    }
    public static Headquarters documentToHeadquarters(Document document){
        Headquarters headquarters = new Headquarters();
        headquarters.setIdHeadquarters(document.getObjectId("_id"));
        headquarters.setName(document.getString("name"));
        headquarters.setCapacity(document.getInteger("capacity"));
        headquarters.setAddress(document.getString("address"));
        return headquarters;
    }
}

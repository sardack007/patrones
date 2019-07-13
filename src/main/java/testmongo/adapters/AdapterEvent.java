package testmongo.adapters;

import org.bson.Document;
import testmongo.models.Event;

import java.sql.Date;
import java.time.ZoneId;

public class AdapterEvent {
    public static Document eventToDocument(Event event){
        Document document = new Document();
        document.append("idHeadquarters", event.getIdHeadquarters())
                .append("name", event.getName())
                .append("avarageMark", event.getAvarageMark())
                .append("startDate", Date.valueOf(event.getStartDate()))
                .append("endDate", Date.valueOf(event.getEndDate()))
                .append("description", event.getDescription());

        return document;
    }
    public static Event documentToEvent(Document document){
        Event event = new Event();
        event.setIdEvent(document.getObjectId("_id"));
        event.setIdHeadquarters(document.getObjectId("idHeadquarters"));
        event.setName(document.getString("name"));
        event.setAvarageMark(document.getDouble("avarageMark"));
        event.setStartDate(document.getDate("startDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        event.setEndDate(document.getDate("endDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        event.setDescription(document.getString("event"));
        return event;
    }
}

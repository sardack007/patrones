package testmongo.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBSingleton {
    private static final String URI = "mongodb+srv://jimmy:mongo007@cluster0-m3pwt.mongodb.net/test?retryWrites=true&w=majority";
    private static final String DATABASE = "test";
    private static MongoClient client;
    private static MongoDatabase database;

    private DBSingleton(){
        client = new MongoClient(new MongoClientURI(URI));
        database = client.getDatabase(DATABASE);
    }

    private static class DBSingletonHelper {
        private static final DBSingleton INSTANCE = new DBSingleton();
    }

    public static DBSingleton getInstance(){
        return DBSingletonHelper.INSTANCE;
    }

    public MongoDatabase getConnection(){
        return database;
    }

    public void close(){
        client.close();
    }

}

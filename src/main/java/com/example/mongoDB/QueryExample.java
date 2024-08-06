package com.example.mongoDB;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import java.util.Iterator;

public class QueryExample {
    public static void main(String[] args) {
        // Connect to MongoDB server
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Access the database
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("testCollection");

        // Find all documents
        FindIterable<Document> iterDoc = collection.find();
        Iterator<Document> it = iterDoc.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Close the connection
        mongoClient.close();
    }
}

package com.example.mongoDB;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class UpdateExample {
    public static void main(String[] args) {
        // Connect to MongoDB server
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Access the database
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("testCollection");

        // Update a document
        collection.updateOne(Filters.eq("name", "John Doe"), Updates.set("age", 30));

        System.out.println("Document updated successfully!");

        // Close the connection
        mongoClient.close();
    }
}

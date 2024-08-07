package com.example.mongoDB;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
       //we are in mongodb example program
        // Connect to MongoDB server
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Access the database
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("testCollection");

        // Create a document
       /* Document document = new Document("name", "John Doe")
                .append("age", 29)
                .append("profession", "Software Engineer");

        // Insert the document into the collection
        collection.insertOne(document);*/
    
        List<Document> documents = new ArrayList<>();
        collection.deleteMany(new Document());
        documents.add(new Document("name", "Arjun").append("age", 7).append("profession", "Student"));
        
        documents.add(new Document("name", "Gopi").append("age", 8).append("profession", "Teacher"));

        documents.add(new Document("name", "Ramesh").append("age", 9).append("profession", "Class Teacher"));

        documents.add(new Document("name", "Kiran").append("age", 10).append("profession","Admin"));
        
        documents.add(new Document("name", "Baja").append("age", 9).append("profession", "Class Teacher"));

        documents.add(new Document("name", "Raja").append("age", 10).append("profession","Admin"));
        
        documents.add(new Document("name", "Kaja").append("age", 9).append("profession", "Class Teacher"));

        documents.add(new Document("name", "Naja").append("age", 10).append("profession","Admin"));
        
        collection.insertMany(documents);
        FindIterable<Document> iterDoc = collection.find(Filters.eq("age", 9));
        Iterator<Document> it = iterDoc.iterator();

        while (it.hasNext()) {
        	 System.out.println("the records are   " + it.next());
        }

        System.out.println("Document inserted successfully!");

        // Close the connection
        mongoClient.close();
    }
}

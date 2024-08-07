package com.example.mongoDB;
	import com.mongodb.client.MongoClients;
	import com.mongodb.client.MongoClient;
	import com.mongodb.client.MongoDatabase;
	import com.mongodb.client.MongoCollection;
	import com.mongodb.client.model.Filters;
	import org.bson.Document;

	public class DeleteExample {
	    public static void main(String[] args) {
	         // enterd in to deliete example
                 // Connect to MongoDB server
	        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

	        // Access the database
	        MongoDatabase database = mongoClient.getDatabase("mydb");

	        // Access the collection
	        MongoCollection<Document> collection = database.getCollection("testCollection");

	        // Delete a document
	        collection.deleteOne(Filters.eq("name", "John Doe"));

	        System.out.println("Document deleted successfully!");

	        // Close the connection
	        mongoClient.close();
	    }
	}



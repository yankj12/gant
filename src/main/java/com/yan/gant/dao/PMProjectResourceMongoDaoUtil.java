package com.yan.gant.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import com.yan.common.mongodb.MongoDBConfig;
import com.yan.common.util.SchameDocumentUtil;
import com.yan.gant.model.PMProjectResource;

@Repository
public class PMProjectResourceMongoDaoUtil {

	@Autowired
	private MongoDBConfig dataSource;
	
	public MongoDBConfig getDataSource() {
		return dataSource;
	}

	public void setDataSource(MongoDBConfig dataSource) {
		this.dataSource = dataSource;
	}
	
	public String insertPMProjectResource(PMProjectResource pmProjectResource){

		//To connect to a single MongoDB instance:
		//You can explicitly specify the hostname and the port:
		MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
		                                         Arrays.asList(credential));
		//Access a Database
		MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
		
		//Access a Collection
		MongoCollection<Document> collection = database.getCollection("PMProjectResource");
		
		//Create a Document
		Document doc = (Document)SchameDocumentUtil.schameToDocument(pmProjectResource, PMProjectResource.class);;
		
		//Insert a Document
		collection.insertOne(doc);
		 
		String id = null;
		if(doc.get("_id") != null){
			id = doc.get("_id").toString();
		}
		mongoClient.close();
		return id;
	}
	
	public void insertPMProjectResourceList(List<PMProjectResource> pmProjectResources){

		if(pmProjectResources != null && pmProjectResources.size() > 0) {
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
					Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMProjectResource");
			
			//Create a Document
			List<WriteModel<Document>> models = new ArrayList<>();
			for(PMProjectResource pmProjectResource : pmProjectResources) {
				Document doc = (Document)SchameDocumentUtil.schameToDocument(pmProjectResource, PMProjectResource.class);;
				models.add(new InsertOneModel<>(doc));
			}
			
			BulkWriteResult result = collection.bulkWrite(models);
			
			mongoClient.close();
		}
	}
	
	public PMProjectResource findPMProjectResourceById(String id) {
		PMProjectResource pmProjectResource = null;
		if(id!= null && !"".equals(id.trim())) {
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
			                                         Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMProjectResource");
			
			List<Document> docs = collection.find(Filters.eq("_id", new ObjectId(id))).into(new ArrayList<Document>());
			if(docs != null && docs.size() > 0) {
				pmProjectResource = (PMProjectResource)SchameDocumentUtil.documentToSchame(docs.get(0), PMProjectResource.class);
			}
			mongoClient.close();
		}
		
		return pmProjectResource;
	}
	
	public List<PMProjectResource> findPMProjectResourceListByProjectId(String projectId) {
		List<PMProjectResource> pmProjectResources = null;
		
		if(projectId!= null && !"".equals(projectId.trim())) {
			pmProjectResources = new ArrayList<>();
			
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
			                                         Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMProjectResource");
			
			List<Document> docs = collection.find(Filters.eq("projectId", projectId)).into(new ArrayList<Document>());
			if(docs != null && docs.size() > 0) {
				for(Document doc : docs) {
					PMProjectResource pmProjectResource = (PMProjectResource)SchameDocumentUtil.documentToSchame(doc, PMProjectResource.class);
					pmProjectResources.add(pmProjectResource);
				}
			}
			mongoClient.close();
		}
		
		return pmProjectResources;
	}
	
	public void updatePMProjectResource(PMProjectResource pmProjectResource){
		//To connect to a single MongoDB instance:
	    //You can explicitly specify the hostname and the port:
		MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
		                                         Arrays.asList(credential));
		//Access a Database
		MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
		
		//Access a Collection
		MongoCollection<Document> collection = database.getCollection("PMProjectResource");
		
		
		//Create a Document
		 Document doc = (Document)SchameDocumentUtil.schameToDocument(pmProjectResource, PMProjectResource.class);
		 
		 //Update a Document
		 collection.updateOne(Filters.eq("_id", doc.get("_id")), new Document("$set", doc));
		 mongoClient.close();
	}


}

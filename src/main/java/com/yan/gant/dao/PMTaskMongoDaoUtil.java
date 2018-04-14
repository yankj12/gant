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
import com.yan.gant.model.PMTask;

@Repository
public class PMTaskMongoDaoUtil {

	@Autowired
	private MongoDBConfig dataSource;
	
	public MongoDBConfig getDataSource() {
		return dataSource;
	}

	public void setDataSource(MongoDBConfig dataSource) {
		this.dataSource = dataSource;
	}
	
	public String insertPMTask(PMTask pmTask){

		//To connect to a single MongoDB instance:
		//You can explicitly specify the hostname and the port:
		MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
		                                         Arrays.asList(credential));
		//Access a Database
		MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
		
		//Access a Collection
		MongoCollection<Document> collection = database.getCollection("PMTask");
		
		//Create a Document
		Document doc = (Document)SchameDocumentUtil.schameToDocument(pmTask, PMTask.class);;
		
		//Insert a Document
		collection.insertOne(doc);
		 
		String id = null;
		if(doc.get("_id") != null){
			id = doc.get("_id").toString();
		}
		mongoClient.close();
		return id;
	}
	
	public void insertPMTaskList(List<PMTask> pmTasks){

		if(pmTasks != null && pmTasks.size() > 0) {
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
					Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMTask");
			
			//Create a Document
			List<WriteModel<Document>> models = new ArrayList<>();
			for(PMTask pmTask : pmTasks) {
				Document doc = (Document)SchameDocumentUtil.schameToDocument(pmTask, PMTask.class);;
				models.add(new InsertOneModel<>(doc));
			}
			
			BulkWriteResult result = collection.bulkWrite(models);
			mongoClient.close();
		}
	}
	
	public PMTask findPMTaskById(String id) {
		PMTask pmTask = null;
		if(id!= null && !"".equals(id.trim())) {
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
			                                         Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMTask");
			
			List<Document> docs = collection.find(Filters.eq("_id", new ObjectId(id))).into(new ArrayList<Document>());
			if(docs != null && docs.size() > 0) {
				pmTask = (PMTask)SchameDocumentUtil.documentToSchame(docs.get(0), PMTask.class);
			}
			mongoClient.close();
		}
		
		return pmTask;
	}
	
	public List<PMTask> findPMTaskListByProjectId(String projectId) {
		List<PMTask> pmTasks = null;
		
		if(projectId!= null && !"".equals(projectId.trim())) {
			pmTasks = new ArrayList<>();
			
			//To connect to a single MongoDB instance:
			//You can explicitly specify the hostname and the port:
			MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
			MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
			                                         Arrays.asList(credential));
			//Access a Database
			MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
			
			//Access a Collection
			MongoCollection<Document> collection = database.getCollection("PMTask");
			
			List<Document> docs = collection.find(Filters.eq("projectId", projectId)).into(new ArrayList<Document>());
			if(docs != null && docs.size() > 0) {
				PMTask pmTask = (PMTask)SchameDocumentUtil.documentToSchame(docs.get(0), PMTask.class);
				pmTasks.add(pmTask);
			}
			mongoClient.close();
		}
		
		return pmTasks;
	}
	
	public void updatePMTask(PMTask pmTask){
		//To connect to a single MongoDB instance:
	    //You can explicitly specify the hostname and the port:
		MongoCredential credential = MongoCredential.createCredential(dataSource.getUser(), dataSource.getDbUserDefined(), dataSource.getPassword().toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(dataSource.getIp(), dataSource.getPort()),
		                                         Arrays.asList(credential));
		//Access a Database
		MongoDatabase database = mongoClient.getDatabase(dataSource.getDatabase());
		
		//Access a Collection
		MongoCollection<Document> collection = database.getCollection("PMTask");
		
		
		//Create a Document
		 Document doc = (Document)SchameDocumentUtil.schameToDocument(pmTask, PMTask.class);
		 
		 //Update a Document
		 collection.updateOne(Filters.eq("_id", doc.get("_id")), new Document("$set", doc));
		 mongoClient.close();
	}


}

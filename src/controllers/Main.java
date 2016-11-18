package controllers;

import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Genre;
import utils.FileLogger;

public class Main {

	


	
	public static void main(String[] args) throws Exception {

	    RecommenderAPI recommender= new RecommenderAPI();
	    FileLogger logger = FileLogger.getLogger();
	    logger.log("Creating user list");

	    

	    logger.log("Serializing contacts to XML");
	    XStream xstream = new XStream(new DomDriver());
	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Datastore.xml"));
	    out.writeObject(recommender.listOfMovie);
	    out.close();    

	   
	    recommender.addUser("judy", "judy", 1, "judy", "judy");
	  
	
       System.out.println(recommender.listOfUser);
       System.out.println(recommender.listOfMovie);
       System.out.println(recommender.listOfRating);
       System.out.println(Genre.getGenreMap());
       System.out.println(Genre.genreMap.get(0));
       
       System.out.println(Genre.fromId(5));
       
       
       logger.log("Finished - shutting down");
	}
}



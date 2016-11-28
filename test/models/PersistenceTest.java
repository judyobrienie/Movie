package models;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import utils.Serializer;
import utils.XMLSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import models.User;

import controllers.RecommenderAPI;

public class PersistenceTest {

	RecommenderAPI recommender;
	
	
	 void populate(RecommenderAPI recommender)
	  {
	    for (User user : users)
	    {
	      recommender.addUser(user.firstName, user.lastName, user.age, user.gender, user.occupation);
	    }
	    for(Movie movie: movies)
	    {
	    	recommender.addMovie(movie.title , movie.releaseDate,movie.imDbUrl, movie.genre);
	    }
	   //User user1 = recommender.listOfUser.get(1);
	    
	    for(Rating rating: ratings)
	    {
	    	recommender.addRating(rating.userId, rating.movieId, rating.rating);
	    }
	    
	    
	  }
	
	
	@Test
	  public void testPopulate() throws Exception
	  { 
	   RecommenderAPI recommender = new RecommenderAPI(null);
	    assertEquals(0, recommender.getNumberOfUsers());
	    
	    populate (recommender);
	    
	    assertEquals(users.length, recommender.getNumberOfUsers());
	    assertEquals(4, recommender.sortingMovie.size());   
	  }
	
	 void deleteFile(String fileName)
	  {
	    File datastore = new File ("testdatastore.xml");
	    if (datastore.exists())
	    {
	      datastore.delete();
	    }
	  }
	
	 
	  
	  @Test
	  public void testXMLSerializer() throws Exception
	  { 
	    String datastoreFile = "testmoviestore.xml";
	    deleteFile (datastoreFile);
	    
	    Serializer serializer = new XMLSerializer(new File (datastoreFile));
	    
	    recommender = new RecommenderAPI(serializer); 
	    populate(recommender);
	    recommender.store();
	    
	    RecommenderAPI recommender2 =  new RecommenderAPI(serializer);
	    recommender2.load();
	    
	    assertEquals (recommender.getNumberOfUsers(), recommender2.getNumberOfUsers());
	    assertEquals (recommender.sortingMovie.size(), recommender2.listOfMovie.size());
	    deleteFile ("testmoviestore.xml");
	  }
	  
	  
	
	
	
}

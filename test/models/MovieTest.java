package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import static models.Fixtures.movies;


import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class MovieTest {
	static Set<Genre>genre = new HashSet<>();
	Movie movie = new Movie ("Dance", "2000", "dance.com", genre);
	
	@Before
	public void setUp() throws Exception {
		
		genre.add(Genre.CHILDRENS);
		
	}


	@Test
	 public void testCreate()
	  {
	    assertEquals ("Dance", movie.title);
	    //assertEquals ("[CHILDRENS]", movie.genre);
	    assertEquals("2000", movie.releaseDate);
	    assertEquals("dance.com", movie.imDbUrl);
	
	  }
	
	 @Test
	  public void testEquals()
	  {
	    Movie movie1 = new Movie ("Dance", "2000", "dance.com", genre);
	    

	    assertEquals(movie, movie);
	    assertNotSame(movie, movie1);
	    
	  } 

	  @Test
	  public void testToString()
	  {
	    assertEquals ("Movie{Dance" + "," +" [CHILDRENS]}", movie.toString());
	  
	  }
	  @Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (Movie movie: movies)
	    {
	     ids.add(movie.movieId);
	    }
	    assertEquals (movies.length, ids.size());
	  }
	 
	@After
	public void tearDown() throws Exception {
	}



}

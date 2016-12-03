package controllers;


import static models.Fixtures.ratings;
import static org.junit.Assert.*;


import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.RecommenderAPI;
import models.Genre;
import models.Movie;
import models.Rating;


public class RecommenderAPITest {
	RecommenderAPI test = new RecommenderAPI();
	 static Set<Genre>genre = new HashSet<>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		genre.add(Genre.CHILDRENS);
		test.addUser("Judy", "OBrien", 21, "f", "stuent");
		test.addUser("Emma", "Kelly", 8, "F", "student");
		test.addMovie("Toy Story", "1995", "test.com", genre);
		test.addMovie("Jaws", "1996", "test.com", genre);
		test.addMovie("Up", "1998", "test.com", genre);
		test.addMovie("Finding Nemo", "1956", "test.com", genre);
		test.addMovie("Cinderella", "2000", "test.com", genre);
		test.addMovie("Snow White", "1970", "test.com", genre);
		test.addMovie("Sleeping Beauty", "1965", "test.com", genre);
		test.addMovie("E.T.", "1974", "test.com", genre);
		test.addMovie("Inside Out", "2014", "test.com", genre);
		test.addMovie("Shrek", "2010", "test.com", genre);
		test.addMovie("Big", "1982", "test.com", genre);
		 
		for(Rating rating: ratings)
		    {
		    	test.addRating(rating.userId, rating.movieId, rating.rating);
		    }
		    
		    
		}
	

	/**
	 * 3. test to check that the addUser() is not not adding duplicates
	 *
	 */
	
	
	@Test
	public void testAddUser()
	{
		assertEquals(2, test.getNumberOfUsers());
		
	}
	
	
	/**
	 * 3. test to check that the addMovie() is not not adding duplicates
	 *
	 */
	@Test
	public void testAddMovie(){
		assertEquals(11, test.getNumberOfMovies());
	}
	
	
	/**
	 * 3. test to check that the getTopTenMovies() is returning only 10 movies
	 *    test of check that the top rated movie Toy Story is on top
	 *    test of check the lowest rated movie is not last at 10 is should be 11
	 */
	@Test
    public void testGetTopTenMovies(){
		assertEquals(10, test.getTopTenMovies().size()) ;
		assertEquals(test.listOfMovie.get(1l), test.sortingMovie.get(0));
		assertNotEquals(test.listOfMovie.get(11l), test.sortingMovie.get(9));
		
	}
	

	/**
	 * 3. test to check that the addRating() is not not adding duplicates
	 *
	 */
	
	@Test
	public void testAddRating(){
		
		assertEquals(1,test.listOfMovie.get(1l).movieRating.size());
		assertEquals(2,test.listOfMovie.get(2l).movieRating.size());
	}
	

	/**
	 * 3. test to check that the getUserRecommendation() is returning only 5 movies that user has not seen
	 *
	 */
	@Test
	public void testGetUserRecommendation(){
		
		assertEquals(5, test.getUserRecommendations(2l));
	}

	

	/**
	 * 3. test to check that the getMovie() is returning correct average rating
	 *
	 */
	
	@Test
	public void testGetMovie(){
		assertEquals(2.5, test.getMovie(2L), 01);
	}

	
	
	
	@After
	public void tearDown() throws Exception {
	}



}

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
	 * 14. test to check that the addUser() is not not adding duplicates and populating hash map
	 *     //CORRECT Boundary Condition
	 */
	
	
	@Test
	public void testAddUser()
	{
		assertEquals(2, test.getNumberOfUsers());
		
	}
	
	
	/**
	 * 15. test to check that the addMovie() is not not adding duplicates and populating hash map
	 *     CORRECT Boundary Condition
	 */
	@Test
	public void testAddMovie(){
		assertEquals(11, test.getNumberOfMovies());
	}
	
	
	/**
	 * 16. test to check that the getTopTenMovies() is returning only 10 movies
	 *    test of check that the top rated movie Toy Story is on top
	 *    ORDERING   Boundary Conditions
	 *    RANGE      Boundary Conditions
	 */
	@Test
    public void testGetTopTenMovies(){
		assertEquals(10, test.getTopTenMovies().size()) ;
		assertEquals(test.listOfMovie.get(1l), test.sortingMovie.get(0));
		
		//test of check the lowest rated movie is not last at 10 is should be 11
		assertNotEquals(test.listOfMovie.get(11l), test.sortingMovie.get(9));
		assertTrue(!test.sortingMovie.contains(11l));
	}
	

	/**
	 * 17. test to check that the addRating() is adding to Map
	 *     CORRECT Boundary Conditions
	 */
	
	@Test
	public void testAddRating(){
		
		assertEquals(1,test.listOfMovie.get(1l).movieRating.size());
		assertEquals(2,test.listOfMovie.get(2l).movieRating.size());
	}
	

	/**
	 * 18. test to check that the getUserRecommendation() is returning only 5 movies that user has not seen
	 *     RANGE Boundary Conditions
	 */
	@Test
	public void testGetUserRecommendation(){
		
		assertEquals(5, test.getUserRecommendations(2l));
	}

	

	/**
	 * 19. test to check that the getMovie() is returning correct average rating
	 *     Cross Check Results - Bicep
	 *     
	 *
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetMovie(){
		float averageRating;
		averageRating = 5/2;
		assertEquals(averageRating, test.getMovie(2L), 1);
		assertEquals(2.5, test.getMovie(2L), 1);
	}

	
	
	
	@After
	public void tearDown() throws Exception {
	}



}

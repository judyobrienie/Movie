package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import static models.Fixtures.movies;


import org.junit.After;
import org.junit.Before;

import org.junit.Test;

/**
 * @author Judy
 * Test for Movie Class
 * Method to set up data for testing.
 */
public class MovieTest {


	static Set<Genre>genre = new HashSet<>();
	Movie movie = new Movie ("Dance", "2000", "dance.com", genre);

	@Before
	public void setUp() throws Exception {

		genre.add(Genre.CHILDRENS);

	}


	/**
	 *  9. Method to check constructor set up 
	 *     Correct - Boundary Conditions
	 */
	@Test
	public void testCreate()
	{
		assertEquals ("Dance", movie.title);
		assertEquals("2000", movie.releaseDate);
		assertEquals("dance.com", movie.imDbUrl);

	}



	/**
	 * 10.0 Method set up to test the equality of two objects
	 *   Existence - Boundary Conditions
	 */    
	@Test
	public void testEquals()
	{
		Movie movie1 = new Movie ("Dance", "2000", "dance.com", genre);


		assertEquals(movie, movie);
		assertNotSame(movie, movie1);

	} 


	/**
	 * 11. Method set up to test the creation of toString()
	 *     Ordering - Boundary Conditions
	 */
	@Test
	public void testToString()
	{
		assertEquals ("Movie{Dance" + "," + " 2000" + ","+" [CHILDRENS]}", movie.toString());

	}

	/**
	 * 12. method set up to test id. Hashset created to ensure no duplicates
	 *     Existence - Boundary Conditions
	 */
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


	/**
	 *13. to shut down all tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}



}

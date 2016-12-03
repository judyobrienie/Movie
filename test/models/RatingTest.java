package models;


/**
 * @author Judy
 * Test for Rating Class
 * Method to set up data for testing.
 */

import static models.Fixtures.ratings;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatingTest {

	/**
	 *   Method to check constructor set up 
	 * 
	 */

	@Test
	public void testCreate()
	{
		assertEquals ( 1L, ratings[0].userId,.001);
		assertEquals (5f, ratings[0].rating,0.001);
		assertEquals(-4f, ratings[3].rating, 0.01);

	}

	/**
	 * 3. Method set up to test the creation of toString()
	 *
	 */


	@Test
	public void testToString()
	{
		assertEquals ("Rating [userId="  +  ratings[0].userId + ", movieId=" + ratings[0].movieId + ", rating="+ratings[0].rating +"]", ratings[0].toString());

	}

	@After
	public void tearDown() throws Exception {
	}



}

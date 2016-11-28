package models;




import static models.Fixtures.ratings;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatingTest {

	

	@Test
	 public void testCreate()
	  {
	    assertEquals ( 1L, ratings[0].userId,.001);
	    assertEquals (0f, ratings[0].rating,0.001);
	    assertEquals(-4f, ratings[3].rating, 0.01);
	
	  }
	
	


	  @Test
	  public void testToString()
	  {
	    assertEquals ("Rating [userId="  +  ratings[0].userId + ", movieId=" + ratings[0].movieId + ", rating="+ratings[0].rating +"]", ratings[0].toString());
	  
	  }
	
	@After
	public void tearDown() throws Exception {
	}

	

}

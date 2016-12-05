package models;



import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Test;
import static models.Fixtures.users;
/**
 * @author Judy
 * Test for User Class
 * Method to set up data for testing.
 */

public class UserTest
{
	User judy = new User ("Judy", "OBrien", 21, "f",  "student");


	/**
	 *  1. Method to check constructor set up 
	 *     Correct - Boundary Conditions
	 */
	@Test
	public void testCreate()
	{
		assertEquals ("Judy",               judy.firstName);
		assertEquals ("OBrien",             judy.lastName);
		assertEquals ("f",                  judy.gender); 
		assertEquals( 21,                   judy.age);
		assertEquals ("student",            judy.occupation);   
	}


	/**
	 * 2. method set up to test id. Hashset created to ensure no duplicates
	 *Existence - Boundary Conditions
	 */
	@Test
	public void testIds()
	{
		Set<Long> ids = new HashSet<>();
		for (User user : users)
		{
			ids.add(user.userId);
		}
		assertEquals (users.length, ids.size());
	}


	/**
	 * 3. Method set up to test the creation of toString()
	 *   Ordering - Boundary Conditions
	 */
	@Test
	public void testToString()
	{
		assertEquals ("User{Judy, OBrien, 21, f, student}", judy.toString());
	}



	/**
	 * 4.0 Method set up to test the equality of two objects
	 * Existence - Boundary Conditions
	 */   
	
	@Test
	public void testEquals()
	{
		User judy2 = new User ("Judy", "OBrien", 21, "f",  "student");
		User emma   = new User ("emma", "kelly",11, "f",  "student"); 

		assertEquals(judy, judy);
		assertNotSame(judy, judy2);
		assertNotEquals(judy, emma);
	} 



	/**
	 * to shut down all tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
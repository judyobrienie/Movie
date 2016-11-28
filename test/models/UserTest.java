package models;



import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static models.Fixtures.users;


public class UserTest
{
  User judy = new User ("Judy", "OBrien", 21, "f",  "student");

  @Test
  public void testCreate()
  {
    assertEquals ("Judy",               judy.firstName);
    assertEquals ("OBrien",             judy.lastName);
    assertEquals ("f",                  judy.gender); 
    assertEquals( 21,                   judy.age);
    assertEquals ("student",            judy.occupation);   
  }

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

  @Test
  public void testToString()
  {
    assertEquals ("User{Judy, OBrien, 21, f, student}", judy.toString());
  }
  
  @Test
  public void testEquals()
  {
    User judy2 = new User ("Judy", "OBrien", 21, "f",  "student");
    User emma   = new User ("emma", "kelly",11, "f",  "student"); 

    assertEquals(judy, judy);
    assertNotSame(judy, judy2);
    assertNotEquals(judy, emma);
  } 
  
}
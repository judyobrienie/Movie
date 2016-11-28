package models;

import java.util.HashSet;
import java.util.Set;
import models.Genre;

public class Fixtures
{
   static Set<Genre>genre = new HashSet<>();
   //genre.add(Genre.fromId(1));
   
   
   
  public static User[] users =
  {
   new User ("Jack", "OBrien", 2, "m",  "student"),
   new User ("Jack", "Kelly", 25, "m",  "student"),
   new User ("Emma", "OBrien", 2, "f",  "student"),
   new User ("Mick", "Kelly", 25, "m",  "student"),
  };
  
  
  public static Rating[] ratings =
	  {
		new Rating(1L,1L,0f),
		new Rating(1L,2L,2f),
		new Rating(2L,2L,3f),
		new Rating(2L,3L,-4f),
		
	  };
  
  public static Movie[] movies = 
	  {
    new Movie("Toy Story", "1995", "test.com", genre),
	new Movie("Jaws", "1996", "test.com", genre),
    new Movie("Up", "1998", "test.com", genre),
	new Movie("Finding Nemo", "1956", "test.com", genre),
	  };
  
}
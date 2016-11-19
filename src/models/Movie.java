package models;



import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Movie {


  static int  counter = 1;
  public static long   movieId;
  public String title;
  public String releaseDate;
  public String imDbUrl;
  public Set<Genre>genre;
  public static int totalRatings;
  
  public static List<Integer> movieRating = new ArrayList<>();
 
  
  public Movie(){
	  
  }

public Movie(String title, String releaseDate,String imDbUrl, Set<Genre>genre)
  {
	this.movieId = counter++;
    this.title = title;
    this.releaseDate = releaseDate;
    this.imDbUrl = imDbUrl;
    this.genre = genre;
   
   
  }

/*@Override
public String toString() {
	return  "  :   "+ title +  "      " + releaseDate + "     " + imDbUrl + "     " +  genre + "\n" + movieRating;
}*/


public String toString()
{
  return toStringHelper(this).addValue(title)
  							.addValue(releaseDate)
  							.addValue(imDbUrl)
  							.addValue(genre)                             
  							.toString();
}






public void addRating(Rating rating){
	
	totalRatings += Rating.getRating();
}










public static long getMovieId() {
	return movieId;
}



public void setMovieId(long movieId) {
	this.movieId = movieId;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getReleaseDate() {
	return releaseDate;
}



public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}



}

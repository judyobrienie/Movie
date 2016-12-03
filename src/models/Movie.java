package models;



import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Movie {


  public static int  counter = 1;
  public long   movieId;
  public String title;
  public String releaseDate;
  public String imDbUrl;
  public Set<Genre>genre;
  public float totalRating = 0;
  public int count = 0;
  public Float averageRating = (float) 0;
  
  public  Map<Long, Float> movieRating = new TreeMap<>();
  public List<Movie> movieByRating = new ArrayList<Movie>();

  
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

@Override
public String toString()
{
  return toStringHelper(this).addValue(title)
  							.addValue(releaseDate)
  							//.addValue(imDbUrl)
  							.addValue(genre) 
  							//.addValue(movieRating)
  							//.addValue(totalRating)
  							//.addValue(averageRating)
  							.toString();
}






public void averageRating(){
	
averageRating = totalRating/count; 
	
}










public Float getAverageRating() {
	return averageRating;
}

public void setAverageRating(Float averageRating) {
	this.averageRating = averageRating;
}

public  long getMovieId() {
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

package models;

import java.util.Date;
import java.util.Set;

public class Movie {


  
  public int   movieId;
  public String title;
  public String releaseDate;
  public String ImDbUrl;
  //private Set<Genre>genre;
 
  

public Movie(int movieId, String title, String releaseDate,String ImDbUrl)
  {
    this.movieId = movieId;
    this.title = title;
    this.releaseDate = releaseDate;
    this.ImDbUrl = ImDbUrl;
   
   
  }




@Override
public String toString() {
	return "Movie [movieId=" + movieId + ", title=" + title + ", releaseDate=" + releaseDate + ", ImDbUrl=" + ImDbUrl
			+ "]";
}




public int getMovieId() {
	return movieId;
}



public void setMovieId(int movieId) {
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



public String getImDbUrl() {
	return ImDbUrl;
}



public void setImDbUrl(String imDbUrl) {
	ImDbUrl = imDbUrl;
}




}

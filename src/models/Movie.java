package models;

import java.util.Set;

public class Movie {


  
  public int   movieId;
  public String title;
  public int releaseDate;
  public String ImDbUrl;
  private Set<Genre>genre;
 
  

public Movie(int movieId, String title, int releaseDate,String ImDbUrl, Set<Genre> genre)
  {
    this.movieId = movieId;
    this.title = title;
    this.releaseDate = releaseDate;
    this.ImDbUrl = ImDbUrl;
    this.genre = genre;
   
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



public int getReleaseDate() {
	return releaseDate;
}



public void setReleaseDate(int releaseDate) {
	this.releaseDate = releaseDate;
}



public String getImDbUrl() {
	return ImDbUrl;
}



public void setImDbUrl(String imDbUrl) {
	ImDbUrl = imDbUrl;
}



public Set<Genre> getGenre() {
	return genre;
}



public void setGenre(Set<Genre> genre) {
	this.genre = genre;
}



}

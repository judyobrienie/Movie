package models;

/**
 * @author Judy
 * @param A Movie Class 
 * @returns a title of movie 
 * @returns a release date of movie
 * @returns a genre type of each movie
 * @returns an id for each movie
 * @return a tree map for individual movie ratings
 */

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


	/** Default Constructor for objects of class Term. 
	 */
	public Movie(){

	}


	/** Constructor for object of class User. 
	 * @param title         the tile of the movie
	 * @param releaseDate      The release date of the movie
	 * @param imDbUrl      The url of the movie
	 * @parem genre	  The genre of the movie, may be more than one 
	 * 
	 * @return an individual id for each Movie and new Movie object with a hash set of genres it belongs to
	 */
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



	/**
	 * Builds a String representing a user friendly representation of the object state
	 * @return Details of the Term
	 */
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





	/**
	 * @param averageRating  the total sum of ratings divided by the count of users
	 * @return the average rating of each movie
	 */

	public void averageRating(){

		averageRating = totalRating/count; 

	}







	/**
	 * Getters and Setters
	 */


	/**
	 * @return average rating
	 */ 

	public Float getAverageRating() {
		return averageRating;
	}


	/**
	 * @param sets the average rating
	 */ 
	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}


	/**
	 * @return movie id
	 */ 
	public  long getMovieId() {
		return movieId;
	}


	/**
	 * @return sets the movie id
	 */ 

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}



	/**
	 * @return movie title
	 */ 
	public String getTitle() {
		return title;
	}



	/**
	 * @return sets movie title
	 */ 
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return get release date
	 */ 
	public String getReleaseDate() {
		return releaseDate;
	}



	/**
	 * @return set release date
	 */ 
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



}

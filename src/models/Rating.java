package models;


/**
 * @author Judy
 * @param A Ratings Class 
 */
public class Rating implements Comparable<Rating> {

	public Long userId;
	public Long movieId;
	public Float  rating;


	/** Default Constructor for objects of class Term. 
	 */
	public Rating(){
	}




	/** Constructor for object of class User. 
	 * @param userId      User Id User
	 * @param movieID     Movie Id for Movie
	 * @param rating      rating for a movie and user based on their IDs
	 *
	 * @return New Rating for a Movie from a User
	 */

	public Rating(Long userId, Long movieId, Float rating)
	{
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;

	}


	/**
	 * Builds a String representing a user friendly representation of the object state
	 * @return Details of the Term
	 */
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + "]";
	}

	/**
	 * @returns the ratings in decending order
	 */ 


	@Override
	public int compareTo(Rating that) {
		return (int) (this.rating-that.rating);
	}


	/**
	 * @returns userId
	 */ 


	public Long getUserId() {
		return userId;
	}



	/**
	 * @param sets userID
	 */ 


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	/**
	 * @returns movie id
	 */ 



	public Long getMovieId() {
		return movieId;
	}

	/**
	 * @returns sets the movie id
	 */ 



	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	/**
	 * @returns the ratings
	 */ 



	public float getRating() {
		return rating;
	}



	/**
	 * @parem sets rating
	 */ 


	public void setRating(float rating) {
		this.rating = rating;
	}

}

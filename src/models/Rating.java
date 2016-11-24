package models;



public class Rating implements Comparable<Rating> {
	
	public Long userId;
	public Long movieId;
	public Float  rating;
	

	 public Rating(){
	 }
	 
	  

	public Rating(Long userId, Long movieId, Float rating)
	  {
		this.userId = userId;
	    this.movieId = movieId;
	    this.rating = rating;
	    
	  }


	
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + "]";
	}

	@Override
	public int compareTo(Rating that) {
	return (int) (this.rating-that.rating);
	}


	public Long getUserId() {
		return userId;
	}





	public void setUserId(Long userId) {
		this.userId = userId;
	}





	public Long getMovieId() {
		return movieId;
	}





	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}





	public float getRating() {
		return rating;
	}





	public void setRating(float rating) {
		this.rating = rating;
	}

}

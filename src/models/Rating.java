package models;



public class Rating {
	
	public int userId;
	public int movieId;
	public int rating;


	 
	  

	public Rating(int userId, int movieId, int rating)
	  {
		this.userId = userId;
	    this.movieId = movieId;
	    this.rating = rating;
	    
	  }





	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public int getMovieId() {
		return movieId;
	}





	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}





	public int getRating() {
		return rating;
	}





	public void setRating(int rating) {
		this.rating = rating;
	}

}

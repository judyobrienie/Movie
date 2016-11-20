package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import models.Genre;
import models.Movie;
import models.Rating;
import models.User;
import utils.Serializer;



public class RecommenderAPI {
	private Serializer serializer;


	Map<Long,User> listOfUser = new HashMap<>();
	Map<Long, Movie>  listOfMovie= new HashMap<>();
	List<Rating> listOfRating= new ArrayList<>();
	



	public  RecommenderAPI(Serializer serializer)throws Exception {

		this.serializer = serializer; 
	}


	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		listOfUser = (Map<Long, User>) serializer.pop();
		listOfMovie  = (Map<Long, Movie>)   serializer.pop();
		listOfRating = (List<Rating>)  serializer.pop();
	}




	void store() throws Exception
	{
		serializer.push(listOfUser);
		serializer.push(listOfMovie);
		serializer.push(listOfRating);
		serializer.write(); 
	}

	public RecommenderAPI() throws Exception{
		File usersFile = new File("../Movie/lib/users5.dat");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "[ | ]";//each field in the file is separated(delimited) by a space.
		while (inUsers.hasNextLine()) {
			// get user and rating from data source
			String userDetails = inUsers.nextLine();
			userDetails=userDetails.trim();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			//create User
			User list = new User(userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]);

			listOfUser.put(Long.parseLong(userTokens[0]),list);
		}
		inUsers.close();


		File moviesFile = new File("../Movie/lib/items5.dat");
		Scanner inMovies = new Scanner(moviesFile);
		String delims1 = "[|]";//each field in the file is separated(delimited) by a space.
		while (inMovies.hasNextLine()) {
			// get movie from data source
			String movieDetails = inMovies.nextLine();
			movieDetails=movieDetails.trim();

			// parse user details string
			String[] movieTokens = movieDetails.split(delims1);

			Set<Genre>genres = new HashSet<>();

			for(int i = 4; i < Genre.values().length+4; i++){
				if(movieTokens[i].equals("1")){
					int genreId = i-4;
					genres.add(Genre.fromId(genreId));
				}

			}

			////testing hashset
			/*Iterator<Genre> iterator = genres.iterator(); 
		       System.out.println("space");
			   while (iterator.hasNext()){

			   System.out.println("Value: "+iterator.next() + " ");  
			   }/*

			//date
			/*DateFormat df = new SimpleDateFormat("yyyyMMdd");
			//String moviedate = (movieTokens[2]))
			Date date = df.parse(String.valueOf(movieTokens[2]));*/

			Movie movie = new Movie(movieTokens[1], movieTokens[2], movieTokens[3], genres);

			listOfMovie.put(Movie.getMovieId(), movie);


		}
		inMovies.close();



		File ratingsFile = new File("../Movie/lib/ratings5.dat");
		Scanner inRatings = new Scanner(ratingsFile);
		String delims2 = "[ | ]";//each field in the file is separated(delimited) by a space.

		while (inRatings.hasNextLine()) {
			// get ratings from data source
			String ratingDetails = inRatings.nextLine();
			ratingDetails=ratingDetails.trim();

			// parse user details string
			String[] ratingTokens = ratingDetails.split(delims2);


			Rating rating = new Rating((Long.parseLong(ratingTokens[0])),(Long.parseLong(ratingTokens[1])), Float.parseFloat(ratingTokens[2]));
			listOfRating.add(rating);

		}
		inRatings.close();
		
		/**
		 * Adding Ratings to Individual users
		 */

		for(int i = 0; i < listOfRating.size(); i++){
		
			
			for(Long j= (long) 1; j < listOfUser.size()+1 ; j++)
			{
			        if ((listOfRating.get(i).getUserId()).equals(j)){
					listOfUser.get(j).userRating.put((listOfRating.get(i).getMovieId()), listOfRating.get(i).getRating());	
                }
				}
		 }
			
		/**
		 * Adding Ratings to Individual Movie
		 */
           for(int i = 0; i < listOfRating.size(); i++){
		
			
			for(Long j= (long) 1; j < listOfMovie.size()+1 ; j++)
			{
			        if ((listOfRating.get(i).getMovieId()).equals(j)){
					listOfMovie.get(j).movieRating.put((listOfRating.get(i).getUserId()), listOfRating.get(i).getRating());	
					listOfMovie.get(j).addTotalRating(listOfRating.get(i).getRating());
					
                }
				}
		 }
			
		 

	}

	//Add Existing Ratings to Each Movie///////////////////////////////////////////////////////

	// System.out.println(Movie.movieRating);  





	public User addUser(Long userId, User user) {

		listOfUser.put(userId, user);
		System.out.println("New User ID = " +  userId + " :" + user + " Has Been Added to List Below"+ "\n\n" );
		return user;

	}

	public  void removeUser(long choice) 
	{
		listOfUser.remove(choice);

	}


	public Movie addMovie(Long movieId, Movie movie){
		listOfMovie.put(movieId, movie);
		System.out.println("New Movie = " +  movieId + " :" + movie + " Has Been Added to List Below"+ "\n\n" );
		return movie;

	}


public Rating addRating(Long userID, Long movieID, Float rating){
	listOfUser.get(userID).userRating.put(movieID, rating);
	
	return null;



}
}


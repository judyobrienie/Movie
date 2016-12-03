package controllers;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;




import models.Genre;
import models.Movie;
import models.Rating;
import models.User;
import utils.Serializer;
/**
 * @author Judy
 * @param RecommenderAPI instantiates a a Serializer 
 * @returns populated Array of Ratings
 * @returns populated HashMap of Users
 * @returns populated HashMap of Movies
 * @returns populated array of sorted movies
 * @returns populated map of user ratings for a instance movie
 * @rerurns populated map of movie and ratings for an instance of user
 */



public class RecommenderAPI {
	private Serializer serializer;


	public Map<Long,User> listOfUser = new HashMap<>();
	public Map<Long, Movie>  listOfMovie= new HashMap<>();
	public List<Rating> listOfRating= new ArrayList<>();
	public Map<Long, Float> movieRating = new TreeMap<>();
	public Map<Long, Float> userRating = new TreeMap<>();
	public List<Movie> sortingMovie = new ArrayList<>();




	public  RecommenderAPI(Serializer serializer)throws Exception {

		this.serializer = serializer; 

	}

	/**
	 * @param an empty Constructor 
	 */
	public RecommenderAPI() {

	}


	/**
	 * @param load from xml file 
	 */
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		sortingMovie = (List<Movie>) serializer.pop();
		listOfUser = (Map<Long, User>) serializer.pop();
		listOfMovie  = (Map<Long, Movie>)   serializer.pop();
		listOfRating = (List<Rating>)  serializer.pop();

	}

	/**
	 * @param save to xml file

	 */


	public void store() throws Exception
	{

		serializer.push(listOfRating);
		serializer.push(listOfMovie);
		serializer.push(listOfUser);
		serializer.push(sortingMovie);
		serializer.write(); 


	}


	/**
	 *@param loadDefaultfiles external files with movie, user and rating data
	 *@return populated array of ratings, populated hashmap of user, populated hashmap of movies.
	 */

	public void loadDefaultFiles() throws FileNotFoundException{

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

			listOfMovie.put(movie.getMovieId(), movie);
			sortingMovie.add(movie);


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
		 * Adding Ratings to Individual Users
		 * @return populated hash map of individual user ratings
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
		 * @return populated hash map of individual movie ratings
		 * sorting list based on userId to speed up process
		 */
		listOfRating.sort(Comparator.comparing(Rating :: getUserId));
		for(int i = 0; i < listOfRating.size(); i++){


			for(Long j= (long) 1; j < listOfMovie.size()+1 ; j++)
			{
				if ((listOfRating.get(i).getMovieId()).equals(j)){
					listOfMovie.get(j).movieRating.put((listOfRating.get(i).getUserId()), listOfRating.get(i).getRating());	

				}
			}
		}

	}   



	//////////////////////METHODS/////////////////////////////////////////////////////////////

	/**
	 *@param allUsers Total Users on File
	 *@return A list of All Users on File.
	 */

	public void allUsers(){
		Iterator<Long> iterator = listOfUser.keySet().iterator();
		while (iterator.hasNext()) {
			Long key = iterator.next();
			User value = listOfUser.get(key);

			System.out.println(key + " " + value);
		}
	}


	/**
	 *@param allMovie Total Movies on File
	 *@return A list of All Movies on File.
	 */
	public void allMovies(){
		Iterator<Long> iterator = listOfMovie.keySet().iterator();
		while (iterator.hasNext()) {
			Long key = iterator.next();
			Movie value = listOfMovie.get(key);

			System.out.println(key + " " + value);
		}
	}

	/**
	 *@param addUser Create a new instance of User
	 *@return A new user
	 *@return an updated Hash Map of type User
	 */

	public User addUser(String firstName, String lastName, int age, String gender, String occupation) {
		long userId = 1;
		User user = new User (firstName, lastName, age, gender, occupation);
		for(Long j= (long) 1; j < listOfUser.size()+1 ; j++)
		{
			userId ++;

		}
		listOfUser.put(userId, user);
		System.out.println("New User ID = " +  userId + " :" + user + " Has Been Added to List Below"+ "\n\n" );
		return user;

	}

	/**
	 *@param removeUser Remove a User from File
	 *@return Updated hash map  of All Users on File.
	 */

	public  void removeUser(long choice) 
	{
		listOfUser.remove(choice);

	}


	/**
	 *@param addMovie Create a new instance of Movie
	 *@return A new Movie
	 *@return an updated hash map of movie
	 *@return an updated array for keeping a sorted list of movies
	 */
	public Movie addMovie(String title, String releaseDate, String imDbUrl, Set<Genre>genre){
		long movieId = 1;
		Movie movie = new Movie(title, releaseDate, imDbUrl, genre);
		for(Long j= (long) 1; j < listOfMovie.size()+1 ; j++)
		{
			movieId ++;

		}

		listOfMovie.put(movieId, movie);
		sortingMovie.add(movie);
		System.out.println("New Movie = " +  movieId + " :" + movie + " Has Been Added to List Below"+ "\n\n" );
		return movie;

	}

	/**
	 *@param addRating Create a new instance of Rating
	 *@return An updated list of Ratings for sorting based on User ID
	 *@return an updated hash map of Movie Ratings
	 *@return an updated hash map of User Ratings
	 *@return an updated array for keeping a sorted list of movies
	 */

	public List<Rating> addRating(Long userID, Long movieID, Float rating){

		listOfUser.get(userID).userRating.put(movieID, rating);
		listOfMovie.get(movieID).movieRating.put((userID), rating);
		System.out.println("User : " + userID + " has added a rating of : " + rating +" to the Movie No :" + movieID + "\n");
		listOfRating.sort(Comparator.comparing(Rating :: getUserId));

		return listOfRating;
	}

	/**
	 *@param getMovie Fetch a movie based on its Movie ID
	 *@return average user rating for this movie
 @return total user rating for this movie
	 */
	public float getMovie(Long movieID){
		System.out.println("User ID and Rating Amount" + "\n");
		System.out.println(listOfMovie.get(movieID).movieRating);
		float rating = 0;
		float averageRating = 0;
		int count = 0;
		for (Float r : listOfMovie.get(movieID).movieRating.values()) {
			rating += r;
			count ++;
		}
		averageRating = rating/count;

		System.out.println("Total Rating :" + rating);
		System.out.println("Average Rating: " + averageRating);
		return averageRating;

	}   

	/**
	 *@param getTopTenMovies 
	 *@return a sorted list of Top ten rated movies by the users in descending order

	 */
	public List<Movie> getTopTenMovies(){

		for(Long j= (long) 1; j < listOfMovie.size()+1 ; j++)
		{
			for (Float r : listOfMovie.get(j).movieRating.values())
			{
				listOfMovie.get(j).totalRating += r;
				listOfMovie.get(j).count ++; 
				listOfMovie.get(j).averageRating();
			}    
		}
		//// sorting list based on average rating
		sortingMovie.sort(Comparator.comparing(Movie :: getAverageRating));
		Collections.reverse(sortingMovie);


		int index=1;
		System.out.println("List Of Top 10 Movies in Decending Order Based On Average Rating" + "\n\n");
		for(Movie movie : sortingMovie.subList(0, 10)){

			System.out.println(String.valueOf(index++)+": "+ movie);
		}
		sortingMovie = sortingMovie.subList(0,10);
		return sortingMovie;


	}

	/**
	 *@param getNumberOfUsers Total amount of Users on Files
	 *@return Size of the list of users

	 */
	public int getNumberOfUsers(){
		return listOfUser.size();

	}


	/**
	 *@param getNumberOfMovie Total amount of Movies on Files
	 *@return Size of the list of movies

	 */
	public int getNumberOfMovies(){
		return listOfMovie.size();
	}


	/**
	 *@param getUserRatings Total amount of Ratings given by One Users
	 *@return A list of the movies rated by a particular user

	 */

	public void getUserRatings(Long userID){
		System.out.println("Movie ID and Rating Amount" + "\n");
		System.out.println(listOfUser.get(userID).userRating);
		int count = 0;
		for (Float r : listOfUser.get(userID).userRating.values()) {
			count ++;
		}

		System.out.println("Total Movies Rated by " + listOfUser.get(userID).firstName + " is " + count );

	}

	/**
	 *@param getUserRecommendations Recommend a Movie that a user has not seen before
	 *@return a list in decending order of top five rated movies that have not been seen by a particular user 
	 */
	public int getUserRecommendations(Long userID){
		Set<Movie> userMovie = new HashSet<Movie>();

		for(Long j= (long) 1; j < listOfMovie.size()+1 ; j++)
		{
			for (long i = 1; i < listOfMovie.get(j).movieRating.size()+1; i++){

				if(!listOfMovie.get(j).movieRating.containsKey(userID)){
					userMovie.add(listOfMovie.get(j));
				}
			}

		}
		List<Movie> topFiveMovie = new ArrayList<>(userMovie);
		for(int j=  0; j < topFiveMovie.size() ; j++)
		{
			for (Float r : topFiveMovie.get(j) .movieRating.values())
			{
				topFiveMovie.get(j).totalRating += r;
				topFiveMovie.get(j).count ++; 
				topFiveMovie.get(j).averageRating();
			}    
		}
		topFiveMovie.sort(Comparator.comparing(Movie :: getAverageRating));
		Collections.reverse(topFiveMovie);
		List<Movie> top5Movie = new ArrayList<>();
		int index=1;
		int count=1;
		System.out.println("Recommended List Of Top Movies in Decending Order Based On Average Rating" + "\n\n");
		for(Movie movie : topFiveMovie){
			if(count <= 5){
				top5Movie.add(movie);
				System.out.println(String.valueOf(index++)+": "+ movie);
			}
			count++;
		}
		return top5Movie.size();

	}

}//end of api

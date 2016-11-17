package controllers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Movie;
import models.Rating;
import models.User;



public class Reading {

	
	Map<Long,User> listOfUser = new HashMap<>();
	List<Movie> listOfMovie= new ArrayList<>();
	List<Rating> listOfRating= new ArrayList<>();
	
	/**
	 * @param Construcor to read in a File 
	 * @returns a populated array list of type Term
	 */
	
	public  Reading() throws Exception {


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
	
			//date
			/*DateFormat df = new SimpleDateFormat("yyyyMMdd");
			//String moviedate = (movieTokens[2]))
			Date date = df.parse(String.valueOf(movieTokens[2]));*/
			Movie movie = new Movie(Integer.parseInt(movieTokens[0]),movieTokens[1], movieTokens[2], movieTokens[3]);
			
				listOfMovie.add(movie);
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
		String[] movieTokens = ratingDetails.split(delims2);

		
		Rating rating = new Rating(Integer.parseInt(movieTokens[0]),Integer.parseInt(movieTokens[1]),Integer.parseInt(movieTokens[2]));
		
			listOfRating.add(rating);
	}
			inRatings.close();
	}
}


package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
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
	List<Movie> listOfMovie= new ArrayList<>();
	List<Rating> listOfRating= new ArrayList<>();
	
	
	
	public  RecommenderAPI(Serializer serializer)throws Exception {

        this.serializer = serializer; 
	}
	
	@SuppressWarnings("unchecked")
	  public void load() throws Exception
	  {
	    serializer.read();
	    listOfUser = (Map<Long,User>)serializer.pop();
	    //listOfMovie= new ArrayList<>(); serializer.pop();
	   // listOfRating= new ArrayList<>();serializer.pop();
	    
	  }
	  
	  void store() throws Exception
	  {
	   serializer.push(listOfUser);
	    //serializer.push(listOfMovie);
	   // serializer.push(listOfRating);
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
			
			for(int i = 4; i < Genre.values().length; i++){
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
			
			Movie movie = new Movie(Integer.parseInt(movieTokens[0]),movieTokens[1], movieTokens[2], movieTokens[3], genres);
			
			  
			
			
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
	
	
	
	
	public User addUser(User user) {
	    listOfUser.put((long) (listOfUser.size()+1) , user);
	    return user;
		
	}
	

	/*  public User addUser(String firstName, String lastName,int age, String gender, String occupation){ 
	
	  System.out.println("Please enter First Name: ");
	  input.nextLine(); //swallow bug
      firstName = input.nextLine();
      System.out.println("Please enter the Surname: ");
      lastName = input.nextLine();
      boolean goodInput = false;
      age = 0;
      do {
      try {
      	System.out.println("Please enter the Age: ");
      	age = Integer.parseInt(input.nextLine());
      	goodInput = true;
      	}
      catch (Exception e) {
					        System.err.println("Num Expected - you entered text");
					        }
      	} while (!goodInput);	
      System.out.println("Please enter Gender  M or F: ");
      gender = input.nextLine();
      System.out.println("Please enter the Occupation: ");
     occupation = input.nextLine();
      User user = new User (firstName, lastName, age, gender, occupation);
	   
		listOfUser.put((long) (listOfUser.size()+1) , user);
		System.out.println(user + "Has Been Added to List of Users");
	return  user;*/
			


	
}


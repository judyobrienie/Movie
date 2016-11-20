package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.common.base.Optional;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Genre;
import models.Movie;
import models.Rating;
import models.User;

import utils.Serializer;
import utils.XMLSerializer;

public class Main {


	private static Scanner input = new Scanner(System.in);


	public static void main(String[] args) throws Exception {



		/*File  moviestore = new File("moviestore.xml");
		Serializer serializer = new XMLSerializer(moviestore);
		RecommenderAPI recommenderAPI= new RecommenderAPI(serializer); 
		if (moviestore.isFile())
		{
			recommenderAPI.load();
		}*/
		
		//Used to Read in the initial FILES
		RecommenderAPI recommender= new RecommenderAPI();
		
		System.out.println("Movie Database");
		System.out.println("-----------------");

		boolean goodInput = false;
		do{
			try{
				int option = mainMenu();
				while (option != 0)
				{
					goodInput = true;

					switch (option)
					{
					case 1:
						System.out.println("Please enter First Name: ");
						input.nextLine(); //swallow bug
						String firstName = input.nextLine();
						System.out.println("Please enter the Surname: ");
						String lastName = input.nextLine();
						boolean goodInput1 = false;
						int age = 0;
						do {
							try {
								System.out.println("Please enter the Age: ");
								age = Integer.parseInt(input.nextLine());
								goodInput1 = true;
							}
							catch (Exception e) {
								System.err.println("Num Expected - you entered text");
							}
						} while (!goodInput1);	
						System.out.println("Please enter Gender  M or F: ");
						String gender = input.nextLine();
						System.out.println("Please enter the Occupation: ");
						String occupation = input.nextLine();
						User user = new User (firstName, lastName, age, gender, occupation);
						Long userId = User.getUserId();
						recommender.addUser(userId, user);
						
						 Iterator<Long> iterator2 = recommender.listOfUser.keySet().iterator();
						    while (iterator2.hasNext()) {
						       Long key = iterator2.next();
						      User value = recommender.listOfUser.get(key);

						       System.out.println(key + " " + value);
						    }
						
						break;
					case 2:
						
						System.out.println("Choose User to Remove");
					    System.out.println("=====================");
					 // iterate map 
					    Iterator<Long> iterator = recommender.listOfUser.keySet().iterator();
					    while (iterator.hasNext()) {
					       Long key = iterator.next();
					      User value = recommender.listOfUser.get(key);

					       System.out.println(key + " " + value);
					    }
					    
						Long choice = input.nextLong();
						System.out.println("You have removed" + " : "  + recommender.listOfUser.get(choice)+ "\n");
						System.out.println("Remaining Users:     " + "\n");
						recommender.removeUser(choice);
						
						 
						 Iterator<Long> iterator1 = recommender.listOfUser.keySet().iterator();
						    while (iterator1.hasNext()) {
						       Long key = iterator1.next();
						      User value = recommender.listOfUser.get(key);

						       System.out.println(key + " " + value);
						    }
						
						break;
					case 3:
						
						System.out.println("\n" + "Current List Of Movies");
						System.out.println("=======================");
						Iterator<Long> iterator3 = recommender.listOfMovie.keySet().iterator();
					    while (iterator3.hasNext()) {
					      Long key = iterator3.next();
					      Movie value = recommender.listOfMovie.get(key);

					       System.out.println(key + " " + value);
					    }
						
						System.out.println("\n\n" +"Enter The Movie Name: ");
						input.nextLine(); //swallow bug
						String title = input.nextLine();
						System.out.println("Please enter release date: ");
						String releaseDate = input.nextLine();
						System.out.println("Please enter the ImDbURL: ");
						String imDbUrl = input.nextLine();
						System.out.println("Enter the Genre");
						System.out.println(Genre.genreMap);
						Set<Genre>genre = new HashSet<>();
						int genreId = input.nextInt();
						genre.add(Genre.fromId(genreId));
						Movie movie = new Movie(title, releaseDate, imDbUrl, genre);
						long movieId = Movie.getMovieId();
						
						
						recommender.addMovie(movieId, movie);
						
						System.out.println("\n" + "UpDated List Of Movies");
						System.out.println("=======================");

						Iterator<Long> iterator4 = recommender.listOfMovie.keySet().iterator();
					    while (iterator4.hasNext()) {
					      Long key = iterator4.next();
					      Movie value = recommender.listOfMovie.get(key);

					       System.out.println(key + " " + value);
					    }
						
						break;
					case 4:
						
						
						System.out.println("\n" + "Pick A Movie You Would Like To Rate");
						System.out.println("=======================");
						Iterator<Long> iterator5 = recommender.listOfMovie.keySet().iterator();
					    while (iterator5.hasNext()) {
					      Long key = iterator5.next();
					      Movie value = recommender.listOfMovie.get(key);

					       System.out.println(key + " " + value);
					    }
						
					    Long movieId1 = input.nextLong();
					    System.out.println("Enter Your User Id");
					    Long userId1 = input.nextLong();
					    System.out.println("Enter Your Rating between -5 being bad and 5 being excellent");
					    Float rating1 = input.nextFloat();
					    Rating rating = new Rating(userId1, movieId1, rating1);
					    recommender.addRating(userId1, movieId1, rating1);
					    
						
						
						System.out.println(recommender.listOfUser);
						
						System.out.print(recommender.listOfMovie.get(9).totalRating + "\n");
						System.out.print(recommender.listOfMovie.get(9).countUser);
						
						//System.out.println(Movie.totalRatings);
						   
						   
						
						
						break;
					case 5:
						//getMovie(movieID)
						break;
					case 6: 
						//getUserRatings(userID)
						break;
					case 7:
						// getUserRecommendations(userID)
						break;
					case 8:	  
						// getTopTenMovies()
						break;
					case 9:	 
						/*for (Map.Entry<Long, User> entry : recommender.listOfUser.entrySet()) {
					    Long key = entry.getKey();
					    User value = entry.getValue();
					    System.out.println("User ID " + key + " : " + value);}*/
						// load()

						break;
					case 10:
						//write();
						break;

					default:    System.out.println("Invalid option entered: " + option);
					mainMenu();
					break;
					}

					//pause the program so that the user can read what we just printed to the terminal window
					System.out.println("\nPress any key to continue...");
					input.nextLine();

					//display the main menu again
					option = mainMenu();
					//the user chose option 0, so exit the program
				}
				System.out.println("Exiting... bye");
				System.exit(0);

			}

			catch (Exception e) {
				input.nextLine(); //swallows bug
				System.err.println("Num expected - You Entered Text. Try Again...\n");
			}
		} while (!goodInput);  	



		//recommenderAPI.store();
	}







	/**
	 * mainMenu() - This method displays the menu for the application, 
	 * reads the menu option that the user entered and returns it.
	 * @return     the users menu choice
	 */

	private static  int mainMenu() {
		System.out.println("1) Add a New User");
		System.out.println("2) Remove an Existing User");
		System.out.println("3) Add a New Movie");
		System.out.println("4) Add a Rating for a Move");
		System.out.println("5) Get User Ratings for a Movie");
		System.out.println("6) Get Recommendations");
		System.out.println("7) List Top Ten Movies");
		System.out.println("8) Save to Datastore.xml");
		System.out.println("9) Load from Datastore.xml");
		System.out.println("0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();
		return option;
	}




}//end of main



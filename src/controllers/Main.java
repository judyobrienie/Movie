package controllers;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import models.Genre;
import utils.Serializer;
import utils.XMLSerializer;
/**
 * This is the main class that uses console i/o to interact with the user.  
 * It creates  an instance of RecommenderAPI with a serialiser to read in files in once from files ,saves them to an xml file and from there on uses file to add ongoing data.
 * 
 * 
 * Known Bugs:  When using Large File Eclipse is logging a java.lang.OutOfMemoryError: Java heap space and will not serialise the large xml file 
 * 
 * 
 * @author Judy O'Brien
 * @version 1
 */



/**
 * Creates a new scanner for i/o
 * @param a new File called moviestore.xml
 * @returns an array and hashmap of data
 * @
 */
public class Main {



	private static Scanner input = new Scanner(System.in);


	public static void main(String[] args) throws Exception {

		File  moviestore = new File("moviestore.xml");
		Serializer serializer = new XMLSerializer(moviestore);
		RecommenderAPI r= new RecommenderAPI(serializer); 
		if (moviestore.isFile())
		{
			r.load();
		}
		else r.loadDefaultFiles();



		/**
		 * Runs the program using i/o from user
		 * 
		 */

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

						r.addUser(firstName, lastName, age, gender, occupation);

						r.allUsers();

						break;
					case 2:

						System.out.println("Choose User to Remove");
						System.out.println("=====================");
						// iterate map 
						r.allUsers();

						Long choice = input.nextLong();
						System.out.println("You have removed" + " : "  + r.listOfUser.get(choice)+ "\n");
						System.out.println("Remaining Users:     " + "\n");
						r.removeUser(choice);

						r.allUsers();

						break;
					case 3:

						System.out.println("\n" + "Current List Of Movies");
						System.out.println("=======================");

						r.allMovies();

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

						r.addMovie(title, releaseDate, imDbUrl, genre);

						System.out.println("\n" + "UpDated List Of Movies");
						System.out.println("=======================");

						r.allMovies();

						break;
					case 4:


						System.out.println("\n" + "Pick A Movie You Would Like To Rate");
						System.out.println("=======================");
						r.allMovies();
						Long movieId1 = input.nextLong();
						System.out.println("Enter Your User Id");
						Long userId1 = input.nextLong();
						System.out.println("Enter Your Rating between -5 being bad and 5 being excellent");
						Float rating1 = input.nextFloat();
						// Rating rating = new Rating(userId1, movieId1, rating1);
						r.addRating(userId1, movieId1, rating1);

						break;
					case 5:
						System.out.println("\n" + "Current List Of Movies");
						System.out.println("=======================");
						r.allMovies();
						System.out.println("\n");
						System.out.println("Choose a Movie to see its Ratings" + "\n");

						Long movieID = input.nextLong();
						r.getMovie(movieID);

						break;
					case 6:
						System.out.println("\n" + "Current List Of Users");
						System.out.println("=======================");
						r.allUsers();
						System.out.println("\n");
						System.out.println("Choose a User to see their Ratings" + "\n");

						Long userID = input.nextLong();
						r.getUserRatings(userID);

						break;
					case 7:
						System.out.println("\n\n" +"Choose The User requiring recommendation: ");
						r.allUsers();
						Long userId = input.nextLong(); 
						r.getUserRecommendations(userId);
						break;
					case 8:	
						System.out.println("List Of Top 10 Rated Movies");
						System.out.println("=======================");
						r.getTopTenMovies();
						break;
					case 9:
						r.allUsers();
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
				r.store();
				System.exit(0);

			}

			catch (Exception e) {
				input.nextLine(); //swallows bug
				System.err.println("Num expected - You Entered Text. Try Again...\n");
			}
		} while (!goodInput);  	




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
		System.out.println("4) Add a Rating for a Movie");
		System.out.println("5) Get User Ratings for a Movie");
		System.out.println("6) List Ratings for a User");
		System.out.println("7) Get Recommendations");
		System.out.println("8) List Top Ten Movies");
		System.out.println("9) List All Users");


		System.out.println("0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();
		return option;
	}




}//end of main



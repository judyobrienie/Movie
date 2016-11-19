package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



import models.User;
import utils.FileLogger;
import utils.Serializer;
import utils.XMLSerializer;

public class Main {

	
	private static Scanner input = new Scanner(System.in);
    
    
	public static void main(String[] args) throws Exception {
		
		RecommenderAPI recommender= new RecommenderAPI();

		
	   /*  File  moviestore = new File("moviestore.xml");
	     Serializer serializer = new XMLSerializer(moviestore);
	     RecommenderAPI recommenderSerializer= new RecommenderAPI(serializer); 
	     if (moviestore.isFile())
	     {
	       recommenderSerializer.load();
	     }*/
    	
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
	            	      	} while (!goodInput);	
	            	      System.out.println("Please enter Gender  M or F: ");
	            	      String gender = input.nextLine();
	            	      System.out.println("Please enter the Occupation: ");
	            	     String occupation = input.nextLine();
	            	     User user = new User (firstName, lastName, age, gender, occupation);
	            	     recommender.addUser(user);
	            	   break;
	               case 2:
	            	   System.out.println(recommender.listOfUser);
	            	   //removeUser(userID)
	            	   break;
	               case 3:
	            	   //add a movie
	            	   break;
	               case 4:
	            	  // addRating(userID, movieID, rating)
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
        
        
        
       //recommenderSerializer.store();
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



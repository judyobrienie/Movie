package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import models.User;



public class Reading {

	/**
	 * creates arraylist of type User
	 */
	List<User> listOfUser = new ArrayList<>();
	
	
	/**
	 * @param Construcor to read in a File 
	 * @returns a populated array list of type Term
	 */
	
	public  Reading(File usersFile) throws Exception {


		Scanner inUsers = new Scanner(usersFile);
		String delims = "[ | ]";//each field in the file is separated(delimited) by a space.
		while (inUsers.hasNextLine()) {
			// get user and rating from data source
			String userDetails = inUsers.nextLine();
			userDetails=userDetails.trim();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			//create User
			User list = new User(Integer.parseInt(userTokens[0]), userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]);
			
				listOfUser.add(list);
		}
				inUsers.close();
		}




}

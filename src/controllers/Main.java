package controllers;

import java.io.File;




public class Main {


	//private static Scanner input = new Scanner(System.in);
	public static final File usersFile = new File("../Movie/lib/users5.dat");
	


	
	public static void main(String[] args) throws Exception {

	    Reading reading = new Reading(usersFile);
	
       System.out.println(reading.listOfUser);

	}
}



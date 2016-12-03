package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * @author Judy
 * @param A User Class 
 * @returns a name of user
 * @returns a last name of a user
 * @returns an id for each user
 * @return a tree map for individual user ratings
 */
public class User 
{
	public static int   counter = 1;
	public  long  userId;
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;
	public String email;
	public String password;


	public Map<Long, Float> userRating = new TreeMap<>();


	/** Default Constructor for objects of class Term. 
	 */
	public User()
	{
	}

	/** Constructor for object of class User. 
	 * @param firstName    The first name of User
	 * @param lastName      The last Name of the User
	 * @param age       The age of the User
	 * @parem gender	  The gener of the User
	 * @parem occupation  The occupation of the user
	 * @return an individual id for each User and New User
	 */

	public User( String firstName, String lastName,int age, String gender, String occupation)
	{
		this.userId   = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
	}


	/**
	 * Builds a String representing a user friendly representation of the object state
	 * @return Details of the Term
	 */
	public String toString()
	{
		return toStringHelper(this).addValue(firstName)
				.addValue(lastName)
				.addValue(age)
				.addValue(gender)
				.addValue(occupation)  
				//.addValue(userRating)
				.toString();

	}


	/**
	 * Getters and Setters
	 */


	/**
	 * @return user ID
	 */ 
	public  long getUserId() {
		return userId;
	}


	/**@param sets User Id. 
	 * 
	 */

	public void setUserId(long userId) {
		this.userId = userId;
	}


	/**@returns user first name
	 * 
	 */

	public String getFirstName() {
		return firstName;
	}


	/**@param sets first name of user. 
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**@returns fist name of user 
	 * 
	 */
	public String getLastName() {
		return lastName;
	}


	/**@param sets last name of user 
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**@return a users age 
	 * 
	 */
	public int getAge() {
		return age;
	}


	/**@param sets an users age. 
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**@returns a users gender. 
	 * 
	 */
	public String getGender() {
		return gender;
	}

	/**@param sets an users gender. 
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**@param returns an users occupation. 
	 * 
	 */
	public String getOccupation() {
		return occupation;
	}

	/**@param sets an users occupation 
	 * 
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**@returns a users email. 
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**@param sets an users email. 
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}





	/*
	 * @return maps the memory address to an integer value.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + counter;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}


	/**@param used to make equal comparison between two objects. 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (counter != other.counter)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


}


















  
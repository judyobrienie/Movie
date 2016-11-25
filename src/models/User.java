package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


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
  
  public User()
  {
  }
  
  public User( String firstName, String lastName,int age, String gender, String occupation)
  {
	this.userId   = counter++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(firstName)
    							.addValue(lastName)
    							.addValue(age)
    							.addValue(gender)
    							.addValue(occupation)  
    							.addValue(userRating)
    							.toString();
                              
  }

public  long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getOccupation() {
	return occupation;
}

public void setOccupation(String occupation) {
	this.occupation = occupation;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

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

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


  
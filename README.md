# Movie
Test Classes

UserTest.Java
Set up to test the User constructor  and methods

1. testCreate()Test the Creation of an Object of type User, with attributes first name, second name , age, gender, occupation
eg expecting Judy string   -  judy.firstName- test passed to show constructor working 



2. testIds()
Hash Set(which does not allow duplicates)  created form every element in ArrayList and then its size tested against hash map length to show they are both equal


3. testToString()
assertEquals used to test how i think the toString method should work - passed test to it is equal


4. testEquals() 
assertEquals() Asserts that two objects are equal. User judy2 shop equals User judy
assertSame() Asserts that two objects refer to the same object. judy andjudy2 are not the same.
assertNotEquals() Asserts that two object are not equal judy and emma are not equal

5. tearDown()
Stops all tests that have been created







RatingTest.Java
Set up to test the User constructor  and methods

6. testCreate()Test the Creation of an Object of type Ratings
eg expecting 1 long   - ratings[0].userId- test passed to show constructor working 


7. testToString()
assertEquals used to test how i think the toString method should work - passed test to it is equal


8. tearDown()
Stops all tests that have been created






MovieTest.Java
Set up to test the Movie constructor  and methods

9. testCreate()Test the Creation of an Object of type Movie
eg expecting Dance string   -  movie.title- test passed to show constructor working 

10. testEquals() 
assertEquals() Asserts that two objects are equal. movie equals movie
assertSame() Asserts that two objects refer to the same object. moive and movie2 are not the same.


11. testToString()
assertEquals used to test how i think the toString method should work - passed test to it is equal


12. testIds()
Hash Set(which does not allow duplicates)  created form every element in ArrayList and then its size tested against hash map length to show they are both equal


13. tearDown()
Stops all tests that have been created






RecommenderAPITest.Java
Set up to test the RecommenderAPI constructor  and methods


14. testAddUser()
Test to confirm that when creating a user the constructor is adding the new user to Hash Map of Users

15. testAddMovie()
Test to confirm that when creating a new movie the constructor is adding the new movie to Hash Map of Movies


16. testGetTopTenMovies()
a test to check that the getTopTenMovies() is returning only 10 movies
b. test of check that the top rated movie Toy Story is on top
c. test of check the lowest rated movie is not last at 10 is should be 11


17. testAddRating()
Test of check that when adding a rating it is also been adding to Movie Rating Map

18. testGetUserRecommendation()
Test for check that only 5 movies are being returned

19. testGetMovie()
Test to check that the correct average rating is being returned for a movie


PersistenceTest.Java
Test to check that if a xml file is not there the code will read from testPopulate()
Test to save out to file
delete file if it does exist to enable all test to run each time.


KNOWN BUG
=============

After adding the large data set to program it ran but would not read in from save xml file.  Hanging on load up and throwing Java.lang.OutOfMemoryError: heap space.

As per Google Search re problem I followed guidelines to increse spece in the eclipse.ini file.
Unfortunately this did not sort the issue at hand

startup
plugins/org.eclipse.equinox.launcher_1.3.100.v20150511-1540.jar
--launcher.library
plugins/org.eclipse.equinox.launcher.win32.win32.x86_64_1.1.300.v20150602-1417
-product
org.eclipse.epp.package.java.product
--launcher.defaultAction
openFile
--launcher.XXMaxPermSize
512M
-showsplash
org.eclipse.platform
--launcher.XXMaxPermSize
512m
--launcher.defaultAction
openFile
--launcher.appendVmargs
-vmargs
-Dosgi.requiredJavaVersion=1.7
-Xms512m
-Xmx512m




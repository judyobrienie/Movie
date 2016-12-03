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



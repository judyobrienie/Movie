# Movie
Test Classes

UserTest.Java
Set up to test the User constructor  and methods

1. testCreate()Test the Creation of an Object of type Term, with attributes  id, weight and term.
we were expecting 500.00 double weight  -  term.weight returns 500.00 -  test passed to show that they are equal
we were expecting a string shop            term.term returns a string shop - passed to show they are equal
we were expecting 0 weight testing setWeight term.weight returns 0.00 as it corrected the -1 to 0 - passed to show this was done


2. testIds()
Hash Set(which does not allow duplicates)  created form every element in ArrayList and then its size tested against hash map length to show they are both equal


3. testToString()
assertEquals used to test how i think the toString method should work - passed test to it is equal


4. testEquals() 
assertEquals() Asserts that two objects are equal. term shop equals term2 shop 
assertSame() Asserts that two objects refer to the same object. term and term2 are not the same.

5. tearDown()
Stops all tests that have been created







BruteAutoCompleteTest.java
new Constructor which takes an arraylist created to Test the methods after the creation of an Arraylist from the data of a file

1. setup() 
create an array list from a list of terms held in Fixtures File. this array list will be used to test implementaton of methods from BruteAutoComplete.  I have done this as I felt it would be hard to check a file with 10000 terms so i broke the problem down to a small list of terms that can be tested easily

2. testlistOfTerm()
this test was trying to test that no duplicates were being added to the ArrayList. Sadly I was unable to implement this in my code after many a refactor and the test is failing.  List should return 5 but is returning a size of 6.

3. testWeight()
we were expecting 2000.00 double weight  -  Search for weightOf "An" -  test passed to show that it is correct

4. testmatches()
Because this method returns an iterable string i have tested the string size for an input.  When i search for a certain prefix k number of times the string should return at least that amount.
we were expcting 2 for an input of An and the using Iterables.size to test the lenght of the iterable string.

5. testbestMatch()
Testing to check that the next highest wighted item associated with a string will be returned.  
There is no "A" string in my arrayOfTerms and so the next best match is "An"

6. tearDown()
Stops all tests that have been created


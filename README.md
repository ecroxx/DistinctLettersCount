# DistinctLettersCount
Java Command Line API which tries to count the minimum number of letters that must be deleted from a word to create a word in which no two letters occur the same number of times.

## Input:
Application accepts input file path from command line and executes result under folder src/resources/output.txt. Input txt file consist of line of Strings which are expected to be a certain format
which is restricted by several conditions.

Application will work with any valid file path. Example input file for starting app is supplied under src/resources/input.txt and it can be also used.

## Constraints:

1. The string value consists of only lowercase letters (a-z).
Otherwise application throws custom LowerCaseCharException and warn client with log message "All characters should be lowercase character between a-z."

2. The maximum character number of the input line is 300000.
Otherwise application throws custom MaximumCharException and warn client with log message "The maximum character number of the input line should be 300000."

3. The minimum character number of the input line is 1.
Otherwise application throws custom MinimumCharException and warn client with log message "The minimum character number of the input line should be 1."

Before all of above custom exceptions, lines of error in the file is indicated. For other exception types such as "FileNotFoundException,IOException etc." client also warned by logs.
All initialization and determination steps of application is indicated by INFO Logs.

## Output:
Result file is under src/resources/output.txt . The solution for each test case is printed out on a single line. On this line the line number and the solution value are printed. 

If there is no need to delete any character then printed 0.
If there is exception for invalid line constraint then print Integer.MIN value. By the way it is easily seen that which input lines have error in output line. 
The error line number is also written before each exception in logs.

## Test:
All exceptions unit tests and Functionality test for CalculationService is written. By the way all variations can be tested by unit tests.  

## Algorithm: 
In order to calculate DistinctLettersCount, Greedy algorithm is used with HashSet :

1. Method counts number of occurencies/ frequency of each character firstly. 

2. After that by using HashSet which does not allow duplicate values and which has O(1) add/contains time complexity, try to add each unappeared frequency one by one.
If is included HashSet decrease frequency until reach non-inlucded HashSet value and increase result while decreasing frequency

3. Return result which is amount of total increase == delete of frequency == delete of char. 

4. Repeat this logic for each line of file.

Time Complexity : O(N x M) where M is length of String and N is number of lines. 

Space Comlexity : O(N X M) because of storing frequency of (M)each char of N strings for frequency map. 

It is arguable that time and space complexity is O(N x c)=> O(N) where M is restricted by constant value 300000 and N is number of lines.

### Contributed By:
Egemen Ozkan 2021





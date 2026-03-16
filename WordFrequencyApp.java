
import java.util.ArrayList;
import java.util.Scanner;

public class WordFrequencyApp {

  // Creates ArrayLists
private ArrayList<String> foundWords;
private ArrayList<Integer> counts;
 
  // Assigns initial values for your instance variables
  public WordFrequencyApp() {
    foundWords = new ArrayList<String>();
    counts = new ArrayList<Integer>();
  }

  /**
   * Javadoc example
   * @param parameter1 the first parameter
   * @return what is returned from this method
   */

  /**
   * Starts the app and gets user input. Then, it calls all the following methods
   *
   * Precondition: countWords(), sortByFrequency(), and printSummary() must be defined within the scope of the program
   * Postcondition: The correct input is taken in from the user and run through all of the methods
   * @param: N/A. There is no parameter for this method
   * @return: N/A. There is no return value for this method
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);
   
    // Starting text
    System.out.println("Enter a sentence to be analyzed:");
    String userInput = input.nextLine(); // collect userInput
 
    countWords(userInput);
    sortByFrequency();
    printSummary();
    input.close();
  }
 
/**
* Splits the text into parts and counts the frequeny of it
*
* Precondition: the argument for input exists
* Postcondition: The word and its corresponding frequency are put into counts and foundWords
* @param: String input: Represents the String given by the user
* @return: N/A. There is no return value for this method
*/
public void countWords(String input) {
   int space = input.indexOf(" "); // finds the index of the space
   while (space != -1) { // while there is a space
    String word = input.substring(0, space); // the word goes from the start of the list to that space
    int position = foundWords.indexOf(word); // what index or position "word" is at
     if (position == -1) { // if that position doesn't exists
      foundWords.add(word); // add the word to it
      counts.add(1); // add one to count to mark its presence
      } else { // otherwise else
      counts.set(position, counts.get(position) + 1); // add one to the count already declared for that word
    }
    input = input.substring(space + 1); // starts input at the index one past the space
    space = input.indexOf(" "); // finds the next space
   }

  // this part is used to find the last word with the same process
  String word = input;
  int position = foundWords.indexOf(word);

  if (position == -1) {
    foundWords.add(word);
    counts.add(1);

   } else {
     counts.set(position, counts.get(position) + 1);
    }
  }

/**
* Sorts the text within the ArrayLists by descending order
*
* Precondition: foundWords and counts must have appropriate arguments contained in them
* Postcondition: The foundWords and counts list is correctly sorted in descending order
* @param: N/A. There is no parameter for this method
* @return: N/A. There is no return value for this method
*/
public void sortByFrequency() {
  for (int i = 0; i < counts.size(); i++) { // for all elements in counts
    int maxIndex = i; // set the max index to i as the element from the outer
    for (int j =  i + 1; j < counts.size(); j++) { // for all the elements one after the one in the outer loop
      if (counts.get(j) > counts.get(maxIndex)) { // if that element from the inner is greater than the one from the outer
        maxIndex = j; // set maxIndex as j
      }
    }
    int current = counts.get(i); // gets the current element at the element from the outer
    counts.set(i, counts.get(maxIndex)); // set the element at that index to the one with the max count
    counts.set(maxIndex, current); // set the temp value to the one that just got replaced

    String tempWord = foundWords.get(i); // gets the corresponding word name at the element from the outer
    foundWords.set(i, foundWords.get(maxIndex)); // sets the corresponding word name at the index to the one with its corresponding max count
    foundWords.set(maxIndex, tempWord); // sets the temp value to the one that just replaced
  }
}
 
  /**
   * Prints the summary of my NLP project
   *
   * Precondition: The correct values are already in the foundWords and counts arraylists
   * Postcondition: The words and frequency are all printed correctly into the console
   * @param: N/A. There is no parameter for this method
   * @return: N/A. There is no return for this method.
   */
  public void printSummary() {
    System.out.println("\nFrequency Results: "); // title header
    for (int i = 0; i < foundWords.size(); i++) { // for every word in the foundWords list
      System.out.println(foundWords.get(i) + " is found " + counts.get(i) + " times."); // prints every individual word in foundWords
    }
  }

}

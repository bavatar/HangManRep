import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      ArrayList<String> actionItems = new ArrayList<String>();
      //actionItems.add("red");
      //actionItems.add(0, "yellow");  // add yellow at index==0
      actionItems.add("tree");
      actionItems.add("rain");
      actionItems.add("bear");
      actionItems.add("encourage");
      actionItems.add("promise");
      actionItems.add("soup");
      actionItems.add("chess");
      actionItems.add("insurance");
      actionItems.add("pancakes");
      actionItems.add("stream");
      Random rnd = new Random();
      // randomly choose a word from actionItems
      int randomInt = rnd.nextInt(actionItems.size());
      Scanner sc = new Scanner(System.in);

      int guessCnt = 0;
      String guess = "";
      String guessMatch = "__________"; // Partial word guessed so far
      char[] guessChArray = {'_', '_', '_', '_','_', '_', '_', '_','_', '_'}; // length of 10
      String guessString = new String (guessChArray); // string version of guessChArray

      String chosenWord = actionItems.get(randomInt);
      System.out.println("The Chosen Word is: " + chosenWord);
      System.out.println("Welcome, let's play hangman!");

      while (true) {
        System.out.println("Enter your Guess - either a letter or the whole word.");
        guessCnt++;
        if (guessCnt > 8){
          System.out.println("Sorry you have exceeded your guess limit of 5 - Game Over");
          break;
        }
        guess = sc.nextLine();

        if (guess.length() == 1) {
          // Guessing a charcter
          // guess.charAt(5)
          // str_Sample.indexOf('S')

          System.out.println("You have guessed character: " + guess.charAt(0));
          for (int i=0; i<chosenWord.length(); i++){
            if (chosenWord.charAt(i)== guess.charAt(0)){
              guessChArray[i] = guess.charAt(0);
              //System.out.println("There is a match with character: " + guess.charAt(0));
              //System.out.println("The updated guessChArray at i: " + i + " is: " + guessChArray[i]);
              //System.out.println("Your guessChArray is: " + guessChArray);
            }
          }
          //System.out.println("Your guessChArray is: " + guessChArray.toString());
          //guessString = guessChArray.toString();
          guessString = new String(guessChArray);
          guessString = guessString.substring(0, chosenWord.length());
          System.out.println("Your guess is: " + guessString);
          if (guessString.equalsIgnoreCase(chosenWord)){
            System.out.println("Congratulations You have Guessed the Hidden word:: " + chosenWord + " correctly!");
            break;
          }
          //System.out.println("Your guess is: " + guessMatch);
          //guessMatch.substring(chosenWord.length()-1);
          //System.out.println("Your guess is:: " + guessMatch);
        } else {
          // Guessing a word
          if (guess.equalsIgnoreCase(chosenWord)) {
            System.out.println("Congratulations You have Guessed the Hidden word: " + chosenWord + " correctly!");
            break;
          }
          else {
            System.out.println("You have guessed Incorrectly - Game Over");
            break;
          }
        }
      }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Scanner;

/**
 *
 * @author keonj9218
 */
public class A5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //scanner to get user input
        Scanner input = new Scanner(System.in);
        while (true) {
            //asking the user to type in their word
            System.out.println("Player 1:Enter word for Player 2 to guess:");
            //scanning their word into a variable
            String word = input.nextLine();
            //turns the whole world to lower case
            word = word.toLowerCase();
            //create blanks so Player 2 can not see the word
            for (int spaces = 0; spaces < 15; spaces++) {
                System.out.println(" ");
            }
            //tell how many characters there are
            int length = word.length();
            //create a blank string
            String dash = "";
            // for every letter there is create 1 dash
            for (int a = 0; a < length; a++) {
                dash = dash + "-";
            }
            //create stringbuilder
            StringBuilder place = new StringBuilder(dash);
            //created a int for how many correct letters the player guesses
            int correct = 0;
            //created a int for how incorrect letters the player guesses
            int lives = 6;
            //while lives are greater than 0 repeat
            while (lives > 0) {
                //print the amount of dashes in the output box
                System.out.println(place);
                //tell the player how many lives its has left
                System.out.println("Player 2: You have " + lives + " left. Guess a letter:");
                //scanning their guess into a variable
                String guess = input.nextLine();
                //turn the guess to a lowercase
                guess = guess.toLowerCase();
                //create a variable at position 0 for the letter guessed
                char character = guess.charAt(0);
                //create a variable to find the position of the guessed letter
                int pos = word.indexOf(character);
                // if the position is greated than or equal to 0
                if (pos >= 0) {
                    //say the player guessed the right letter
                    System.out.println("You guessed the right letter. Keep going!");
                    // while the postion is greater or equal to 0 repeat
                    while (pos >= 0) {
                        // use stringbuilder to replace the guessed letter to the proper spot in the word
                        place.setCharAt(pos, character);
                        pos = word.indexOf(character, pos + 1);
                        // if there is a two of the same letters in the word give them another point
                        if (pos >= 0) {
                            correct++;
                        }
                    }
                    //give them a point for guessing the right letter
                    correct++;
                    //if all thats not true do this instead
                } else {
                    //say you have lost a life
                    System.out.println("You lost a life.");
                    //take away a life
                    lives--;
                }
                // if the amount of correct letters guessed equals the length of the word
                if (correct == length) {
                    //say you won the game
                    System.out.println("You guessed the whole word. Congratulations!");
                    //break so it doesn't repeat
                    break;
                }
            }
            //if the correct words is less than the length
            if (correct < length) {
                //say they lost
                System.out.println("You have lost all your lives. You Lose!");
                //tell the player what the correct word was
                System.out.println("The correct word was" + word + ".");
            }
            //ask if they want to play again
            System.out.println("Do you want to play again? (Yes / No)");
            //scanning in their response
            String declined = input.nextLine();
            //turn the response to lowercase
            declined = declined.toLowerCase();
            //if they say no
            if (declined.equals("no")) {
            //break the code
                break;
            }
        }


    }
}
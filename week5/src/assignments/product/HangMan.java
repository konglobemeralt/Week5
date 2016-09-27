package assignments.product;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The very well known Hangman game (in a text version)
 *
 *  This is the main program (program starts here)
 *
 *
 *  Recommended process
 *
 *  1. Sketch the logical skeleton using functional decomposition and abstraction
 *  (to find methods), This can be done using only comments (or pencil and paper)
 *  2. Working from both direction (top down = functional decomposition) and/or bottom up (using classes)
 *  Try to add variables and methods in classes
 *  You may try to guess (or imagine) what method could be useful for a class (if not remove them)
 *
 *  4. IMPORTANT: Contact an assistant for a talk about your ideas when you have a skeleton
 *
 *  5. Implement and test the FileService
 *  6. Implements and test one method at the time.
 *  7. Until finished
 *
 */
public class HangMan {

    private final Scanner sc = new Scanner(in);
    private final Random rand = new Random();

    public static void main(String[] args) {
        new HangMan().program();
    }

    private enum Result {
        WIN,
        LOOSE
    }

    private int nGuess = 0;
    private Result result;

    private void program() {

        String[] words = null;
        try {
            words = FileService.readFile(FileService.WORD_PATH, "words.txt");
        } catch (FileNotFoundException e) {
            out.println("Ett fel uppstod, filen med ord kunde inte hittas (eller läsas)!");
            return;
        }


        Secret secret = new Secret(words[rand.nextInt(words.length)]);
        // TODO
        // Create a Man and a Secret




        Man man = new Man();

        while (!man.isDead() && !secret.isSolved()) {
            Character nextGuess = sc.next().charAt(0);
            if(secret.isValidQuess(nextGuess)) {
                if(secret.isCorrectGuess(nextGuess)) {
                    secret.updateStrings(nextGuess);
                    System.out.println("You guessed right!");
                }else {
                    man.nextStage();
                    System.out.println("You guessed wrong!");
                }
            }else {
                System.out.println("Please enter a character you have not inserted before.");
            }
            man.plot();
        }

        if(man.isDead()) {
            man.plot();
            System.out.println("You lost!");
        }else {
            System.out.println("You won!");
        }




        // TODO
        // The logical skeleton here

    }

    // ---- IO don't belong to classes, put it here ---------------
    private char guessCharacter() {
        out.println("Guess a char > ");
        return sc.nextLine().charAt(0);
    }

    private void plotMask(String mask) {
        out.println();
        for (char ch : mask.toCharArray()) {
            out.print(ch + " ");
        }
        out.println();
    }

}

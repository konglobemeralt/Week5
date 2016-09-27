package assignments.basics;

import java.util.Random;
import java.util.Scanner;
import assignments.basics.Player;
import assignments.basics.TicTacToeBoard;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  This file should be split in more files to get a "standard" Java application.
 *
 *  To create a file in IntelliJ: Mark /basics > New > Java Class > Write name > Ok.
 *
 *  NOTE: During the process there will be many errors, don't bother.
 *  When finished the errors should be gone.
 *  TIP: To replace many occurrences of a text: Mark text, press Ctrl + r.
 *
 *  Process:
 *  1. Create a file Player. Move class Player from here to the Player file
 *  2. Create a file Board. Move class Board from here to Board file
 *  3. Make all instance variables for all classes private.
 *  4. If a variable must be accessible to other classes, add a get-Method (or a method
 *     that can be used by other classes to achieve the desired effect)
 *  5. Replace all "direct" usages if variables with calls to get-methods
 *  6. Decide for all classes which methods are public and which are private
 *  6. When finished: Functionality is the same but structure of program better.
 *  7: Run it.
 *
 *
 */
public class TicTacToe {

    public static void main(String[] args) {
        new TicTacToe().program();
    }

    final Random rand = new Random();

    void program() {
        Player p1 = new Player("Olle", 'X');
        Player p2 = new Player("Pelle", 'O');
        Player winner = null;

        TicTacToeBoard board = new TicTacToeBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);
        Player actual = p1;   // Bad, jus for now

        while (!board.isFull()) {

            boolean correctPlay;

            do {
                correctPlay = true;
                // -- Input ----------
                int index = getPlayerSelection(actual);
                if(index < 0 || index > 8) {
                    out.println("Enter a number between 0 and 8");
                    correctPlay = false;
                    break;
                }

                // --- Process ----------
                if (board.isEmpty(index)) {
                    board.getPositions()[index] = actual.getMark();
                    if (board.hasWinner(actual.getMark())) {
                        winner = actual;
                        break;
                    }
                    // -- Output --------
                    plotBoard(board);

                    // Book keeping
                    if (actual == p1) {
                        actual = p2;
                    } else {
                        actual = p1;
                    }
                    } else {
                        out.println("The selected position is not empty");
                        correctPlay = false;
                    }

            }while(!correctPlay);

        }

        out.println("Game over!");
        plotBoard(board);
        if(winner != null) {
            out.println("Winner is " + winner.getName());
        } else {
            out.println("Draw");
        }
    }

    // --- Input/output is outside class
    int getPlayerSelection(Player player) {
        out.println("Player is " + player.getName() + "(" + player.getName() + ")");
        Scanner sc = new Scanner(in);
        out.print("Select position to put mark > ");
        return sc.nextInt();
    }

    void plotBoard(TicTacToeBoard b) {
        for (int i = 0; i < b.getPositions().length; i++) {
            out.print(b.getPositions()[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }



}
package assignments.basics;

import java.util.Random;
import java.util.Scanner;

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
        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("pelle", 'O');
        Player winner = null;

        TicTacToeBoard board = new TicTacToeBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);
        Player actual = p1;   // Bad, jus for now

        while (!board.isFull()) {
            // -- Input ----------
            int index = getPlayerSelection(actual);

            // --- Process ----------
            if (board.isEmpty(index)) {
                board.positions[index] = actual.mark;
                if (board.hasWinner(actual.mark)) {
                    winner = actual;
                    break;
                }
            }
            // -- Output --------
            plotBoard(board);

            // Book keeping
            if (actual == p1) {
                actual = p2;
            } else {
                actual = p1;
            }
        }

        out.println("Game over!");
        plotBoard(board);
        if (winner == p2) {
            out.println("Winner is " + p2.name);
        } else if (winner == p1) {
            out.println("Winner is " + p1.name);
        } else {
            out.println("Draw");
        }
    }

    // --- Input/output is outside class
    int getPlayerSelection(Player player) {
        out.println("Player is " + player.name + "(" + player.mark + ")");
        Scanner sc = new Scanner(in);
        out.print("Select position to put mark > ");
        return sc.nextInt();
    }

    void plotBoard(TicTacToeBoard b) {
        for (int i = 0; i < b.positions.length; i++) {
            out.print(b.positions[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // ------- Classes ----------------

    class Player {
        final String name;
        final char mark;

        public Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    class TicTacToeBoard {

        final char[] positions = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical positions

        // Instance methods below
        // Can't place any more marks if true
        boolean isFull() {
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == '-') {
                    return false;
                }
            }
            return true;
        }

        boolean hasWinner(char mark) {
            return hasUpDiagonal(mark) || hasDownDiagonal(mark)
                    || hasFullRow(mark) || hasFullColumn(mark);
        }

        boolean hasFullColumn(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i] == mark && positions[i + 3] == mark
                        && positions[i + 6] == mark) {
                    return true;
                }
            }
            return false;
        }

        boolean hasUpDiagonal(char mark) {
            return positions[6] == mark && positions[4] == mark
                    && positions[2] == mark;
        }

        boolean hasDownDiagonal(char mark) {
            return positions[0] == mark && positions[4] == mark
                    && positions[8] == mark;
        }

        boolean hasFullRow(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i * 3] == mark && positions[i * 3 + 1] == mark
                        && positions[i * 3 + 2] == mark) {
                    return true;
                }
            }
            return false;
        }

        // Is position "index" empty
        boolean isEmpty(int index) {
            return positions[index] == '-';
        }

    }
}
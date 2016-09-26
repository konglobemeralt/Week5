package samples.gameoflife;

import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

/**
 * Class representing the world
 */
public class World {

    private final Cell[][] cells;

    public World(int nCells, double percentAlive) {
        Cell[] tmp = new Cell[nCells];
        int nAlive = (int) round(percentAlive / 100 * nCells);

        int i = 0;
        while (nAlive > 0) {
            tmp[i] = new Cell(Cell.State.ALIVE);
            nAlive--;
            i++;
        }
        while (i < nCells) {
            tmp[i] = new Cell(Cell.State.DEAD);
            i++;
        }
        cells = toMatrix(shuffle(tmp));
    }


    public void updateWorld() {

        // Make a *deep* copy because neighbours impact
        Cell[][] tmp = copy();

        // Update on the copy
        for (int row = 0; row < size(); row++) {
            for (int col = 0; col < size(); col++) {
                int nAlive = getLivingNeighbours(row, col);
                if (nAlive > 3) {
                    tmp[row][col].setState(Cell.State.DEAD);
                } else if (nAlive == 3) {
                    tmp[row][col].setState(Cell.State.ALIVE);
                } else if (nAlive < 2) {
                    tmp[row][col].setState(Cell.State.DEAD);
                } else {
                    tmp[row][col] = cells[row][col];  // No change
                }
            }
        }
        // Copy back
        for (int row = 0; row < size(); row++) {
            for (int col = 0; col < size(); col++) {
                cells[row][col] = tmp[row][col];
            }
        }
    }

    private int getLivingNeighbours(int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (!(row == r && col == c) && isValidLocation(r, c)) {
                    if (cells[r][c].getState() == Cell.State.ALIVE) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isValidLocation(int row, int col) {
        return row >= 0 && col >= 0 && row < cells.length && col < cells.length;
    }

    // NOTE: Deep copy
    private Cell[][] copy(){
         Cell[][] tmp = new Cell[size()][size()];
        for (int row = 0; row < size(); row++) {
            for (int col = 0; col < size(); col++) {
                tmp[row][col] = new Cell(cells[row][col]);  // Here!! Must make new Cell
            }
        }
        return tmp;
    }


    private Cell[][] toMatrix(Cell[] arr) {
        int size = (int) round(sqrt(arr.length));
        Cell[][] matrix = new Cell[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }


    final Random rand = new Random();

    Cell[] shuffle(Cell[] cells) {
        for (int i = cells.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            Cell c = cells[i];
            cells[i] = cells[j];
            cells[j] = c;
        }
        return cells;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int size() {
        return cells.length;
    }
}

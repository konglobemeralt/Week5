package samples.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */
public class GameOfLife extends JPanel {

    public static void main(String[] args) {
        new GameOfLife().program();
    }


    private World world;

    void program() {
         world = new World(900, 25);
        initGraphics();
        initEvents();
    }

    private void updateWorld(){
        world.updateWorld();
    }

    // -------- For testing ----------------
    <T> void plot(T[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

    // -------- Below is just initialization and graphics --------------
    final int width = 400;
    final int height = 400;
    final int delay = 1000;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int size = world.size();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;
                drawCell(g2, x, y, world.getCell(row, col));
            }
        }
        Toolkit.getDefaultToolkit().sync(); // Possibly Linux specific
    }

    void drawCell(Graphics2D g2, int x, int y, Cell cell) {
        if (cell.getState() == Cell.State.ALIVE) {
            g2.setColor(Color.RED);
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fillOval(x, y, 10, 10);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Game of Life");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        Timer timer = new Timer(delay,
                e -> {
                    updateWorld();
                    repaint();
                }); // Add this as action listener
        timer.setInitialDelay(delay);
        timer.start();
    }

}
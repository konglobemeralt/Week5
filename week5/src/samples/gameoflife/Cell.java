package samples.gameoflife;

/*
 * Class representing a Cell.
 * Not very useful right now, but things may show up ...
 */
public class Cell {

    public enum State {
        DEAD, ALIVE;
    }

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public Cell(Cell other) {
        state = other.state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

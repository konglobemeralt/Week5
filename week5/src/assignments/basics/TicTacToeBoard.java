package assignments.basics;


class TicTacToeBoard {

    private final char[] positions = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical positions

    // Instance methods below
    // Can't place any more marks if true
    public boolean isFull() {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinner(char mark) {
        return hasUpDiagonal(mark) || hasDownDiagonal(mark)
                || hasFullRow(mark) || hasFullColumn(mark);
    }

    public boolean hasFullColumn(char mark) {
        for (int i = 0; i < 3; i++) {
            if (positions[i] == mark && positions[i + 3] == mark
                    && positions[i + 6] == mark) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpDiagonal(char mark) {
        return positions[6] == mark && positions[4] == mark
                && positions[2] == mark;
    }

    private boolean hasDownDiagonal(char mark) {
        return positions[0] == mark && positions[4] == mark
                && positions[8] == mark;
    }

    private boolean hasFullRow(char mark) {
        for (int i = 0; i < 3; i++) {
            if (positions[i * 3] == mark && positions[i * 3 + 1] == mark
                    && positions[i * 3 + 2] == mark) {
                return true;
            }
        }
        return false;
    }

    // Is position "index" empty
    public  boolean isEmpty(int index) {
        return positions[index] == '-';
    }


    public char[] getPositions()
    {
        return this.positions;
    }


}

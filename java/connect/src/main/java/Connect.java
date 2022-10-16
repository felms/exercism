import java.util.Arrays;

class Connect {

    private final String[][] board;
    private final int rows;
    private final int columns;

    public Connect(String[] board) {
        this.rows = board.length;
        this.board = new String[this.rows][];

        for (int i = 0; i < this.rows; i++) {
            this.board[i] = board[i].trim().split(" ");
        }

        this.columns = this.board[0].length;

    }

    public Winner computeWinner() {

        boolean isEmpty = Arrays.stream(this.board).noneMatch(row -> {
            String r = Arrays.toString(row);
            return r.contains("X") || r.contains("O");
        });

        if (isEmpty) {
            return Winner.NONE;
        }

        if (this.rows == 1 && this.columns == 1) {
            String p = this.board[0][0];
            return p.equals("X") ? Winner.PLAYER_X
                    : p.equals("O") ? Winner.PLAYER_O
                    : Winner.NONE;
        }

        return playerXWon() ? Winner.PLAYER_X
                : playerOWon() ? Winner.PLAYER_O
                : Winner.NONE;
    }

    private boolean playerXWon() {

        boolean allColumnsHaveXs = true;
        for (int column = 0; column < this.columns; column++) {
            int countXs = 0;
            for (int row = 0; row < this.rows; row++) {
                if (this.board[row][column].equals("X")) {
                    countXs++;
                }
            }
            allColumnsHaveXs = allColumnsHaveXs && countXs > 0;
        }

        if (!allColumnsHaveXs) {
            return false;
        }

        // gets the index of the 'X' played in the first column
        int index = 0;
        int c = 0;

        for (int row = 0; row < this.rows; row++) {
            if (this.board[row][0].equals("X")) {
                index = row;
                break;
            }
        }

        boolean stuck = false;
        while (!stuck) {

            this.board[index][c] = "*";

            if (c == this.columns - 1) {
                return true;
            }

            if (this.board[index][c + 1].equals( "X")) { // right
                c++;
            } else if (c > 0 && this.board[index][c - 1].equals( "X")) { // left
                c--;
            } else if (index > 0 && this.board[index - 1][c].equals("X")) { // up
                index--;
            } else if (index < this.rows - 1 && this.board[index + 1][c].equals("X")) { // down
                index++;
            } else if (index > 0 && this.board[index - 1][c + 1].equals("X")) { // diagonal 1
                index--;
                c++;
            } else if (index < this.rows - 1 && c > 0
                    && this.board[index + 1][c - 1].equals("X")) { // diagonal 2
                index++;
                c--;
            } else {
                stuck = true;
            }
        }

        return false;
    }

    private boolean playerOWon() {

        boolean allRowsHaveOs = Arrays.stream(this.board)
                .allMatch(row -> Arrays.toString(row).contains("O"));

        if (!allRowsHaveOs) {
            return false;
        }

        // gets the index of the 'O' played in the first row
        int r = 0;
        int index = 0;
        for (int column = 0; column < this.columns; column++) {
            if (this.board[0][column].equals("O")) {
                index = column;
                break;
            }
        }

        boolean stuck = false;

        while(!stuck) {

            this.board[r][index] = "*";

            if (r == this.rows - 1) {
                return true;
            }

            if (this.board[r + 1][index].equals("O")) { // down
                r++;
            } else if (index > 0 && this.board[r][index - 1].equals("O")) { // left
                index--;
            } else if (index < this.columns - 1 && this.board[r][index + 1].equals("O")) { // right
                index++;
            } else if (index > 0 && this.board[r + 1][index - 1].equals("O")) { // diagonal
                r++;
                index--;
            } else {
                stuck = true;
            }
        }

        return false;
    }
}

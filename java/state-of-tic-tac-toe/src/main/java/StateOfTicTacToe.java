import java.util.List;

class StateOfTicTacToe {

    private static final char X_PLAYER = 'X';
    private static final char O_PLAYER = 'O';

    public GameState determineState(String[] board) {
        String theBoard = String.join("", board);
        int numberOfXs = theBoard.replaceAll("[^X]", "").length();
        int numberOfOs = theBoard.replaceAll("[^O]", "").length();

        if ((numberOfXs - numberOfOs) > 1) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }

        if (numberOfOs > numberOfXs) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        }

        boolean xWon = playerWon(X_PLAYER, theBoard);
        boolean oWon = playerWon(O_PLAYER, theBoard);

        if (xWon && (numberOfXs == numberOfOs)) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }

        if (xWon && oWon) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }

        if (xWon || oWon) {
            return GameState.WIN;
        }

        if (!theBoard.contains(" ")) {
            return GameState.DRAW;
        }

        return GameState.ONGOING;
    }

    private boolean playerWon(char player, String board) {

        List<List<Integer>> winningPositions = List.of(
                List.of(0, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8), // horizontal
                List.of(0, 3, 6), List.of(1, 4, 7), List.of(2, 5, 8), // vertical
                List.of(0, 4, 8), List.of(2, 4, 6)                    // diagonal
        );

        return winningPositions.stream().anyMatch(pos -> wonAtPos(player, board, pos));
    }

    private boolean wonAtPos(char player, String board, List<Integer> position) {
        return position.stream().allMatch(i -> board.charAt(i) == player);
    }
}
class StateOfTicTacToe {
    public GameState determineState(String[] board) {

        checkBoard(board);

        if (playerWon("X", board) || playerWon("O", board)) {
            return GameState.WIN;
        }

        if (gameTied(board)) {
            return GameState.DRAW;
        }

        return GameState.ONGOING;
    }

    boolean playerWon(String player, String[] board) {

        return horizontalWin(player, board)
                || verticalWin(player, board)
                || diagonalWin(player, board);
    }

    boolean gameTied(String[] board) {
        String completeBoard = board[0] + board[1] + board[2];

        return !completeBoard.contains(" ");
    }
    boolean horizontalWin(String player, String[] board) {
        String playerRow = player + player + player;

        return playerRow.equals(board[0])
                || playerRow.equals(board[1])
                || playerRow.equals(board[2]);
    }

    boolean verticalWin(String player, String[] board) {
        String playerRow = player + player + player;

        String firstColumn = "" + board[0].charAt(0) + board[1].charAt(0) + board[2].charAt(0);
        String secondColumn = "" + board[0].charAt(1) + board[1].charAt(1) + board[2].charAt(1);
        String thirdColumn = "" + board[0].charAt(2) + board[1].charAt(2) + board[2].charAt(2);

        return playerRow.equals(firstColumn)
                || playerRow.equals(secondColumn)
                || playerRow.equals(thirdColumn);
    }

    boolean diagonalWin(String player, String[] board) {
        String playerRow = player + player + player;

        String firstDiagonal = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String secondDiagonal = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);

        return playerRow.equals(firstDiagonal)
                || playerRow.equals(secondDiagonal);
    }

    void checkBoard(String[] board) {

        String completeBoard = board[0] + board[1] + board[2];

        int countX = 0;
        int countO = 0;

        for (char c : completeBoard.toCharArray()) {
            if (c == 'X') {
                countX ++;
            } else if (c == 'O') {
                countO++;
            }
        }

        if (countO > countX) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        }

        if (countX - countO > 1) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }

        if (playerWon("X", board) && playerWon("O", board)) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }
    }
}

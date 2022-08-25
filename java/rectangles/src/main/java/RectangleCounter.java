public class RectangleCounter {

    private String[] grid;
    private final char CORNER = '+';
    private final char VERTICAL_SIDE = '|';
    public int countRectangles(String[] grid) {

        this.grid = grid.clone();

        if (this.grid.length == 0) {
            return 0;
        }

        int counter = 0;
        for (int i = 0; i < this.grid.length; i++) {
            String row = this.grid[i];
            for (int leftCorner = 0; leftCorner < row.length(); leftCorner++) {
               if (row.charAt(leftCorner) == CORNER) {
                   for (int rightCorner = leftCorner + 1; rightCorner < row.length(); rightCorner++) {
                       if (row.charAt(rightCorner) == CORNER) {
                           counter += this.matchSquare(i, leftCorner, rightCorner);
                       }
                   }
               }
            }
        }

        return counter;
    }

    private int matchSquare(int upperRow, int leftCorner, int rightCorner) {
        int squareCounter = 0;

        for (int i = upperRow + 1; i < this.grid.length; i++) {
            String row = this.grid[i];
            if(row.charAt(leftCorner) == CORNER && row.charAt(rightCorner) == CORNER) {
                squareCounter++;
            } else if ((row.charAt(rightCorner) != CORNER
                    && row.charAt(rightCorner) != VERTICAL_SIDE)
                    || (row.charAt(leftCorner) != CORNER
                    && row.charAt(leftCorner) != VERTICAL_SIDE)) {
                return squareCounter;
            }
        }

        return squareCounter;
    }
}
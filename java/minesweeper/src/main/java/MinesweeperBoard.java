import java.awt.Point;
import java.util.Arrays;
import java.util.List;

class MinesweeperBoard {

    private int rows;
    private int cols;
    private String[][] grid;

    MinesweeperBoard(List<String> boardRows) {
        this.rows = boardRows.size();
        this.cols = rows > 0 ? boardRows.get(0).length() : 0;

        this.grid = boardRows.stream()
                    .map(row -> row.split("")).toList()
                    .toArray(new String[0][0]);
    }

    List<String> withNumbers() {
        for (int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.cols; c++) {
                if (this.grid[r][c].equals(" ")) {
                    long counter = this.getNeighbors(r, c).stream()
                        .filter(point -> grid[(int)point.getX()][(int)point.getY()].equals("*"))
                        .count();
                    this.grid[r][c] = counter > 0 ? String.valueOf(counter) : " ";
                }
            }
        }

        return Arrays.asList(this.grid).stream()
                        .map(row -> String.join("", row))
                        .toList();
    }

    private List<Point> getNeighbors(int r, int c) {
        return Arrays.asList(
                    new Point(r - 1, c - 1),
                    new Point(r - 1, c),
                    new Point(r - 1, c + 1),
                    new Point(r, c - 1),
                    new Point(r, c + 1),
                    new Point(r + 1, c - 1),
                    new Point(r + 1, c),
                    new Point(r + 1, c + 1))
                        .stream()
                        .filter(point -> point.getX() >= 0 && point.getX() < rows
                                    && point.getY() >= 0 && point.getY() < cols)
                        .toList();
    }

}

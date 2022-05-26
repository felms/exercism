import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinesweeperBoard {

    private final String MINE = "*";
    private int rows;
    private int columns;

    private List<List<String>> board;

    public MinesweeperBoard(List<String> inputBoard) {
        if (inputBoard.isEmpty()) {
            this.board = new ArrayList<>();
        }

        this.rows = inputBoard.size();
        this.columns = rows > 0 ? inputBoard.get(0).length() : 0;

        this.board = new ArrayList<>();

        inputBoard.forEach(row -> {
            this.board.add(Arrays.asList(row.split("")));
        });
    }

    public List<String> withNumbers() {

        if(this.board.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> numberedBoard = new ArrayList<>();        

        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            List<String> r = this.board.get(i);
            for (int j = 0; j < columns; j++) {
                if (r.get(j).equals(MINE)) {
                    sb.append(MINE);
                } else {
                    int sum = 0;
                    if (j == 0 && j + 1 < columns && r.get(j + 1).equals(MINE)) {
                        sum++;                        
                    }

                    if (j > 0 && r.get(j - 1).equals(MINE)) {
                        sum++;
                    }

                    if (j > 0 && j < columns - 1 && r.get(j + 1).equals(MINE)) {
                        sum++;
                    }

                    if (i + 1 < rows) {
                        List<String> r1 = this.board.get(i + 1);
                        if (r1.get(j).equals(MINE)) {
                            sum++;
                        }

                        if (j < columns - 1 && r1.get(j + 1).equals(MINE)) {
                            sum++;
                        }

                        if (j > 0 && r1.get(j - 1).equals(MINE)) {
                            sum++;
                        }

                    }

                    if (i > 0) {
                        List<String> r0 = this.board.get(i - 1);
                        if (r0.get(j).equals(MINE)) {
                            sum++;
                        }

                        if (j < columns - 1 && r0.get(j + 1).equals(MINE)) {
                            sum++;
                        }

                        if (j > 0 && r0.get(j - 1).equals(MINE)) {
                            sum++;
                        }
                    }

                    sb.append(sum == 0 ? " " : String.valueOf(sum));
                }
                
            }

            numberedBoard.add(sb.toString());
        }

        return numberedBoard;
    }
}

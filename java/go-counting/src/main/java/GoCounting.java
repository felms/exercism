import java.awt.Point;

import java.util.*;

public class GoCounting {

    private final char EMPTY = ' ';
    private final char BLACK = 'B';
    private final char WHITE = 'W';

    private final char[][] board;
    private final int rows;
    private final int columns;

    public GoCounting(String board) {

        String[] r = board.split("\n");

        this.rows = r.length;
        this.columns = r[0].length();
        this.board = new char[this.rows][this.columns];

        for (int i = 0; i < this.rows; i++) {
            this.board[i] = r[i].toCharArray();
        }

    }

    public Player getTerritoryOwner(int x, int y) {

        Set<Point> territory = this.getTerritory(x, y);
        List<Character> slots = new ArrayList<>();
        List<Point> allNeighbors = new ArrayList<>();

        for (Point point : territory) {
            allNeighbors.addAll(this.getNeighbors(point));
        }
        territory.addAll(allNeighbors);

        for (Point point : territory) {
            char slot = this.board[point.y][point.x];
            slots.add(slot);
        }

        if (slots.contains(BLACK) && (slots.contains(EMPTY)) && (!(slots.contains(WHITE)))) {
            return Player.BLACK;
        } else if (slots.contains(WHITE) && (slots.contains(EMPTY) && (!(slots.contains(BLACK))))) {
            return Player.WHITE;
        } else if (slots.contains(WHITE) && (slots.contains(EMPTY) && (slots.contains(BLACK)))) {
            return Player.NONE;
        } else if ((slots.contains(WHITE) && slots.contains(BLACK))) {
            return Player.NONE;
        }

        return Player.NONE;

   }

    public Set<Point> getTerritory(int x, int y) {

        if ((x < 0 || y < 0)
            || (x >= this.columns || y >= this.rows)){
            throw new IllegalArgumentException("Invalid coordinate");
        }

        Set<Point> territory = new HashSet<>();
        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(x, y));

        while (!points.isEmpty()) {

            Point p = points.poll();

            if (this.board[p.y][p.x] == EMPTY) {
                if (territory.add(p)) {
                    points.addAll(this.getNeighbors(p));
                }
            }
        }

        return territory;
    }

    public Map<Player, Set<Point>> getTerritories() {
        Map<Player, Set<Point>> territories = new HashMap<>();
        territories.put(Player.BLACK, new HashSet<>());
        territories.put(Player.WHITE, new HashSet<>());
        territories.put(Player.NONE, new HashSet<>());

        Set<Set<Point>> setOfTerritories = new HashSet<>();

        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                setOfTerritories.add(this.getTerritory(i, j));
            }
        }

        for (Set<Point> territory : setOfTerritories) {
            territory.forEach(point -> {
                Player player = this.getTerritoryOwner(point.x, point.y);
                territories.get(player).addAll(territory.stream().toList());
            });
        }

        return territories;
    }

    private List<Point> getNeighbors(Point p) {

        List<Point> neighbors = new ArrayList<>();

        if (p.x > 0) {
            neighbors.add(new Point(p.x - 1, p.y));
        }

        if (p.x < this.columns - 1) {
            neighbors.add(new Point(p.x + 1, p.y));
        }

        if (p.y > 0) {
            neighbors.add(new Point(p.x, p.y - 1));
        }

        if (p.y < this.rows - 1) {
            neighbors.add(new Point(p.x, p.y + 1));
        }

        return neighbors;
    }
}
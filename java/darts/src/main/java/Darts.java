class Darts {

    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double distance = distanceBetweenPoints(0, 0, this.x, this.y);
        return distance <= 1 ? 10 
                : distance <= 5 ? 5
                : distance <= 10 ? 1
                : 0;
    }

    private double distanceBetweenPoints(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

}

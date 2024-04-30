class Darts {
    int score(double xOfDart, double yOfDart) {
        double distance = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));

        return distance <= 1 ? 10 : distance <= 5 ? 5 : distance <= 10 ? 1 : 0;
    }
}

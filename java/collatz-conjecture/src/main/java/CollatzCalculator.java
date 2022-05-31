class CollatzCalculator {

    int computeStepCount(int start) {

        if (start < 1) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }

        int steps = 0;
        int number = start;
        
        while (number > 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number *= 3;
                number++;
            }

            steps++;

        }

        return steps;
    }

}

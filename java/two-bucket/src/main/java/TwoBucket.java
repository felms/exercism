public class TwoBucket {

    private final Bucket bucketOne;
    private final Bucket bucketTwo;
    private Bucket finalBucket;
    private Bucket otherBucket;

    private final int goal;
    private final String startingBucket;
    private int totalMoves;

    public TwoBucket(int bucketOne, int bucketTwo, int goal, String startingBucket) {
        this.bucketOne = new Bucket("one", bucketOne);
        this.bucketTwo = new Bucket("two", bucketTwo);
        this.goal = goal;
        this.startingBucket = startingBucket;
        this.totalMoves = 0;

        this.solve();
    }

    public int getTotalMoves() {
        return this.totalMoves;
    }

    public String getFinalBucket() {
        return this.finalBucket.getName();
    }

    public int getOtherBucket() {
        return this.otherBucket.getFilled();
    }

    private void solve() {

        this.finalBucket = this.startingBucket.equals("one") ? this.bucketOne : this.bucketTwo;
        this.otherBucket = this.startingBucket.equals("one") ? this.bucketTwo : this.bucketOne;

        while (this.finalBucket.getFilled() != this.goal
                && this.otherBucket.getFilled() != this.goal) {

            if (this.finalBucket.getFilled() == 0) {
                this.finalBucket.fill();

            } else if (this.otherBucket.getCapacity() == this.goal) {

                this.otherBucket.setFilled(this.goal);

            } else if (!this.otherBucket.isFull()) {
                int quantity = this.finalBucket.getFilled();

                if (this.otherBucket.getCurrentCapacity() >= quantity) {
                    this.otherBucket.setFilled(this.otherBucket.getFilled() + quantity);
                    quantity = 0;
                } else {
                    quantity = quantity - this.otherBucket.getCurrentCapacity();
                    this.otherBucket.fill();
                }

                this.finalBucket.setFilled(quantity);

            } else if (this.otherBucket.isFull()) {
                this.otherBucket.empty();
            }

            this.totalMoves++;
        }

        if (this.otherBucket.getFilled() == this.goal) {
            Bucket aux = this.finalBucket;
            this.finalBucket = this.otherBucket;
            this.otherBucket = aux;
        }
    }
}
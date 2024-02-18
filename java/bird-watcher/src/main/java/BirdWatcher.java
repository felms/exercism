
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int today;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.today = birdsPerDay.length - 1;
    }

    public int[] getLastWeek() {
        return this.birdsPerDay;
    }

    public int getToday() {
        return this.birdsPerDay[this.today];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.today]++;
    }

    public boolean hasDayWithoutBirds() {
        int boringDays = 0;

        for (int day : this.birdsPerDay) {
            if (day == 0) {
                boringDays++;
            }
        }

        return boringDays > 0;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;

        for (int i = 0; i < Math.min(this.today + 1, numberOfDays); i++) {
            count += this.birdsPerDay[i];
        }

        return count;
    }

    public int getBusyDays() {
        int busyDays = 0;

        for (int day : this.birdsPerDay) {
            if (day >= 5) {
                busyDays++;
            }
        }

        return busyDays;
    }
}

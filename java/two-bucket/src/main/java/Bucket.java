public class Bucket {

    private final String name;
    private final int capacity;
    private int filled;

    public Bucket(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.filled = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getFilled() {
        return this.filled;
    }

    public void setFilled(int litters) {
        this.filled = litters;
    }

    public boolean isFull() {
        return this.capacity == this.filled;
    }

    public int getCurrentCapacity() {
        return this.capacity - this.filled;
    }

    public void fill() {
        this.filled = this.capacity;
    }

    public void empty() {
        this.filled = 0;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", filled=" + filled +
                '}';
    }
}

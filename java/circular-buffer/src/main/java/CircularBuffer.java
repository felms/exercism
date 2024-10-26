import java.util.LinkedList;

class CircularBuffer<T> {

    private LinkedList<T> buffer;
    private int capacity;

    CircularBuffer(final int size) {
        this.buffer = new LinkedList<>();
        this.capacity = size;
    }

    T read() throws BufferIOException {
        if (this.buffer.isEmpty()) {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        return this.buffer.poll();
    }

    void write(T data) throws BufferIOException {
        if (this.buffer.size() == this.capacity) {
            throw new BufferIOException("Tried to write to full buffer");
        }

        this.buffer.add(data);
    }

    void overwrite(T data) {
        if (this.buffer.size() == this.capacity) {
            this.buffer.poll();
        }

        this.buffer.add(data);
    }

    void clear() {
        this.buffer.clear();
    }

}
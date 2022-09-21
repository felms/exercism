import java.util.ArrayDeque;
import java.util.Queue;

public class CircularBuffer<T> {

    private final int bufferSize;
    private final Queue<T> buffer;


    public CircularBuffer(int bufferSize) {
       this.bufferSize = bufferSize;
       this.buffer = new ArrayDeque<>();
    }

    public T read() throws BufferIOException {

        if (this.buffer.isEmpty()) {
            throw new BufferIOException("Tried to read from empty buffer");
        }


        return this.buffer.poll();
    }

    public void write(T item) throws BufferIOException {

        if (this.buffer.size() == this.bufferSize) {
            throw new BufferIOException("Tried to write to full buffer");
        }

        this.buffer.offer(item);
    }

    public void overwrite(T item) {
        if (this.buffer.size() == bufferSize) {
            this.buffer.poll();
        }

        this.buffer.offer(item);
    }

    public void clear() {
        this.buffer.clear();
    }

}
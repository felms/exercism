class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {

    int capacity
    def buffer

    CircularBuffer(int capacity) {
        this.capacity = capacity
        this.buffer = []
    }

    def clear() {
        this.buffer = []
    }

    def read() {
        if (this.buffer.size() == 0) {
            throw new EmptyBufferException()
        }

        this.buffer.remove(0)
    }

    def write(int item) {
        if (this.buffer.size() == this.capacity) {
            throw new FullBufferException()
        }

        this.buffer << item
    }

    def overwrite(int item) {
        if (this.buffer.size() == this.capacity) {
            this.buffer.remove(0)
        }

        this.buffer << item
    }
}

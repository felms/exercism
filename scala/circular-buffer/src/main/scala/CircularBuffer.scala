import scala.collection.mutable.ArrayBuffer

class EmptyBufferException() extends Exception {}

class FullBufferException() extends Exception {}

class CircularBuffer(capacity: Int, buffer: ArrayBuffer[Int]) {

  def this(capacity: Int) = this(capacity, ArrayBuffer())

  def write(value: Int) = {
    if (this.buffer.size == this.capacity) {
      throw new FullBufferException()
    }

    this.buffer.append(value)
  }

  def read(): Int = {
    if (this.buffer.size == 0) {
      throw new EmptyBufferException()
    }

    this.buffer.remove(0)
  }

  def overwrite(value: Int) = {
    if (this.buffer.size == this.capacity) {
      this.buffer.remove(0)
    }

    this.buffer.append(value)
  }

  def clear() = {
    this.buffer.clear()
  }
}

class Node:
    def __init__(self, value, succeeding=None, previous=None):
        self.value = value
        self.succeeding = succeeding
        self.previous = previous


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __len__(self):
        return self.size

    def push(self, value):
        new_node = Node(value)

        if self.size == 0:
            self.head = new_node
        else:
            new_node.previous = self.tail
            self.tail.succeeding = new_node

        self.tail = new_node
        self.size += 1

    def pop(self):

        if self.size == 0:
            raise IndexError("The list is empty.")

        value = self.tail.value

        if self.size == 1:
            self.head = None
            self.tail = None
        else:
            self.tail = self.tail.previous
            self.tail.succeeding = None

        self.size -= 1
        return value

    def shift(self):

        if self.size == 0:
            raise IndexError("The list is empty.")

        value = self.head.value

        if self.size == 1:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.succeeding
            self.head.previous = None

        self.size -= 1
        return value

    def unshift(self, value):
        new_node = Node(value)

        if self.size == 0:
            self.tail = new_node
        else:
            new_node.succeeding = self.head
            self.head.previous = new_node

        self.head = new_node
        self.size += 1

    def delete(self, item):

        if self.size == 0:
            raise ValueError("Value not found")

        if self.head.value == item:
            next = self.head.succeeding
            if next:
                next.previous = None
            self.head = next
            self.size -= 1
            return

        previous = self.head
        pointer = self.head.succeeding

        while pointer:
            if pointer.value == item:
                previous.succeeding = pointer.succeeding
                if pointer.succeeding:
                    pointer.succeeding.previous = previous
                else:
                    self.tail = previous
                self.size -= 1
                return

            previous = pointer
            pointer = pointer.succeeding

        raise ValueError("Value not found")

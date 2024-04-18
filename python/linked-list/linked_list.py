class Node:
    def __init__(self, value, succeeding=None, previous=None):
        self.value = value
        self.succeding = succeeding
        self.previous = previous


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0


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


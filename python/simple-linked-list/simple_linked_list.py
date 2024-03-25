class Node:
    def __init__(self, value):
        self.data = value
        self.next_node = None

    def value(self):
        return self.data

    def next(self):
        return self.next_node

class LinkedList:
    def __init__(self, values=[]):
        self.count = 0
        self.head_node = None
        self.pointer = None
       
        for value in values:
            self.push(value)

    def __len__(self):
        return self.count

    def __iter__(self):
        return self

    def __next__(self):
        if self.pointer is None:
            raise StopIteration

        node = self.pointer
        self.pointer = self.pointer.next()
        return node.value()

    def head(self):
        if self.count == 0:
            raise EmptyListException("The list is empty.")

        return self.head_node

    def push(self, value):
        node = Node(value)
        node.next_node = self.head_node
        self.head_node = node
        self.pointer = node
        self.count += 1

    def pop(self):
        if self.count == 0:
            raise EmptyListException("The list is empty.")

        data = self.head_node.value()
        self.head_node = self.head_node.next()
        self.pointer = self.pointer.next()
        self.count -= 1
        return data

    def reversed(self):
        return LinkedList(self)

class EmptyListException(Exception):
    def __init__(self, message):
        super().__init__(message)

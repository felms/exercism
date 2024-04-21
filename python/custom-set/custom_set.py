class CustomSet:
    def __init__(self, elements=[]):
        self.elements = {}
        for element in elements:
            self.elements[element] = 1

    def isempty(self):
        return len(self.elements) == 0

    def __contains__(self, element):
        return self.elements.get(element) == 1

    def issubset(self, other):
        return all(other.__contains__(e) for e in self.elements)

    def isdisjoint(self, other):
        return all(not other.__contains__(e) for e in self.elements)

    def __eq__(self, other):
        return self.issubset(other) and other.issubset(self)

    def add(self, element):
        self.elements[element] = 1

    def intersection(self, other):
        elmnts = [e for e in self.elements if other.__contains__(e)]
        return CustomSet(elmnts)

    def __sub__(self, other):
        elmnts = [e for e in self.elements if not other.__contains__(e)]
        return CustomSet(elmnts)

    def __add__(self, other):
        elmnts = list(self.elements)
        elmnts.extend(list(other.elements))
        return CustomSet(elmnts)

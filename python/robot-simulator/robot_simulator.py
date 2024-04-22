# Globals for the directions
# Change the values as you see fit
NORTH = 0
EAST = 1
SOUTH = 2
WEST = 3

class Robot:
    def __init__(self, direction=NORTH, x_pos=0, y_pos=0):
        self.direction = direction
        self.coordinates = (x_pos, y_pos)

    def move(self, moves):
        for m in moves:
            self.exec_move(m)

    def exec_move(self, direction):
        match direction:
            case "R":
                self.direction = (self.direction + 1) % 4

            case "L":
                self.direction = (self.direction + 3) % 4

            case "A":
                self.advance()

    def advance(self):
        d = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        x, y = self.coordinates
        dx, dy = d[self.direction]
        self.coordinates = (x + dx, y + dy)

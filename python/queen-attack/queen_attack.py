class Queen:
    def __init__(self, row, column):

        # if the row parameter is negative
        if row < 0:
            raise ValueError("row not positive")

        # if the row parameter is not on the defined board
        if row > 7:
            raise ValueError("row not on board")

        # if the column parameter is negative
        if column < 0:
            raise ValueError("column not positive")

        # if the column parameter is not on the defined board
        if column > 7:
            raise ValueError("column not on board")

        self.row = row
        self.column = column

    def can_attack(self, another_queen):

        # if both the queens are on the same location
        if self.row == another_queen.row and self.column == another_queen.column:
            raise ValueError("Invalid queen position: both queens in the same square")

        if self.row == another_queen.row or self.column == another_queen.column:
            return True

        if self.row - self.column == another_queen.row - another_queen.column:
            return True

        if self.row + self.column == another_queen.row + another_queen.column:
            return True

        return False

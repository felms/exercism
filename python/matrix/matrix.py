class Matrix:
    def __init__(self, matrix_string):
        lines = matrix_string.split("\n")
        self.rows = [self.process_row(row) for row in lines]
        self.columns = [list(column) for column in zip(*self.rows)]

    def row(self, index):
        return self.rows[index - 1]

    def column(self, index):
        return self.columns[index - 1]

    def process_row(self, row):
        return [int(n) for n in row.split()]

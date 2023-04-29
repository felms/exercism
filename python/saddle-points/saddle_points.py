def saddle_points(matrix):
    if not matrix:
        return []

    sizes = set()

    for i in range(len(matrix)):
        sizes.add(len(matrix[i]))

    if len(sizes) > 1:
        raise ValueError("irregular matrix")

    points = []

    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if is_saddle_point(i, j, matrix):
                points.append({"row": i + 1, "column": j + 1})

    return points


def is_saddle_point(row, column, matrix):
    value = matrix[row][column]

    for j in range(len(matrix[row])):
        if value < matrix[row][j]:
            return False

    for i in range(len(matrix)):
        if value > matrix[i][column]:
            return False

    return True

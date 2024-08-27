def rows(row_count):

    if row_count < 0:
        raise ValueError("number of rows is negative")

    if row_count == 0:
        return []

    if row_count == 1:
        return [[1]]

    all_rows = rows(row_count - 1)
    all_rows.append(generate_row(all_rows[-1]))

    return all_rows


def generate_row(previous_row):

    row0 = list(previous_row)
    row0.append(0)

    row1 = [0]
    row1.extend(previous_row)

    return [a + b for (a, b) in (zip(row0, row1))]

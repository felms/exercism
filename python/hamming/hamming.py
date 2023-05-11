def distance(strand_a, strand_b):

    if len(strand_a) != len(strand_b):
        raise ValueError("Strands must be of equal length.")

    diff_list = list(filter(lambda item: item[0] != item[1], zip(strand_a, strand_b)))

    return len(diff_list)

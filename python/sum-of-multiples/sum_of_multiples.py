def sum_of_multiples(limit, multiples):

    ans = set()

    for multiple in multiples:
        if multiple != 0:
            ans = ans.union([number for number in range(multiple, limit, multiple)])

    return sum(ans)

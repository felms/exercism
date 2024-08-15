def maximum_value(maximum_weight, items):
    return max_val(maximum_weight, items, 0)


def max_val(maximum_weight, items, current_value):

    if maximum_weight == 0 or len(items) == 0:
        return current_value

    current_item = items[0]

    if current_item["weight"] <= maximum_weight:
        return max(
                max_val(maximum_weight - current_item["weight"], items[1:], current_value + current_item["value"]),
                max_val(maximum_weight, items[1:], current_value)
        )
    else:
        return max_val(maximum_weight, items[1:], current_value)

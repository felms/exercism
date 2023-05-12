def flatten(iterable):
    if not iterable:
        return []

    head, *tail = iterable

    if head != 0 and not head:
        return flatten(tail)

    if isinstance(head, list):
        return flatten(head) + flatten(tail)

    return [head] + flatten(tail)

def append(list1, list2):
    if not list1:
        return list2

    head, *tail = list1

    return [head] + append(tail, list2)


def concat(lists):
    if not lists:
        return []

    head, *tail = lists

    return append(head, concat(tail))


def filter(function, list):

    if not list:
        return []

    head, *tail = list

    if function(head):
        return [head] + filter(function, tail)

    return filter(function, tail)


def length(list):

    if not list:
        return 0

    _, *tail = list

    return 1 + length(tail)


def map(function, list):

    if not list:
        return []

    head, *tail = list

    return [function(head)] + map(function, tail)


def foldl(function, list, initial):

    if not list:
        return initial

    head, *tail = list

    return foldl(function, tail, function(initial, head))


def foldr(function, list, initial):

    if not list:
        return initial

    head, *tail = list

    return function(foldr(function, tail, initial), head)


def reverse(list):

    if not list:
        return []

    head, *tail = list

    return reverse(tail) + [head]

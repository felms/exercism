func append<T>(_ listA: [T], _ listB: [T]) -> [T] {
    if (listA.isEmpty) {
        return listB;
    }

    var head:T!;
    head = listA.first;
    return [head] + append(Array(listA.dropFirst()), listB);
}

func concat<T>(_ lists: [T]...) -> [T] {

    return foldLeft(lists, accumulated: [], combine: append);

}

func filter<T>(_ list: [T], _ predicate: (T) -> Bool) -> [T] {

    if (list.isEmpty) {
        return [];
    }

    var head:T!;
    head = list.first;

    if (predicate(head)) {
        return [head] + filter(Array(list.dropFirst()), predicate);
    }

    return filter(Array(list.dropFirst()), predicate);
}

func length<T>(_ list: [T]) -> Int {
    if (list.isEmpty) {
        return 0;
    }

    return 1 + length(Array(list.dropFirst()));
}

func map<T>(_ list: [T], _ function: (T) -> T) -> [T] {

    if (list.isEmpty) {
        return [];
    }

    var head:T!;
    head = list.first;

    return [function(head)] + map(Array(list.dropFirst()), function);

    
}

func foldLeft<T>(_ list: [T], accumulated initialValue: T, combine operation: ((T, T) -> T)) -> T {

    if (list.isEmpty) {
        return initialValue;
    }

    var head:T!;
    head = list.first;

    return foldLeft(Array(list.dropFirst()), accumulated: operation(initialValue, head), combine: operation);
}

func foldRight<T>(_ list: [T], accumulated initialValue: T, combine operation: ((T, T) -> T)) -> T {

    if (list.isEmpty) {
        return initialValue;
    }

    var tail:T!;
    tail = list.last;

    return foldRight(Array(list.dropLast()), accumulated: operation(tail, initialValue), combine: operation);

}

func reverse<T>(_ list: [T]) -> [T] {

    if (list.isEmpty) {
        return [];
    }

    var head:T!;
    head = list.first;

    return reverse(Array(list.dropFirst())) + [head];
}


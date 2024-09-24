Class {
	#name : #Minesweeper,
	#superclass : #Object,
	#category : #'Exercise@Minesweeper'
}

Minesweeper >> annotateMinefield: theMinefield [

    res := Array new: (theMinefield size).

    1 to: (theMinefield size) do: [ :r |
        row := (theMinefield at: r).
        newRow := Array new: (row size).
        1 to: (row size) do: [ :c |
            ((row at: c) = (Character space))
                ifTrue: [
                    n := self countMines: theMinefield row:r col:c.
                    (n = 0)
                    ifTrue: [newRow at: c put: (Character space)]
                    ifFalse: [newRow at: c put: (n asString)].
                ]
                ifFalse: [newRow at: c put: (row at: c)].
        ].
        res at: r put: newRow.
    ].

    ^res
]

Minesweeper >> countMines: theMinefield row: r col: c [

    neighbors := self getNeighbors: theMinefield row:r col:c.
    
    mines := neighbors select: [:pos | ((theMinefield at: (pos at: 1)) at: (pos at: 2)) = $* ].

    ^mines size
]

Minesweeper >> getNeighbors: theMinefield row: r col: c [

    rows := theMinefield size.
    cols := (theMinefield at: 1) size.

    positions := {{(r - 1). c}. {(r + 1). c}. {r. (c - 1)}. {r. (c + 1)}. {(r - 1). (c - 1)}. {(r - 1). (c + 1)}. {(r + 1). (c - 1)}. {(r + 1). (c + 1)}}.
    result := positions select: [ :pos | (((pos at: 1) > 0) and: ((pos at: 1) <= rows)) and: (((pos at: 2) > 0) and: ((pos at: 2) <= cols))].

    ^result
]

Class {
	#name : #Minesweeper,
	#superclass : #Object,
	#category : #'Exercise@Minesweeper'
}

Minesweeper >> annotateMinefield: theMinefield [

    res := theMinefield deepCopy.

    res withIndexDo: [ :row :r |
        row withIndexDo: [ :item :c |
            item isSpaceSeparator ifTrue: [
                n := self countMines: theMinefield row:r col:c.
                n > 0 ifTrue: [row at: c put: n asCharacterDigit]. 
            ].
        ].
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

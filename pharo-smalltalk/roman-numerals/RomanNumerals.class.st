Class {
	#name : #RomanNumerals,
	#superclass : #Object,
    #category : #'Exercism@RomanNumerals'
}

{ #category : #conversion }
RomanNumerals >> romanNumber: theNumber [

    units := #('' 'I' 'II' 'III' 'IV' 'V' 'VI' 'VII' 'VIII' 'IX').
    tens := #('' 'X' 'XX' 'XXX' 'XL' 'L' 'LX' 'LXX' 'LXXX' 'XC').
    hundreds := #('' 'C' 'CC' 'CCC' 'CD' 'D' 'DC' 'DCC' 'DCCC' 'CM').
    thousands := #('' 'M' 'MM' 'MMM').

    th := theNumber // 1000 + 1.
    hh := (theNumber \\ 1000) // 100 + 1.
    tt := (theNumber \\ 100) // 10 + 1.
    uu := theNumber \\ 10 + 1.

    result := ''.
    result := result, (thousands at: th), (hundreds at: hh), 
                                        (tens at: tt), (units at: uu).
    
	^ result
]

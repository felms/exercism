module LuciansLusciousLasagna

let expectedMinutesInOven = 40

let remainingMinutesInOven actualMinutes = expectedMinutesInOven - actualMinutes 

let preparationTimeInMinutes layers = layers * 2

let elapsedTimeInMinutes layers minutesInTheOven = 
    (preparationTimeInMinutes layers) + minutesInTheOven

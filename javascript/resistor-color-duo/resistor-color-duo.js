export const COLORS = [
        'black', 'brown', 'red', 'orange', 'yellow',
        'green', 'blue', 'violet', 'grey', 'white'];

export const decodedValue = ([firstColor, secondColor, ...rest]) => 
                        COLORS.indexOf(firstColor) * 10 + COLORS.indexOf(secondColor);

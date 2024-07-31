export const transform = (input) => {

    return Object.entries(input)
        .reduce((acc, [score, letters]) => ({ 
            ...acc, 
            ...letters.reduce((res, letter) => 
                ({...res, [letter.toLowerCase()]: Number(score)}), {})
        }), {});

};

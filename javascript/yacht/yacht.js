export const score = (dice, category) => {
    
    let count = [0, 0, 0, 0, 0, 0, 0];

    for (let d of dice) {
        count[d]++;
    }

    let result = 0;

    switch(category) {
         case 'ones':
            result += 1 * count[1];
            break;
         case 'twos':
            result += 2 * count[2];
            break;
         case 'threes':
            result += 3 * count[3];
            break;
         case 'fours':
            result += 4 * count[4];
            break;
         case 'fives':
            result += 5 * count[5];
            break;
         case 'sixes':
            result += 6 * count[6];
            break;
//         case 'ones':
//            result += 1 * count[1];
//            break;
//         case 'ones':
//            result += 1 * count[1];
//            break;

    }

    return result;
};



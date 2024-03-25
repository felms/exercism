export const isPaired = ([currentChar, ...remainingChars], stack = []) => {

    if (!currentChar) {
        return stack.length === 0;
    }

    if (['(', '[', '{'].includes(currentChar)) {
        return isPaired(remainingChars, [currentChar, ...stack]);
    }

    if ([')', ']', '}'].includes(currentChar)) {
        let [head, ...tail] = stack;
        if ((currentChar === ')' && head === '(')
            || (currentChar === ']' && head === '[')
            || (currentChar === '}' && head === '{')) {
            return isPaired(remainingChars, tail);
        }

        return false;
    }

    return isPaired(remainingChars, stack);
};

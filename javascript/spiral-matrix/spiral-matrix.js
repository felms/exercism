export const spiralMatrix = (size) => {

    let matrix = [...Array(size)].map(() => {
        return [...Array(size)].map(() => -1);
    });

    let RIGHT = 0;
    let DOWN = 1;
    let LEFT = 2;
    let UP = 3;

    let r = 0;
    let c = 0;
    let direction = RIGHT;

    let currentValue = 1;
    let lastValue = size * size;

    while (currentValue <= lastValue) {
        matrix[r][c] = currentValue;
        currentValue++;

        if (direction == RIGHT) {
            if (c == size - 1 || matrix[r][c + 1] != -1) {
                direction = DOWN;
                r++
            } else {
                c++;
            }
        } else if (direction == DOWN) {
            if (r == size - 1 || matrix[r + 1][c] != -1) {
                direction = LEFT;
                c--;
            } else {
                r++;
            }
        } else if (direction == LEFT) {
            if (c == 0 || matrix[r][c - 1] != -1) {
                direction = UP;
                r--;
            } else {
                c--;
            }
        } else { //direction == UP
            if (r == 0 || matrix[r - 1][c] != -1) {
                direction = RIGHT;
                c++;
            } else {
                r--;
            }
        }
    }

    return matrix;
};

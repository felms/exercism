package spiralmatrix

type Direction uint8

const (
    LEFT    = 0
    RIGHT   = 1
    UP      = 2
    DOWN    = 3
)


func SpiralMatrix(size int) [][]int {
    matrix := make([][]int, size)
    for i := 0; i < size; i++ {
        matrix[i] = make([]int, size)
        for j := 0; j < size; j++ {
            matrix[i][j] = -1
        }
    }

    r := 0
    c := 0

    direction := RIGHT

    currentValue := 1
    lastValue := size * size

    for currentValue <= lastValue {
        matrix[r][c] = currentValue
        currentValue++

        if direction == RIGHT {
            if c == size - 1 || matrix[r][c + 1] != -1 {
                direction = DOWN
                r++
            } else {
                c++
            }
        } else if direction == DOWN {
            if r == size - 1 || matrix[r + 1][c] != -1 {
                direction = LEFT
                c--
            } else {
                r++
            }
        } else if direction == LEFT {
            if c == 0 || matrix[r][c - 1] != -1 {
                direction = UP
                r--
            } else {
                c--
            }
        } else { //direction == UP
            if r == 0 || matrix[r - 1][c] != -1 {
                direction = RIGHT
                c++
            } else {
                r--
            }
        }
    }

    return matrix
}

#include "triangle.h"

bool is_equilateral(triangle_t sides) {
    return is_valid_triangle(sides)
            && sides.a == sides.b && sides.b == sides.c;
}

bool is_isosceles(triangle_t sides) {
    return is_valid_triangle(sides)
                && (sides.a == sides.b 
                    || sides.a == sides.c 
                    || sides.b == sides.c);

}

bool is_scalene(triangle_t sides) {
    return is_valid_triangle(sides) 
                && sides.a != sides.b && sides.a != sides.c && sides.b != sides.c;
}


bool is_valid_triangle(triangle_t sides) {
    
    if (sides.a == 0 || sides.b == 0 || sides.c == 0) {
        return false;
    }

    return sides.a + sides.b >= sides.c
            && sides.b + sides.c >= sides.a 
            && sides.a + sides.c >= sides.b;
}

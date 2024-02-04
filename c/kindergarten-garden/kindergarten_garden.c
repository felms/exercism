#include "kindergarten_garden.h"

#include <string.h>

plant_t char_to_plant(char plant_label);
size_t student_to_index(const char *student);


plants_t plants(const char *diagram, const char *student) {

    size_t student_index = student_to_index(student) * 2;
    size_t diagram_length = strlen(diagram) / 2 + 1;

    return (plants_t){
        {
            char_to_plant(diagram[student_index]),
            char_to_plant(diagram[student_index + 1]),
            char_to_plant(diagram[student_index + diagram_length]),
            char_to_plant(diagram[student_index + diagram_length + 1])
        }
    };

}

size_t student_to_index(const char *student) {
    
    char* students[] = { 
        "Alice", "Bob", "Charlie", "David", 
        "Eve", "Fred", "Ginny", "Harriet", 
        "Ileana", "Joseph", "Kincaid", "Larry"
    };

    for (size_t i = 0; i < 12; i++) {
        if (strcmp(students[i], student) == 0) {
            return i;
        }
    }

    return -1;
}

plant_t char_to_plant(char plant_label) { 

    switch(plant_label) { 
        case 'C': 
            return CLOVER; 
        case 'G': 
            return GRASS; 
        case 'R': 
            return RADISHES; 
        case 'V': 
            return VIOLETS; 
    }

    return -1;
}

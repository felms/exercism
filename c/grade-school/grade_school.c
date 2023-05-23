#include "grade_school.h"

bool contains_student(student_t *students, size_t size, char *name);
int cmp_function(const void *student0, const void *student1);

void init_roster(roster_t *roster) {
    roster -> count = 0;

}


bool add_student(roster_t *roster, char *student_name, uint8_t student_grade) {

    student_t *new_student = malloc(sizeof(student_t));
    if (new_student == NULL) {
        return false;
    }

    if (roster -> count > 0 
            && contains_student(roster -> students, roster -> count, student_name)) {
        return false;
    }

    new_student -> grade = student_grade;
    strcpy(new_student -> name, student_name);

    roster -> students[roster -> count] = *new_student;
    roster -> count++;

    qsort(roster -> students, roster -> count, sizeof(student_t), cmp_function);

    return true;
}

roster_t get_grade(roster_t *roster, uint8_t desired_grade) {

    
    roster_t grade;
    init_roster(&grade);

    for (size_t i = 0; i < roster -> count; i++) {
        student_t student = roster -> students[i];
        if (student.grade == desired_grade) {
            add_student(&grade, student.name, desired_grade);
        }
    }

    return grade;
}

bool contains_student(student_t *students, size_t size, char *name) {

    for (size_t i = 0; i < size; i++) {
        if(strcmp(students[i].name, name) == 0) {
            return true;
        }
    }

    return false;
}

int cmp_function(const void *student0, const void *student1) {
    student_t *s0 = (student_t *) student0;
	student_t *s1 = (student_t *) student1;
    
    if (s0 -> grade < s1 -> grade) {
        return -1;
    } else if (s0 -> grade > s1 -> grade) {
        return 1;
    } else {
        return strcmp(s0 -> name, s1 -> name);
    }
}

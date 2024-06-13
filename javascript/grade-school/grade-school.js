export class GradeSchool {

    #grades;

    constructor() {
        this.#grades = {};
    }

    roster() {
        return structuredClone(this.#grades);
    }

    add(student, gradeNumber) {
        if (!this.#grades[gradeNumber]) {
            this.#grades[gradeNumber] = [];
        }

        Object.keys(this.#grades)
            .forEach((grade) => 
                this.#grades[grade] = this.#grades[grade]
                                .filter(stdnt => stdnt !== student)
            );

        this.#grades[gradeNumber].push(student);
        this.#grades[gradeNumber].sort();
    }

    grade(gradeNumber) {
        return this.#grades[gradeNumber] 
            ? [...this.#grades[gradeNumber]] : [];
    }
}

export class GradeSchool {

  constructor() {
    this.schoolRoster = {};
  }

  roster() {
    let r1 = JSON.parse(JSON.stringify(this.schoolRoster));   

    return r1;
  }

  add(name, gradeNumber) {
    let arr = [];

    // Teste se aquela turma já existe 
    // e faz a copia caso exista
    if (this.schoolRoster[gradeNumber]) {
      arr = [...this.schoolRoster[gradeNumber]];
    }

    // Testa se o estudante já está em alguma outra turma e 
    // o retira dela caso esteja
    for (const key in this.schoolRoster) {
      let element = [...this.schoolRoster[key]];
      let i = element.indexOf(name);
      if (i >= 0) {
        element.splice(i, 1);
        this.schoolRoster[key] = element;
      }
    }

    // Adiciona o estudante na turma desejada
    arr.push(name);
    arr.sort();
    this.schoolRoster[gradeNumber] = arr;
  }

  grade(gradeNumber) {
    let arr = [];
    if (this.schoolRoster[gradeNumber]) {
      arr = [...this.schoolRoster[gradeNumber]];
      arr.sort();
    }

    return arr;
  }
}

const DEFAULT_STUDENTS = [
  'Alice',
  'Bob',
  'Charlie',
  'David',
  'Eve',
  'Fred',
  'Ginny',
  'Harriet',
  'Ileana',
  'Joseph',
  'Kincaid',
  'Larry',
];

const PLANT_CODES = {
  G: 'grass',
  V: 'violets',
  R: 'radishes',
  C: 'clover',
};

export class Garden {
  constructor(diagram, students = DEFAULT_STUDENTS) {
	this.plantsDiagram = diagram.split('\n');
	this.students = students.sort();
  }

  plants(student) {
	let plantsList = [];
	
	let pos = this.students.indexOf(student) * 2;
	let code0 = this.plantsDiagram[0].charAt(pos);
	let code1 = this.plantsDiagram[0].charAt(pos + 1);
	let code2 = this.plantsDiagram[1].charAt(pos);
	let code3 = this.plantsDiagram[1].charAt(pos + 1);

	plantsList.push(PLANT_CODES[code0]);
	plantsList.push(PLANT_CODES[code1]);
	plantsList.push(PLANT_CODES[code2]);
	plantsList.push(PLANT_CODES[code3]);

 	return plantsList;
	
  }
}

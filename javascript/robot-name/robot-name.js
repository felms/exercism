export class Robot {

    static ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static usedNames = [];

    constructor() {
       this._name = this.createName();
    }

    get name() {
        return this._name;
    }

    createName () {
        let name;

        do{
            name = this.randomName();
        }while(Robot.usedNames.indexOf(name) >= 0);

        Robot.usedNames.push(name);
        return name;
    }

    reset() {
        this._name = this.createName();
    }

    randomName() {
        let name = "";
        let pos0 = Math.trunc(Math.random() * 26);
        let pos1 = Math.trunc(Math.random() * 26);
        
        name += Robot.ALPHABET.charAt(pos0);
        name += Robot.ALPHABET.charAt(pos1);
        name = name.concat(Math.trunc((Math.random() * 10)).toString());
        name = name.concat(Math.trunc((Math.random() * 10)).toString());
        name = name.concat(Math.trunc((Math.random() * 10)).toString());

        return name;
    }
}

Robot.releaseNames = () => {};



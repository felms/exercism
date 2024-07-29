export class Clock {

    #hours;
    #minutes;

    constructor(hours, minutes = 0) {
        if (minutes >= 60) {
            hours += Math.floor(minutes / 60);
        }

        while (minutes < 0) {
            hours--;
            minutes += 60;
        }

        while (hours < 0) {
            hours += 24;
        }

        this.#hours = hours % 24;
        this.#minutes = minutes % 60;
    }

    toString() {
        let h = String(this.#hours).padStart(2, '0');
        let m = String(this.#minutes).padStart(2, '0');
        return `${h}:${m}`
    }

    plus(minutes) {
        return new Clock(this.#hours, this.#minutes + minutes);
    }

    minus(minutes) {
        return new Clock(this.#hours, this.#minutes - minutes);
    }

    equals(otherClock) {
        return this.toString() === otherClock.toString();
    }
}

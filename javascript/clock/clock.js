export class Clock {
  constructor(hours = 0, minutes = 0) {
    let h = hours;
    while (h < 0) {
      h += 24;
    }

    this.minutes = h * 60 + minutes;

    let dayInMinutes = 24 * 60;
    while(this.minutes < 0) {
      this.minutes += dayInMinutes;
    }
  }

  toString() {
    let h = (Math.floor(this.minutes / 60)) % 24;
    let m = this.minutes % 60;
    h = h >= 10 ? h : '0' + h;
    m = m >= 10 ? m: '0' + m;
    return `${h}:${m}`;
  }

  plus(minutes) {
    this.minutes += minutes;
    return new Clock(0, this.minutes);
  }

  minus(minutes) {
    this.minutes -= minutes;
    return new Clock(0, this.minutes);;
  }

  equals(other) {
    return this.toString() === other.toString();
  }
}

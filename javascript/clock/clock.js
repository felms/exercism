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
    return this;
  }

  minus(minutes) {
    this.minutes -= minutes;
    let dayInMinutes = 24 * 60;
    while(this.minutes < 0) {
      this.minutes += dayInMinutes;
    }
    return this;
  }

  equals(other) {
    let thisH = (Math.floor(this.minutes / 60)) % 24;
    let thisM = this.minutes % 60;
    thisH = thisH >= 10 ? thisH : '0' + thisH;
    thisM = thisM >= 10 ? thisM: '0' + thisM;

    let otherH = (Math.floor(other.minutes / 60)) % 24;
    let otherM = other.minutes % 60;
    otherH = otherH >= 10 ? otherH : '0' + otherH;
    otherM = otherM >= 10 ? otherM: '0' + otherM;


    return (thisH === otherH) && (thisM === otherM);
  }
}

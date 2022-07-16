export const say = (number) => {

    if (number < 0 || number > 999_999_999_999) {
        throw new Error('Number must be between 0 and 999,999,999,999.');
    }

    let s = '';
    if (number === 0) {
        return 'zero';
    }

    s = oneToOneThousand(number);

    let th = number % 1_000_000;
    th = Math.trunc(th / 1000);
    if (th > 0) {
        s = oneToOneThousand(th) + ' thousand ' + s;
    }

    let m = number % 1_000_000_000;
    m = Math.trunc(m / 1_000_000);
    if (m > 0) {
        s = oneToOneThousand(m) + ' million ' + s;
    }

    let b = number % 1_000_000_000_000;
    b = Math.trunc(b / 1_000_000_000);
    if (b > 0) {
        s = oneToOneThousand(b) + ' billion ' + s;
    }

    return s.trim();

};

const oneToOneThousand = (number) => {        

    let s = '';

    let u = number % 10;
    s += units(u);

    let t = number % 100;

    if (t > 10 && t < 20) {
        s = teens(t);
    } else if (t >= 20) {
        t -= u;
        if (u == 0) {
            s = tens(t);
        } else {
            s = tens(t) + '-' + s;
        }
    }

    let h = number % 1000;
    h = Math.trunc(h / 100);
    if (h > 0) {
        s = units(h) + ' hundred ' + s;
    }

    return s.trim();
};

const units = (number) => {
    switch (number) {
        case 1:
            return 'one';
        case 2:
            return 'two';
        case 3:
            return 'three';
        case 4:
            return 'four';
        case 5:
            return 'five';
        case 6:
            return 'six';
        case 7:
            return 'seven';
        case 8:
            return 'eight';
        case 9:
            return 'nine';
        default:
            return '';

    }
};

const teens = (number) => {

    switch (number) {
        case 11:
            return 'eleven';
        case 12:
            return 'twelve';
        case 13:
            return 'thirteen';
        case 14:
            return 'fourteen';
        case 15:
            return 'fifteen';
        case 16:
            return 'sixteen';
        case 17:
            return 'seventeen';
        case 18:
            return 'eighteen';
        case 19:
            return 'nineteen';
        default:
            return '';
    }
};

const tens = (number) => {

    switch (number) {
        case 10:
            return 'ten';
        case 20:
            return 'twenty';
        case 30:
            return 'thirty';
        case 40:
            return 'forty';
        case 50:
            return 'fifty';
        case 60:
            return 'sixty';
        case 70:
            return 'seventy';
        case 80:
            return 'eighty';
        case 90:
            return 'ninety';
        default:
            return '';
    }
}

const EARTH_YEAR = 31557600;

export const age = (planet, timeInSeconds) => {
    let orbitalPeriod = 0.0;
    switch (planet) {
        case 'mercury':
            orbitalPeriod = 0.2408467;
            break;
        case 'venus':
            orbitalPeriod = 0.61519726;
            break;
        case 'earth':
            orbitalPeriod = 1.0;
            break;
        case 'mars':
            orbitalPeriod = 1.8808158;
            break;
        case 'jupiter':
            orbitalPeriod = 11.862615;
            break;
        case 'saturn':
            orbitalPeriod = 29.447498;
            break;
        case 'uranus':
            orbitalPeriod = 84.016846;
            break;
        case 'neptune':
            orbitalPeriod = 164.79132;
            break;

    };

    let age = (timeInSeconds / EARTH_YEAR) / orbitalPeriod;

    return Number(age.toFixed(2));
};

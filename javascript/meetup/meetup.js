const dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 
    'Thursday', 'Friday', 'Saturday'];

const schedulePossibilities = ['first','second', 'third', 'fourth', 'last', 'teenth'];

export const meetup = (year, month, meetupSchedule, dayOfWeek) => {

    if (meetupSchedule === 'teenth') {
        return calcTeenth(year, month, dayOfWeek);
    }

    if (meetupSchedule === 'last') {
        return calcLast(year, month, dayOfWeek);
    }

    return calcDay(year, month, meetupSchedule, dayOfWeek);

};

const calcTeenth = (year, month, dayOfWeek) => {

    let date = new Date(year, month - 1, 13);
    let targetDay = dayNames.findIndex(day => day === dayOfWeek);

    while (date.getDay() != targetDay) {
        date.setDate(date.getDate() + 1);
    }

    return date;
};

const calcLast = (year, month, dayOfWeek) => {

    let date = new Date(year, month, 1); 
    date.setDate(date.getDate() - 1);

    let targetDay = dayNames.findIndex(day => day === dayOfWeek);

    while (date.getDay() != targetDay) {
        date.setDate(date.getDate() - 1);
    }

    return date;
};

const calcDay = (year, month, meetupSchedule, dayOfWeek) => {

    let date = new Date(year, month - 1, 1); 

    let targetDay = dayNames.findIndex(day => day === dayOfWeek);

    while (date.getDay() != targetDay) {
        date.setDate(date.getDate() + 1);
    }

    let daysToAdd = 7 * schedulePossibilities
        .findIndex(schedule => schedule === meetupSchedule);

    date.setDate(date.getDate() + daysToAdd);
    return date;
};

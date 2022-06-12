export const meetup = (year, month, descriptor, dayOfweek) => {

  let day = 1;
  let dateString = `${year}-${month}-${day}`;
  const date = new Date(dateString);
  const desiredDay = getDayOfWeek(dayOfweek);


  switch (descriptor) {
    case 'first':
        return handleOffset(date, 0, desiredDay);
    case 'second':
        return handleOffset(date, 1, desiredDay);
    case 'third':
        return handleOffset(date, 2, desiredDay);
    case 'fourth':
        return handleOffset(date, 3, desiredDay);
    case 'last':
        return handleLast(date, desiredDay);
    case 'teenth':
        return handleTeenth(date, desiredDay);
  }

  return date;

};

const handleOffset = (date, weeksToAdd, desiredDay) => {

  let offset = weeksToAdd * 7;

  if (date.getDay() === desiredDay) {
    let day = date.getDate();
    day += offset;
    date.setDate(day);
    return date;
  }

  let daysToAdd = desiredDay - date.getDay();
  offset += daysToAdd > 0 ? daysToAdd : daysToAdd + 7;

  let day = date.getDate();
  day += offset;
  date.setDate(day);
  return date;

}

const handleLast = (date, desiredDay) => {

  let lastDayOfMonth = new Date(date.getFullYear(), date.getMonth() + 1, 0);

  if (lastDayOfMonth.getDay() === desiredDay) {
    return lastDayOfMonth;
  }
  
  let offset = desiredDay - lastDayOfMonth.getDay();
  offset = offset > 0 ? offset - 7 : offset;

  let day = lastDayOfMonth.getDate();
  day += offset;
  lastDayOfMonth.setDate(day);
  return lastDayOfMonth;

}

const handleTeenth = (date, desiredDay) => {
  let firstTeenth = new Date(date.getFullYear(), date.getMonth(), 13);

  let teenthDayOfWeek = firstTeenth.getDay();

  if (teenthDayOfWeek == desiredDay) {
    return firstTeenth;
  }

  let offset = desiredDay - teenthDayOfWeek;
  offset = offset > 0 ? offset : offset + 7;

  let day = firstTeenth.getDate();
  day += offset;
  firstTeenth.setDate(day);
  return firstTeenth;

}

const getDayOfWeek = (dayOfweek) => {

  let day = -1;

  switch (dayOfweek) {
    case 'Sunday':
      day = 0;
      break;
    case 'Monday':
      day = 1;
      break;
    case 'Tuesday':
      day = 2;
      break;
    case 'Wednesday':
      day = 3;
      break;
    case 'Thursday':
      day = 4;
      break;
    case 'Friday':
      day = 5;
      break;
    case 'Saturday':
      day = 6;
      break;
  }

  return day;
}
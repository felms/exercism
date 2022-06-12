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
    // case 'last':
    //     return handleLast(date, 0);
    // case 'teenth':
    //     return handleTeenth(date, 0);
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
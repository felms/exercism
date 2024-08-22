import datetime
from datetime import date


# subclassing the built-in ValueError to create MeetupDayException
class MeetupDayException(ValueError):
    """Exception raised when the Meetup weekday and count do not result in a valid date.

    message: explanation of the error.

    """

    def __init__(self, message):
        self.message = message
        super().__init__(self.message)


weeekdays = ["Monday", "Tuesday", "Wednesday", "Thursday",
             "Friday", "Saturday", "Sunday"]

week_values = ["first", "second", "third", "fourth", "fifth", "teenth", "last"]


def meetup(year, month, week, day_of_week):

    if (week == "teenth"):
        return calc_teenth(year, month, day_of_week)

    if (week == "last"):
        return calc_last(year, month, day_of_week)

    return calc_day(year, month, week, day_of_week)


def calc_teenth(year, month, day_of_week):

    teenth_date = date(year, month, 13)

    day_number = weeekdays.index(day_of_week)

    while (teenth_date.weekday() != day_number):
        teenth_date = teenth_date + datetime.timedelta(days=1)

    return teenth_date


def calc_last(year, month, day_of_week):

    y = year + 1 if month == 12 else year
    m = 1 if month == 12 else month + 1

    last_date = date(y, m, 1)
    last_date = last_date - datetime.timedelta(days=1)

    day_number = weeekdays.index(day_of_week)

    while (last_date.weekday() != day_number):
        last_date = last_date - datetime.timedelta(days=1)

    return last_date


def calc_day(year, month, week, day_of_week):

    meetup_date = date(year, month, 1)

    day_number = weeekdays.index(day_of_week)

    while (meetup_date.weekday() != day_number):
        meetup_date = meetup_date + datetime.timedelta(days=1)

    days_to_add = week_values.index(week) * 7
    meetup_date = meetup_date + datetime.timedelta(days=days_to_add)

    if meetup_date.month != month:
        raise MeetupDayException("That day does not exist.")

    return meetup_date

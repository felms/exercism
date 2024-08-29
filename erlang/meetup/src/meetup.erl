-module(meetup).

-export([meetup/4]).


meetup(Year, Month, DayOfWeek, teenth) -> 
    calc_teenth(calendar:date_to_gregorian_days(Year, Month, 13), day_of_week_to_daynum(DayOfWeek), calendar:day_of_the_week(Year, Month, 13));
meetup(Year, Month, DayOfWeek, last) -> calc_last(calc_last_day(Year, Month), day_of_week_to_daynum(DayOfWeek), calendar:day_of_the_week(calc_last_day(Year, Month)));
meetup(Year, Month, DayOfWeek, Schedule) -> 
    calc_meetup(calc_first_day(Year, Month, 1, day_of_week_to_daynum(DayOfWeek), calendar:day_of_the_week(Year, Month, 1)), Schedule).


calc_teenth(GregorianDays, X, X) -> calendar:gregorian_days_to_date(GregorianDays);
calc_teenth(GregorianDays, DayOfWeek, _) -> 
        calc_teenth(GregorianDays + 1, DayOfWeek, calendar:day_of_the_week(calendar:gregorian_days_to_date(GregorianDays + 1))).

calc_last({Year, Month, Day}, X, X) -> {Year, Month, Day};
calc_last({Year, Month, Day}, DayOfWeek, _) -> calc_last({Year, Month, Day - 1}, DayOfWeek, calendar:day_of_the_week(Year, Month, Day - 1)).

calc_meetup({Year, Month, Day}, first) -> {Year, Month, Day};
calc_meetup({Year, Month, Day}, second) -> {Year, Month, Day + 7};
calc_meetup({Year, Month, Day}, third) -> {Year, Month, Day + 14};
calc_meetup({Year, Month, Day}, fourth) -> {Year, Month, Day + 21};
calc_meetup({Year, Month, Day}, fifth) -> {Year, Month, Day + 28}.

calc_last_day(Year, Month) -> {Year, Month, calendar:last_day_of_the_month(Year, Month)}.

calc_first_day(Year, Month, Day, X, X) -> {Year, Month, Day};
calc_first_day(Year, Month, Day, DayOfWeek, _) -> calc_first_day(Year, Month, Day + 1, DayOfWeek, calendar:day_of_the_week(Year, Month, Day + 1)).

day_of_week_to_daynum(DayOfWeek) -> 
    case DayOfWeek of
        monday      -> 1;
        tuesday     -> 2;
        wednesday   -> 3;
        thursday    -> 4;
        friday      -> 5;
        saturday    -> 6;
        sunday      -> 7
    end.

-module(meetup).

-export([meetup/4]).


meetup(Year, Month, DayOfWeek, teenth) -> 
    calc_teenth(calendar:date_to_gregorian_days(Year, Month, 13), day_of_week_to_daynum(DayOfWeek), calendar:day_of_the_week(Year, Month, 13));
meetup(Year, Month, DayOfWeek, last) -> calc_last(Year, Month, calendar:last_day_of_the_month(Year, Month), DayOfWeek);
meetup(Year, Month, _DayOfWeek, _) -> {Year, Month, 1}.


calc_teenth(GregorianDays, X, X) -> calendar:gregorian_days_to_date(GregorianDays);
calc_teenth(GregorianDays, DayOfWeek, _) -> 
        calc_teenth(GregorianDays + 1, DayOfWeek, calendar:day_of_the_week(calendar:gregorian_days_to_date(GregorianDays + 1))).


calc_last(Year, Month, Day, _DayOfWeek) -> {Year, Month, Day}.


day_of_week_to_daynum(monday) -> 1;
day_of_week_to_daynum(tuesday) -> 2;
day_of_week_to_daynum(wednesday) -> 3;
day_of_week_to_daynum(thursday) -> 4;
day_of_week_to_daynum(friday) -> 5;
day_of_week_to_daynum(saturday) -> 6;
day_of_week_to_daynum(sunday) -> 7.

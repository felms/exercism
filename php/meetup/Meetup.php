<?php

declare(strict_types=1);

function meetup_day(int $year, int $month, string $which, string $weekday): DateTimeImmutable
{
    if (strcmp($which, "teenth") == 0)
    {
        return teenth_day($year, $month, $weekday);
    }

    if (strcmp($which, "last") == 0)
    {
        return last_day($year, $month, $weekday);
    }

    return calc_day($year, $month, $which, $weekday);
}

function teenth_day(int $year, int $month, string $weekday): DateTimeImmutable
{
    $weekdays = array("Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday");

    $res = new DateTimeImmutable("1972-01-01");
    $res = $res -> setDate($year, $month, 13);

    $day_of_the_week = array_search($weekday, $weekdays);

    $interval = DateInterval::createFromDateString("1 day");

    while (date("w", $res -> getTimeStamp()) != $day_of_the_week) {
        $res = $res -> add($interval);
    }

    return $res;
}

function last_day(int $year, int $month, string $weekday): DateTimeImmutable
{
    $weekdays = array("Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday");

    $res = new DateTimeImmutable("1972-01-01");
    $year = ($month == 12) ? $year + 1 : $year;
    $month = ($month == 12) ? 1 : $month + 1;
    $res = $res -> setDate($year, $month, 1);

    $day_of_the_week = array_search($weekday, $weekdays);

    $interval = DateInterval::createFromDateString("1 day");
    $res = $res -> sub($interval);

    while (date("w", $res -> getTimeStamp()) != $day_of_the_week) {
        $res = $res -> sub($interval);
    }

    return $res;
}

function calc_day(int $year, int $month, string $which, string $weekday): DateTimeImmutable
{
    $weekdays = array("Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday");

    $res = new DateTimeImmutable("1972-01-01");
    $res = $res -> setDate($year, $month, 1);

    $day_of_the_week = array_search($weekday, $weekdays);

    $interval = DateInterval::createFromDateString("1 day");

    while (date("w", $res -> getTimeStamp()) != $day_of_the_week) {
        $res = $res -> add($interval);
    }

    $schedule = array("first", "second", "third", "fourth", "teenth", "last");
    $days_to_add = array_search($which, $schedule) * 7;

    $res = $res -> add(DateInterval::createFromDateString("{$days_to_add} days"));

    return $res;
}


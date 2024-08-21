import java.time.DayOfWeek;
import java.time.LocalDate;

class Meetup {

    private int monthOfYear;
    private int year;

    Meetup(int monthOfYear, int year) {
        this.monthOfYear = monthOfYear;
        this.year = year;
    }

    LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule schedule) {
        return switch(schedule) {
            case MeetupSchedule.TEENTH -> calcTeenth(dayOfWeek);
            case MeetupSchedule.LAST -> calcLast(dayOfWeek);
            default -> calcNthDayOfWeek(dayOfWeek, schedule);
        };
    }

    private LocalDate calcTeenth(DayOfWeek dayOfWeek) {
        LocalDate date = LocalDate.of(this.year, this.monthOfYear, 13);

        while (date.getDayOfWeek() != dayOfWeek) {
            date = date.plusDays(1);
        }

        return date;
    }

    private LocalDate calcLast(DayOfWeek dayOfWeek) {

        LocalDate date = LocalDate.of(this.year, this.monthOfYear, 1)
                            .plusMonths(1).minusDays(1);

        while (date.getDayOfWeek() != dayOfWeek) {
            date = date.minusDays(1);
        }

        return date;
    }

    private LocalDate calcNthDayOfWeek(DayOfWeek dayOfWeek, MeetupSchedule schedule) {

        LocalDate date = LocalDate.of(this.year, this.monthOfYear, 1);

        while (date.getDayOfWeek() != dayOfWeek) {
            date = date.plusDays(1);
        }

        int daysToAdd = switch(schedule) {
            case MeetupSchedule.FIRST -> 0;
            case MeetupSchedule.SECOND -> 7;
            case MeetupSchedule.THIRD -> 14;
            case MeetupSchedule.FOURTH -> 21;
            default -> 0;
        };

        return date.plusDays(daysToAdd);
    }
}

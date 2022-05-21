import java.time.DayOfWeek;
import java.time.LocalDate;

public class Meetup {

    private LocalDate date;
    private DayOfWeek dayOfWeek;
    public Meetup(int month, int year) {
        this.date = LocalDate.of(year, month, 1);
        this.dayOfWeek = date.getDayOfWeek();
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule descriptor) {

        switch (descriptor) {
            case FIRST:
                return handleOffset(dayOfWeek, 0);
            case SECOND:
                return handleOffset(dayOfWeek, 1);
            case THIRD:
                return handleOffset(dayOfWeek, 2);
            case FOURTH:
                return handleOffset(dayOfWeek, 3);
            case LAST:
                return handleLast(dayOfWeek);
            case TEENTH:
                return handleTeenth(dayOfWeek);
        }

        return null;
    }

    private LocalDate handleOffset(DayOfWeek dayOfWeek, long weeksToAdd) {

        long offset = weeksToAdd * 7;

        if (this.dayOfWeek == dayOfWeek) {
            return this.date.plusDays(offset);
        }

        long daysToAdd = dayOfWeek.getValue() - this.dayOfWeek.getValue();
        offset += daysToAdd > 0 ? daysToAdd : daysToAdd + 7;

        return this.date.plusDays(offset);

    }

    private LocalDate handleLast(DayOfWeek dayOfWeek) {

        LocalDate lastDayOfTheMonth = this.date.plusDays(this.date.lengthOfMonth())
                                    .minusDays(1);
        
        DayOfWeek lastDayOfWeek = lastDayOfTheMonth.getDayOfWeek();

        if (lastDayOfWeek == dayOfWeek) {
            return lastDayOfTheMonth;
        }

        long offset = dayOfWeek.getValue() - lastDayOfWeek.getValue();
        offset = offset > 0 ? offset - 7 : offset;

        return lastDayOfTheMonth.plusDays(offset);

    }

    private LocalDate handleTeenth(DayOfWeek dayOfWeek) {

        LocalDate firstTeenth = LocalDate.of(this.date.getYear(), 
                                            this.date.getMonth(), 
                                            13);
        
        DayOfWeek teenthDayOfWeek = firstTeenth.getDayOfWeek();

        if (teenthDayOfWeek == dayOfWeek) {
            return firstTeenth;
        }

        long offset = dayOfWeek.getValue() - teenthDayOfWeek.getValue();
        offset = offset > 0 ? offset : offset + 7;

        return firstTeenth.plusDays(offset);

    }
}
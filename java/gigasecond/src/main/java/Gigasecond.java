import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Gigasecond {

    private LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment, LocalTime.of(0, 0, 0)));
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        long gigasecond = 1_000_000_000;
        return this.moment.plus(gigasecond, ChronoUnit.SECONDS);
    }
}

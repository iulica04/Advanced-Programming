import java.time.LocalDate;
import java.time.LocalDateTime;
public class PeriodOfTime extends Pair<LocalDate, LocalDate> {

    PeriodOfTime(LocalDate first, LocalDate second)
    {
        super(first, second);
        if (!first.isBefore(second)) {
            throw new IllegalArgumentException("First period of time must be before second period of time");
        }
    }
}

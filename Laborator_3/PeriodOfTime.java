import java.time.LocalDate;
import java.time.LocalDateTime;
public class PeriodOfTime extends Pair<LocalDateTime, LocalDateTime> {

    PeriodOfTime(LocalDateTime first, LocalDateTime second)
    {
        super(first, second);
        if (!first.isBefore(second)) {
            throw new IllegalArgumentException("First period of time must be before second period of time");
        }
    }
}

import java.time.LocalTime;
public class TimeInterval extends Pair<LocalTime, LocalTime> {
    TimeInterval(LocalTime first, LocalTime second)
    {
        super(first, second);
        if (!first.isBefore(second)) {
            throw new IllegalArgumentException("First time must be before second time");
        }
    }


}

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;
public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();
}

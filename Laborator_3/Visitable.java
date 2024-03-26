import java.time.*;
import java.util.Map;
public interface Visitable {
    Map<DayOfWeek, TimeInterval> getTimetable();
    void setTimetable(Map<DayOfWeek, TimeInterval> timetable);
    default LocalTime getOpeningHour(DayOfWeek date)
    {
        TimeInterval timeInterval = getTimetable().get(date);

        if(timeInterval == null)
            throw new IllegalArgumentException("Nu exista orar pentru data specificata.");

        return timeInterval.getFirst();
    }

    default LocalTime getClosingHour(DayOfWeek date)
    {
        TimeInterval timeInterval = getTimetable().get(date);

        if(timeInterval == null)
            throw new IllegalArgumentException("Nu exista orar pentru data specificata.");

        return timeInterval.getSecond();
    }

}

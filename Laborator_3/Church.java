import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction implements Visitable{

    private Map<LocalDate, TimeInterval> timetable;

    Church(String name, String description, String location)
    {
        setName(name);
        setDescription(description);
        setLocation(location);
        timetable = new HashMap<>();
    }
    @Override
    public Map<LocalDate, TimeInterval> getTimetable()
    {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }


}

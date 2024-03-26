import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable{
    private Map<DayOfWeek, TimeInterval> timetable;

    Statue(String name, String description, String location){
        setName(name);
        setDescription(description);
        setLocation(location);
        timetable = new HashMap<>();
    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable)
    {
        this.timetable = timetable;
    }


}

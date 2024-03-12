import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable{
    private Map<LocalDate, TimeInterval> timetable;

    Statue(String name, String description, String location){
        setName(name);
        setDescription(description);
        setLocation(location);
        timetable = new HashMap<>();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return null;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
}

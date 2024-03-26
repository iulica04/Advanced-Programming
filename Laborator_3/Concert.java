import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable{
    private double ticketPrice;
    private Map<DayOfWeek, TimeInterval> timetable;

    Concert(String name, String description, String location)
    {
        setName(name);
        setDescription(description);
        setLocation(location);
        timetable = new HashMap<>();
    }

    @Override
    public double getTicketPrice()
    {
        return ticketPrice;
    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable()
    {
        return timetable;
    }

    @Override
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable)
    {
        this.timetable = timetable;
    }



    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


}

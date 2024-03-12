import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable{
    private double ticketPrice;
    private Map<LocalDate, TimeInterval> timetable;

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
    public Map<LocalDate, TimeInterval> getTimetable()
    {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable)
    {
        this.timetable = timetable;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


}
